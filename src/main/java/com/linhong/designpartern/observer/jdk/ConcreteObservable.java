package com.linhong.designpartern.observer.jdk;

import java.util.Observable;

/**
 * 被观察者（主题）
 */
public class ConcreteObservable extends Observable {

    public void dataChanged(String msg) {
        setChanged();
        notifyObservers(msg);
    }
}
