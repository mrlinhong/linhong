package com.linhong.designpartern.strategy;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        PromotionActivity promotionActivity618 = new PromotionActivity(new LiJianPromotionStrategy());
        PromotionActivity promotionActivity1111 = new PromotionActivity(new FanXianPromotionStrategy());

        promotionActivity618.executePromotionStrategy();
        promotionActivity1111.executePromotionStrategy();

        // 大量if else优化的话，可以把这些策略放在map工厂中，再根据路由健去获取即可
    }
}
