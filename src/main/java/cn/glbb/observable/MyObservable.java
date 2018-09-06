package cn.glbb.observable;

import cn.glbb.data.Data;
import cn.glbb.observer.MyObserver;

import java.util.ArrayList;
import java.util.Observable;

public class MyObservable extends Observable {
    private ArrayList<Data> list = new ArrayList<>();
    MyObserver myObserver = new MyObserver();

    public void add(Data data){
        list.add(data);
        super.addObserver(myObserver);
        setChanged();
        notifyObservers("11111");
//        notify();
        System.out.println(hasChanged());
    }
}
