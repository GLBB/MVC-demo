package cn.glbb.controller;

import cn.glbb.data.Data;
import cn.glbb.model.Model;
import cn.glbb.view.View;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Observable;

public class Controller {
    private Model model = new Model();

    private Stage primaryStage;
    private GridPane gridPane = new GridPane();
    private View view;

    public void setView(View view){
        this.view = view;
    }

    public View getView(){
        return view;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void handleMessage(String id, String name){
        Integer int_id = Integer.parseInt(id);
        model.addData(int_id,name,view);
    }

    public void initView(View view){
        setView(view);

        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane,500,400);
        primaryStage.setScene(scene);
        primaryStage.show();

        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().add(new ColumnConstraints(100));
        gridPane.getColumnConstraints().add(new ColumnConstraints(100));
        borderPane.setCenter(gridPane);

        Label label_id = new Label("id");
        Label label_name = new Label("name");
        gridPane.add(label_id,0,0);
        gridPane.add(label_name,1,0);

        HBox hBox = new HBox();
        TextField textField_id = new TextField();
        TextField textField_name = new TextField();
        Button button = new Button("submit");
        hBox.getChildren().addAll(new Label("id"),textField_id,new Label("name"),textField_name,button);
        borderPane.setBottom(hBox);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String id = textField_id.getText();
                String name = textField_name.getText();
                handleMessage(id,name);
            }
        });
    }

    public void update(Observable o){
        int size = gridPane.getChildren().size();
        Model model = (Model) o;
        List<Data> list = model.getList();
        int row = 1;
        for(Data data:list){
            Label id = new Label(data.getId()+"");
            Label name = new Label(data.getName());
            gridPane.add(id,0,row);
            gridPane.add(name,1,row);
            row++;
        }
    }
}
