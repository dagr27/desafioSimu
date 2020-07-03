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
import javafx.scene.control.Label;
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
public class FXMLDomain1Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView fulano;
    
    @FXML
    ImageView sultano;
    
    @FXML
    Label lblDesc;
    
    @FXML
    Label lblDesc1;
    
    @FXML
    Label lblFulano;
    
    @FXML
    Label lblSultano;
    
    @FXML
    AnchorPane AnchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML private void goToDomain(javafx.scene.input.MouseEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/mef/views/FXMLDomain-2.fxml"));
        Scene scene = sultano.getScene();
        
        AudioClip sound = new AudioClip(this.getClass().getResource("/sounds/click.mp3").toExternalForm());
        sound.play();
        
        root.translateYProperty().set(scene.getWidth());
        StackPane parentContainer = (StackPane) scene.getRoot();
        parentContainer.getChildren().add(root);
        
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished((event) -> {
            parentContainer.getChildren().remove(AnchorPane);
        });
        timeline.play();
    }
    
    @FXML private void activate(javafx.scene.input.MouseEvent e) throws IOException{
        AudioClip sound = new AudioClip(this.getClass().getResource("/sounds/click.mp3").toExternalForm());
        sound.play();
        
        fulano.setVisible(true);
        sultano.setVisible(true);
        lblFulano.setVisible(true);
        lblSultano.setVisible(true);
        lblDesc.setText("Ellos son Fulano y Sultano");
        lblDesc1.setText("ellos te ayudaran con el resto del MEF, haz click sobre Sultano");
    }
    
}
