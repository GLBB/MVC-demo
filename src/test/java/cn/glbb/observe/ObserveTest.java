package cn.glbb.observe;

import cn.glbb.data.Data;
import cn.glbb.observable.MyObservable;
import org.junit.Test;

public class ObserveTest {

    @Test
    public void test1(){
        MyObservable myObservable = new MyObservable();
        Data data = new Data();
        data.setId(18);
        data.setName("lihua");
        myObservable.add(data);
    }
}
