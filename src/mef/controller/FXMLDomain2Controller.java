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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author danie
 */
public class FXMLDomain2Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    ImageView imgDomain;

    @FXML
    Label lblDesc;

    @FXML
    Label lblBox1;
    @FXML
    Label lblBox2;
    @FXML
    Label lblBox3;

    @FXML
    AnchorPane dPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void activate(javafx.scene.input.MouseEvent e) throws IOException {
        imgDomain.setVisible(true);
        lblDesc.setVisible(true);
        lblBox1.setText("Este sera el dominio que trabajaremos, genial/elegante/fresco no?");
        lblBox2.setText("Se ve representado por un cubo, aplicaremos condiciones de contorno");
        lblBox3.setText("y tocara construir la malla, click en el cubo para continuar");

    }

    @FXML
    private void showMesh(javafx.scene.input.MouseEvent e) throws IOException {
        dPane.setOnMouseClicked((ev) -> {
        });
        lblDesc.setText("Avanzar");

        lblDesc.setOnMouseClicked((event) -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/mef/views/FXMLTConectividades.fxml"));
                Scene scene = imgDomain.getScene();
                root.translateYProperty().set(scene.getWidth());
                StackPane parentContainer = (StackPane) scene.getRoot();
                parentContainer.getChildren().add(root);
                Timeline timeline = new Timeline();
                KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
                KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
                timeline.getKeyFrames().add(kf);
                timeline.setOnFinished((ev) -> {
                    parentContainer.getChildren().remove(dPane);
                });
                timeline.play();
            } catch (IOException err) {
                
            }

        });

        imgDomain.setImage(new Image(getClass().getResourceAsStream("/img/mesh/mesh-condition.jpeg")));
        lblBox1.setText("Genial, este es el mallado a utilizar, con sus condiciones de contorno");
        lblBox2.setText("en las esquinas del cub, es interesante ver como en la figura se cruzan");
        lblBox3.setText("lineas de un borde a otro, esas lineas representan el Mallado");
    }

}
