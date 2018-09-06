package cn.glbb.view;

import cn.glbb.controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;


public class View extends Application implements Observer{
    private Controller controller = new Controller();

    @Override
    public void start(Stage primaryStage) throws Exception {
        controller.setPrimaryStage(primaryStage);
        controller.initView(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if("addData".equals(arg)){
            controller.update(o);
        }
    }
}
