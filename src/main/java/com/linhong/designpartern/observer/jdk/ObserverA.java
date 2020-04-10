package com.linhong.designpartern.observer.jdk;


import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ObserverA"+arg);

    }

}