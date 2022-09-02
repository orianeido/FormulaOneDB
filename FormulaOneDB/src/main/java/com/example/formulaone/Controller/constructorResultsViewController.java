package com.example.formulaone.Controller;

import com.example.formulaone.Model.Constructor;
import com.example.formulaone.Model.DBConnect;
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

public class constructorResultsViewController implements Initializable {

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
    private Label txt_racesEntered;

    @FXML
    private Label txt_racesStarted;

    @FXML
    private Label txt_Drivers;

    @FXML
    private Label txt_Wins;

    @FXML
    private Label txt_points;

    @FXML
    private Label txt_poles;

    @FXML
    private Label txt_fl;

    @FXML
    private Label txt_podiums;

    @FXML
    private Label txt_wcc;

    @FXML
    private Label txt_wdc;

    @FXML
    private Button delete_button;

    @FXML
    private Button return_button;

    Constructor constructorData;
    private String searchText;
    ObservableList<Season> listM;


    public void UpdateInfo(){
        constructorData = DBConnect.getConstructorData(this.searchText);

        if (constructorData == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Constructor Not Found");
            alert.showAndWait();
        }

        txt_name.setText(constructorData.getName());
        txt_country.setText(constructorData.getCountry());
        txt_racesEntered.setText(String.valueOf(constructorData.getRacesEntered()));
        txt_racesStarted.setText(String.valueOf(constructorData.getRacesStarted()));
        txt_Drivers.setText(String.valueOf(constructorData.getDrivers()));
        txt_Wins.setText(String.valueOf(constructorData.getWins()));
        txt_points.setText(String.valueOf((constructorData.getPoints())));
        txt_poles.setText(String.valueOf(constructorData.getPoles()));
        txt_podiums.setText(String.valueOf(constructorData.getPodiums()));
        //txt_fl.setText(String.valueOf(constructorData.getFastestLaps()));
        txt_wcc.setText(String.valueOf(constructorData.getWcc()));
        txt_wdc.setText(String.valueOf(constructorData.getWdc()));

        col_season.setCellValueFactory(new PropertyValueFactory<>("Season"));
        col_points.setCellValueFactory(new PropertyValueFactory<>("Points"));
        listM = DBConnect.getConstructorSeasonsData(this.searchText);
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

    public void deleteConstructor(ActionEvent actionEvent) throws IOException {
        if (DBConnect.deleteConstructor(this.searchText) == 1){
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

