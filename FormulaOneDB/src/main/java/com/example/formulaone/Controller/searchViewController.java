package com.example.formulaone.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class searchViewController implements Initializable {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField search_text;

    @FXML
    private Button search_button;

    @FXML
    private ImageView logo_image;

    @FXML
    ToggleGroup searchType;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void switchToDriversTable(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/drivers_table-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToConstructorsTable(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/constructors_table-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToGrandPrixsTable(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/grandPrixs_table-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAdminPanel(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/admin_panel-view.fxml")));
        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void search(ActionEvent actionEvent) throws IOException {
        RadioButton selectedRadioButton = (RadioButton) searchType.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();

        FXMLLoader loader = null;
        switch (toggleGroupValue) {
            case "Driver" -> {
                loader = new FXMLLoader(getClass().getResource("/driver_results-view.fxml"));
                root = loader.load();
                driverResultsViewController driverResultsViewController = loader.getController();
                driverResultsViewController.getSearchText(search_text.getText());
                driverResultsViewController.UpdateInfo();
            }
            case "Constructor" -> {
                loader = new FXMLLoader(getClass().getResource("/constructor_results-view.fxml"));
                root = loader.load();
                constructorResultsViewController constructorResultsViewController = loader.getController();
                constructorResultsViewController.getSearchText(search_text.getText());
                constructorResultsViewController.UpdateInfo();
            }
            case "Grand Prix" -> {
                loader = new FXMLLoader(getClass().getResource("/grand_prix_results-view.fxml"));
                root = loader.load();
                grandPrixResultsViewController grandPrixResultsViewController = loader.getController();
                grandPrixResultsViewController.getSearchText(search_text.getText());
                grandPrixResultsViewController.UpdateInfo();
            }
        }

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

