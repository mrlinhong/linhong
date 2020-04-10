package com.linhong.designpartern.observer.jdk;

public class ObserverDemo {

    public static void main(String[] args) {
        // 添加第一个观察者
        ObserverA observerA = new ObserverA();
        ConcreteObservable observable = new ConcreteObservable();
        observable.addObserver(observerA);
        observable.dataChanged("第一次发生变化");
        System.out.println("观察者数量" + observable.countObservers());

        // 添加第二个观察者
        ObserverB observerB = new ObserverB();
        observable.addObserver(observerB);
        observable.dataChanged("第二次发生变化");
        System.out.println("观察者数量" + observable.countObservers());
    }
}
