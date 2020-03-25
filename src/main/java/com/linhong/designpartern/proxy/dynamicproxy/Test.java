package com.linhong.designpartern.proxy.dynamicproxy;


import com.linhong.designpartern.proxy.IOrderService;
import com.linhong.designpartern.proxy.Order;
import com.linhong.designpartern.proxy.OrderServiceImpl;

/**
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
//        order.setUserId(2);
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();

        orderServiceDynamicProxy.saveOrder(order);
    }
}
