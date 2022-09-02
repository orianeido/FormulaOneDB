package com.example.formulaone.Controller;

import com.example.formulaone.Model.DBConnect;
import com.example.formulaone.Model.GrandPrix;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.ResourceBundle;

public class grandPrixResultsViewController implements Initializable {


    @FXML
    private Label txt_name;

    @FXML
    private Label txt_circuit;

    @FXML
    private Label txt_type;

    @FXML
    private Label txt_direction;

    @FXML
    private Label txt_length;

    @FXML
    private Label txt_eventAmount;

    @FXML
    private ImageView circuit_image;

    @FXML
    private Button delete_button;

    @FXML
    private Button return_button;

    GrandPrix grandPrixData;
    private String searchText;


    public void UpdateInfo() throws IOException {
        grandPrixData = DBConnect.getGrandPrixData(this.searchText);

        if (grandPrixData == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Grand Prix Not Found");
            alert.showAndWait();
        }

        txt_name.setText(grandPrixData.getName());
        txt_circuit.setText(grandPrixData.getCircuit());
        txt_type.setText(String.valueOf(grandPrixData.getType()));
        txt_direction.setText(String.valueOf(grandPrixData.getDirection()));
        txt_length.setText(String.valueOf(grandPrixData.getLength()));
        txt_eventAmount.setText(String.valueOf(grandPrixData.getEventAmount()));

       /* URL url = new URL(grandPrixData.getUrl());
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(url.toString())));
        circuit_image.setImage(image);*/
        Path imageFile = (Path) Paths.get(grandPrixData.getUrl());
        circuit_image.setImage(new Image(String.valueOf(imageFile)));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void getSearchText(String searchText){
        this.searchText = searchText;
    }

    public void returnToSearchView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/search-view.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void deleteGrandPrix(ActionEvent actionEvent) throws IOException {
        if (DBConnect.deleteGrandPrix(this.searchText) == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Deleted Successfully");
            alert.showAndWait();
            returnToSearchView(actionEvent);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Delete Failed");
            alert.showAndWait();
        }
    }
}

