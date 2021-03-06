/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mef;

import java.io.File;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import mef.controller.FXMLMainController;

/**
 *
 * @author danie
 */
public class Mef extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Font.loadFont(getClass().getResourceAsStream("/mef/fonts/pokemon_fire_red.ttf"),25);
        Parent root = FXMLLoader.load(getClass().getResource("/mef/views/FXMLMain.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);

        AudioClip sound = new AudioClip(this.getClass().getResource("/mef/nature.mp3").toExternalForm());
        sound.play();
        stage.setTitle("Proccessi");
        stage.setResizable(false);
        stage.getIcons().add(new Image("/img/icon.png"));
        stage.show();
        
        //Fade Transition
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), root);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(10);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(true);
        fadeIn.play();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
