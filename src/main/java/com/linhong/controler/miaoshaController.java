package com.linhong.controler;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 分布式锁秒杀场景
 *
 * 加锁有如下注意事项：
 *
 * 加锁需要设置超时时间，防止出现死锁
 * 加锁以及设置超时时间的时候，需要保证两个操作的原子性，因而最好使用lua脚本或者使用支持NX以及EX的set方法
 * 加锁的时候需要把加锁的调用方信息，比如线程id给记录下来，这个在解锁的时候需要使用
 * 对于加锁时长不确定的任务，为防止任务未执行完导致超时被释放，需要对尚未运行完的任务延长失效时间
 * 解锁有如下注意事项：
 *
 * 解锁一系列操作(判断key是否存在，存在的话删除key等)需要保证原子性，因而最好使用lua脚本
 * 解锁需要判断调用方是否与加锁时记录的是否一致，防止锁被误删
 * 如果有延续失效时间的延时任务，在解锁的时候，需要终止掉该任务
 */

@RestController
public class miaoshaController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Redisson redisson;

    @GetMapping("/helloworld")
    public String hello(){

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        return "hello linhong, 当前时间是：" + format.format(new Date());
    }

    // https://baijiahao.baidu.com/s?id=1655515801283332550&wfr=spider&for=pc 基本实现这边介绍的不错
    @GetMapping("/deduct/stock")
    public String miaosha(){

        String lockKey = "product_001";
        String clientId = UUID.randomUUID().toString();

        RLock lock = redisson.getLock(lockKey);
        try{
//            Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(lockKey, clientId,10, TimeUnit.SECONDS);
//            redisTemplate.expire(lockKey,10, TimeUnit.SECONDS); 合并上面代码，保证原子性
//            // 如果系统挂了，怎么办，锁还没有释放，所以需要设置redis过期时间
//            if (!aBoolean){
//                return "error...";
//            }

            // 超时怎么办，业务没执行玩，上面10毫秒超时怎么办，需要锁住，延长加锁时间，这边使用redission分布式锁实现
            lock.lock(30,TimeUnit.SECONDS);

            int stock = Integer.parseInt(redisTemplate.opsForValue().get("product_stock"));
            if (stock > 0){
                int realStock = stock - 1;
                redisTemplate.opsForValue().set("product_stock",realStock + "");
                System.out.println("库存扣减成功，剩余库存" + realStock);
            } else{
                System.out.println("扣减失败，库存不足。。。。");
            }
        }finally {

            // redission这getLock, lock ,unlock 等价于上面分布式锁功能
            lock.unlock();
//            if (clientId.equals(redisTemplate.opsForValue().get(lockKey))){
//                // 释放锁,自己线程只能删除自己线程的锁
//                redisTemplate.delete(lockKey);
//            }

        }

        return "end";
    }
}
