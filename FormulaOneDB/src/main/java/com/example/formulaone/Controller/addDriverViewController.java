package com.example.formulaone.Controller;

import com.example.formulaone.Model.DBConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class addDriverViewController implements Initializable {

    @FXML
    private TextField name_field;

    @FXML
    private TextField country_field;

    @FXML
    private TextField raceEntries_field;

    @FXML
    private TextField raceStarts_field;

    @FXML
    private TextField pole_field;

    @FXML
    private TextField wins_field;

    @FXML
    private TextField podiums_field;

    @FXML
    private TextField points_field;

    @FXML
    private TextField fl_field;

    @FXML
    private Button add_button;

    @FXML
    private Button return_button;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void returnToSearchView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/search-view.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void addDriver(ActionEvent actionEvent) throws IOException {

        String query;
        String name = name_field.getText();
        String country = country_field.getText();
        int raceEntries = 0, raceStarts = 0, pole = 0, win = 0, podiums = 0, points = 0, fl = 0;
        raceEntries = Integer.parseInt(raceEntries_field.getText());
        raceStarts = Integer.parseInt(raceStarts_field.getText());
        pole = Integer.parseInt(pole_field.getText());
        win = Integer.parseInt(wins_field.getText());
        podiums = Integer.parseInt(podiums_field.getText());
        points = Integer.parseInt(points_field.getText());
        fl = Integer.parseInt(fl_field.getText());

        if (name.isEmpty() || country.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();

        } else {
            query = getQuery();
            if (DBConnect.addDriver(query, name, country, raceEntries, raceStarts, pole, win, podiums, points, fl) != 1){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please Try Again");
                alert.showAndWait();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Driver Added Successfully");
                alert.showAndWait();
                returnToSearchView(actionEvent);
            }
        }
    }

    private String getQuery() {
        String query;
        query = "INSERT INTO Drivers (DriverName, DriverID, CountryID, RaceEntries, RaceStarts, PolePositions, RaceWins, Podiums, FastestLaps, Points) VALUES (?,?,?,?,?,?,?,?,?,?)";
        return query;
    }
}

