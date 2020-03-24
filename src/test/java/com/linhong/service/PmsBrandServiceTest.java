package com.linhong.service;

import com.linhong.mbg.mapper.PmsBrandMapper;
import com.linhong.mbg.model.PmsBrand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsBrandServiceTest {

    @Autowired
    private PmsBrandService pmsBrandService;

    @Test
    public void testListAllBrand(){
        List<PmsBrand> pmsBrands = pmsBrandService.listAllBrand();
        Assert.assertNotNull(pmsBrands);
    }

    /**
     *  模拟200个并发请求数据库操作
     */
    public static int num = 2;
    int a = 0;
    CountDownLatch countDownLatch = new CountDownLatch(num);

    @Test
    public void testBf(){
        for (int i =0 ;i<num; i++){
            new Thread(new myThread()).start();
            countDownLatch.countDown();
        }
    }

    class myThread implements Runnable{

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            List<PmsBrand> pmsBrands = pmsBrandService.listAllBrand();
            System.out.println("次数==========="+a++);

        }
    }

}

