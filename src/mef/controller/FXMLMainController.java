/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mef.controller;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *
 * @author danie
 */
public class FXMLMainController implements Initializable {
    
    @FXML
    private Label lblText;
    
    @FXML
    private StackPane principal;
    
    @FXML AnchorPane home;
    
    @FXML
    private void handleButtonAction(MouseEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        
    }  
    
    
    @FXML private void goToModel(javafx.scene.input.MouseEvent e) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/mef/views/FXMLModel.fxml"));
        Scene scene = home.getScene();
        
        root.translateYProperty().set(scene.getHeight());
        principal.getChildren().add(root);
        
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(),0,Interpolator.EASE_IN);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.setOnFinished((event) -> {
            principal.getChildren().remove(home);
        });
        timeline.play();
    }
    
}
