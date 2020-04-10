package com.linhong.designpartern.observer;


import java.util.ArrayList;
import java.util.List;

/**
 * 具体被观察者，也就是微信公众号服务
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 */
public class WeChatServer implements Observerable {

    private List<Observer> list;
    private String message;

    public WeChatServer() {
        list = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (!list.isEmpty()) {
            list.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer obs : list) {
            obs.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }

}