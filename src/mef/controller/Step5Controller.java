/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mef.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class Step5Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    ImageView btnNext;
    
    @FXML
    AnchorPane sPane;    
    @FXML private void goToNext(javafx.scene.input.MouseEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/mef/views/step6.fxml"));
        Scene scene = btnNext.getScene();
        
        AudioClip sound = new AudioClip(this.getClass().getResource("/sounds/click.mp3").toExternalForm());
        sound.play();
        
        root.translateXProperty().set(scene.getWidth());
        StackPane parentContainer = (StackPane) scene.getRoot();
        parentContainer.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateXProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished((event) -> {
            parentContainer.getChildren().remove(sPane);
        });
        timeline.play();
    }
    
}
