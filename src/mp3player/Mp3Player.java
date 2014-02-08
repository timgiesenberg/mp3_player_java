/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp3player;

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

/**
 *
 * @author edwardfakhouri
 */
public class Mp3Player extends Application {

    private static final Logger LOGGER = Logger.getLogger(Mp3Player.class.getName());
    
    @Override
    public void start(final Stage primaryStage) {
        Button playButton = new Button("Play");
        Button stopButton = new Button("Stop");
        Button pauseButton = new Button("Pause");
        
        
        BorderPane border = new BorderPane();
        HBox hBox = new HBox();
        hBox.getChildren().addAll(playButton,pauseButton, stopButton);
        
        border.setTop(hBox);
        primaryStage.setScene(new Scene(border, 600, 350));
        primaryStage.show();
        
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {    
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Mp3 files (*.mp3)", "*.mp3");
                fileChooser.getExtensionFilters().add(extensionFilter);
                fileChooser.setTitle("Chose a mp3 file");
                File mp3 = fileChooser.showOpenDialog(primaryStage);
                String pathTomp3 = mp3.toURI().toString();
                playMp3(pathTomp3);
            }
        });
    }

    private void playMp3(String pathToMp3) {
        Media media = new Media(pathToMp3);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}