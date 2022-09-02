package com.example.formulaone.Controller;

import com.example.formulaone.Model.DBConnect;
import com.example.formulaone.Model.Driver;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class driverResultsController implements Initializable {

    @FXML
    private TableView<Driver> table_drivers;

    @FXML
    private TableColumn<Driver, String> col_name;

    @FXML
    private TableColumn<Driver, String> col_country;

    @FXML
    private TableColumn<Driver, Integer> col_raceEntries;

    @FXML
    private TableColumn<Driver, Integer> col_raceStarts;

    @FXML
    private TableColumn<Driver, Integer> col_polePositions;

    @FXML
    private TableColumn<Driver, Integer> col_raceWins;

    @FXML
    private TableColumn<Driver, Integer> col_podiums;

    @FXML
    private TableColumn<Driver, Integer> col_fastestLaps;

    @FXML
    private TableColumn<Driver, Double> col_points;

    ObservableList<Driver> listM;

    public void UpdateTable(){
        col_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        col_country.setCellValueFactory(cellData -> cellData.getValue().countryProperty());
        col_raceEntries.setCellValueFactory(new PropertyValueFactory<>("RaceEntries"));
        col_raceStarts.setCellValueFactory(new PropertyValueFactory<>("RaceStarts"));
        col_polePositions.setCellValueFactory(new PropertyValueFactory<>("PolePositions"));
        col_raceWins.setCellValueFactory(new PropertyValueFactory<>("RaceWins"));
        col_podiums.setCellValueFactory(new PropertyValueFactory<>("Podiums"));
        col_fastestLaps.setCellValueFactory(new PropertyValueFactory<>("FastestLaps"));
        col_points.setCellValueFactory(new PropertyValueFactory<>("Points"));

        listM = DBConnect.getDriversData();
        table_drivers.setItems(listM);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UpdateTable();
    }

    public void returnToSearchView(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/search-view.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

