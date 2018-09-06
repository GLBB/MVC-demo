package cn.glbb.observer;

import cn.glbb.data.Data;
import cn.glbb.observable.MyObservable;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("我观察的对象改变了");
        MyObservable myObservable = (MyObservable) o;
        System.out.println(arg);
    }
}
