package com.linhong.designpartern.observer;


/***
 * 创建抽象被观察者（抽象主题），提供添加、删除和通知（抽象观察者）等方法
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 * @author linhong
 */

public interface Observerable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}
