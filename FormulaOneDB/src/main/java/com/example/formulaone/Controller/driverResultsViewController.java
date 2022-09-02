package com.example.formulaone.Controller;

import com.example.formulaone.Model.DBConnect;
import com.example.formulaone.Model.Driver;

import com.example.formulaone.Model.Season;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class driverResultsViewController implements Initializable {

    @FXML
    private TableView<Season> table_seasons;

    @FXML
    private TableColumn<String, Integer> col_season;

    @FXML
    private TableColumn<String, Double> col_points;

    @FXML
    private Label txt_name;

    @FXML
    private Label txt_country;

    @FXML
    private Label txt_raceEntries;

    @FXML
    private Label txt_raceStarts;

    @FXML
    private Label txt_polePositions;

    @FXML
    private Label txt_raceWins;

    @FXML
    private Label txt_podiums;

    @FXML
    private Label txt_fastestLaps;

    @FXML
    private Label txt_points;

    @FXML
    private Button delete_button;

    @FXML
    private Button return_button;

    Driver driverData;
    private String searchText;
    ObservableList<Season> listM;

    public void UpdateInfo(){
        driverData = DBConnect.getDriverData(this.searchText);

        if (driverData == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Driver Not Found");
            alert.showAndWait();
        }

        txt_name.setText(driverData.getName());
        txt_country.setText(driverData.getCountry());
        txt_raceEntries.setText(String.valueOf(driverData.getRaceEntries()));
        txt_raceStarts.setText(String.valueOf(driverData.getRaceStarts()));
        txt_polePositions.setText(String.valueOf(driverData.getPolePositions()));
        txt_raceWins.setText(String.valueOf(driverData.getRaceWins()));
        txt_podiums.setText(String.valueOf((driverData.getPodiums())));
        txt_fastestLaps.setText(String.valueOf(driverData.getFastestLaps()));
        txt_points.setText(String.valueOf(driverData.getPoints()));

        col_season.setCellValueFactory(new PropertyValueFactory<>("Season"));
        col_points.setCellValueFactory(new PropertyValueFactory<>("Points"));
        listM = DBConnect.getDriverSeasonsData(this.searchText);
        table_seasons.setItems(listM);
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
    public void deleteDriver(ActionEvent actionEvent) throws IOException {
        if (DBConnect.deleteDriver(this.searchText) == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Deleted Successfully");
            alert.showAndWait();
            returnToSearchView(actionEvent);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Deleted Failed");
            alert.showAndWait();
        }
    }
}

