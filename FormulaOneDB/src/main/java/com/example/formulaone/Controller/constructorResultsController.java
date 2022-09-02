package com.example.formulaone.Controller;

import com.example.formulaone.Model.Constructor;
import com.example.formulaone.Model.DBConnect;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class constructorResultsController implements Initializable {

    @FXML
    private TableView<Constructor> table_constructor;

    @FXML
    private TableColumn<Constructor, String> col_name;

    @FXML
    private TableColumn<Constructor, String> col_country;

    @FXML
    private TableColumn<Constructor, Integer> col_racesEntered;

    @FXML
    private TableColumn<Constructor, Integer> col_racesStarted;

    @FXML
    private TableColumn<Constructor, Integer> col_drivers;

    @FXML
    private TableColumn<Constructor, Integer> col_totalEntries;

    @FXML
    private TableColumn<Constructor, Integer> col_wins;

    @FXML
    private TableColumn<Constructor, Integer> col_points;

    @FXML
    private TableColumn<Constructor, Integer> col_poles;

    @FXML
    private TableColumn<Constructor, Integer> col_fastestLaps;

    @FXML
    private TableColumn<Constructor, Integer> col_podiums;

    @FXML
    private TableColumn<Constructor, Integer> col_wcc;

    @FXML
    private TableColumn<Constructor, Integer> col_wdc;

    ObservableList<Constructor> listM;

    public void UpdateTable(){
        col_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        col_country.setCellValueFactory(cellData -> cellData.getValue().countryProperty());
        col_racesEntered.setCellValueFactory(new PropertyValueFactory<>("RacesEntered"));
        col_racesStarted.setCellValueFactory(new PropertyValueFactory<>("RacesStarted"));
        col_drivers.setCellValueFactory(new PropertyValueFactory<>("Drivers"));
        col_totalEntries.setCellValueFactory(new PropertyValueFactory<>("TotalEntries"));
        col_wins.setCellValueFactory(new PropertyValueFactory<>("Wins"));
        col_points.setCellValueFactory(new PropertyValueFactory<>("Points"));
        col_poles.setCellValueFactory(new PropertyValueFactory<>("Poles"));
        col_fastestLaps.setCellValueFactory(new PropertyValueFactory<>("FL"));
        col_podiums.setCellValueFactory(new PropertyValueFactory<>("Podiums"));
        col_wcc.setCellValueFactory(new PropertyValueFactory<>("WCC"));
        col_wdc.setCellValueFactory(new PropertyValueFactory<>("WDC"));

        listM = DBConnect.getConstructorsData();
        table_constructor.setItems(listM);
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

