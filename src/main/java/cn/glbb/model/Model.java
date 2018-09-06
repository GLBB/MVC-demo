package cn.glbb.model;

import cn.glbb.data.Data;
import cn.glbb.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

public class Model extends Observable{
    private List<Data> list = new ArrayList<>();

    public List<Data> getList() {
        return list;
    }

    public void setList(List<Data> list) {
        this.list = list;
    }

    public void addData(Data data){
        list.add(data);
    }

    public void addData(int id,String name,View view){
        Data data = new Data();
        data.setId(id);
        data.setName(name);
        addData(data);

        super.addObserver(view);

        super.setChanged();
        super.notifyObservers("addData");
    }
}
