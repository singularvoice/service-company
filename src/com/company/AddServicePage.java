package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import models.Service;
import models.User;
import network.JDBC;

import java.sql.Statement;


public class AddServicePage{

    public static void show(Stage stage, Scene previosScene, User user) {
        HBox root = new HBox();
        Button back = new Button("back");
        Label lSerivce = new Label("Service:");
        TextField tService = new TextField();
        Label lCost = new Label("Cost:");
        TextField tCost = new TextField();
        Button add = new Button("Add Serive");
        root.getChildren().addAll(back,lSerivce,tService,lCost,tCost,add);
        root.setSpacing(10);
        Scene currentScene = new Scene(root,previosScene.getWidth(),previosScene.getHeight());
        stage.setScene(currentScene);
        stage.setTitle("Add Service window");

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Service service = new Service(user.getUsername(),Integer.parseInt(tCost.getText()),tService.getText());
                JDBC.insert("services",service);
                tCost.clear();
                tService.clear();
                stage.setScene(previosScene);
                stage.show();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(previosScene);
                stage.show();
            }
        });

    }
}
