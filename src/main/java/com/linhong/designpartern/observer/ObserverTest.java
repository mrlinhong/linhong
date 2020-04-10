package com.linhong.designpartern.observer;

public class ObserverTest {

    /**
     * 参考文章：https://blog.csdn.net/zhourui_1021/article/details/83825389
     *
     * 步骤一：创建抽象观察者类（接口），定义一个更新的方法
     *
     * 步骤二：创建具体观察者，实现更新的方法
     *
     * 步骤三：创建抽象被观察者（抽象主题），提供添加、删除和通知（抽象观察者）等方法
     *
     * 步骤四：创建具体被观察者（继承/实现抽象被观察者），实现抽象被观察者的方法
     *
     * 步骤五：客户端调用
     */
    public static void main(String[] args) {
        //创建具体被观察者对象
        WeChatServer weChatServer = new WeChatServer();
        //创建具体观察者对象
        Observer userZhang = new User("张三");
        Observer userLi = new User("李四");
        Observer userWang = new User("王五");

        //具体被观察者注册具体观察者
        weChatServer.registerObserver(userZhang);
        weChatServer.registerObserver(userLi);
        weChatServer.registerObserver(userWang);
        weChatServer.setInfomation("PHP是世界上最好的语言");

        System.out.println("------------------------------------------------------");

        weChatServer.removeObserver(userZhang);

        weChatServer.setInfomation("PHP再好但是我学的是Java语言");
    }
}
