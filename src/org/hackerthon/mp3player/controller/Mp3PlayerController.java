/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hackerthon.mp3player.controller;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author edwardfakhouri
 */
public class Mp3PlayerController implements EventHandler<ActionEvent> {

    private final Stage primaryStage;
    private String mp3Path;
    private MediaPlayer mediaPlayer;

    public Mp3PlayerController(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @Override
    public void handle(ActionEvent t) {
        String buttonId = ((Button)t.getSource()).getId();
        
        if ("play_button".equals(buttonId)) {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extensionFilter = 
                new FileChooser.ExtensionFilter("Mp3 files (*.mp3)", "*.mp3");
            fileChooser.getExtensionFilters().add(extensionFilter);
            fileChooser.setTitle("Chose a mp3 file");
            File mp3 = fileChooser.showOpenDialog(getPrimaryStage());
            String pathTomp3 = mp3.toURI().toString();
            playMp3(pathTomp3);
        }
    }

    private void playMp3(String pathToMp3) {
        Media media = new Media(pathToMp3);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public String getMp3Path(){
        return mp3Path;
    }
    
    public void setMp3Path(String mp3Path) {
        this.mp3Path = mp3Path;
    }
    
    public MediaPlayer getMediaPlayer(){
        return mediaPlayer;
    }
    
    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }
    
}