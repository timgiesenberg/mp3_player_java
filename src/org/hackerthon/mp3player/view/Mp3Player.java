/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hackerthon.mp3player.view;

import java.io.File;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hackerthon.mp3player.controller.Mp3PlayerController;

/**
 *
 * @author edwardfakhouri
 */
public class Mp3Player extends Application {

    private static final Logger LOGGER = Logger.getLogger(Mp3Player.class.getName());
    
    @Override
    public void start(final Stage primaryStage) {
        Button playButton = new Button("Play");
        playButton.setId("play_button");
        Button stopButton = new Button("Stop");
        stopButton.setId("stopButton");
        Button pauseButton = new Button("Pause");
        stopButton.setId("pauseButton");
        
        
        BorderPane border = new BorderPane();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(playButton,pauseButton, stopButton);
        
        border.setTop(hBox);
        primaryStage.setScene(new Scene(border, 600, 350));
        primaryStage.show();
        
        playButton.setOnAction(new Mp3PlayerController(primaryStage));
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}