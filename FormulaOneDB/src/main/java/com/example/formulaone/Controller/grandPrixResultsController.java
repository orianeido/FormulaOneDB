package com.example.formulaone.Controller;

import com.example.formulaone.Model.DBConnect;
import com.example.formulaone.Model.GrandPrix;
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

public class grandPrixResultsController implements Initializable {

    @FXML
    private TableView<GrandPrix> table_grandPrixs;

    @FXML
    private TableColumn<GrandPrix, String> col_name;

    @FXML
    private TableColumn<GrandPrix, String> col_circuit;

    @FXML
    private TableColumn<GrandPrix, String> col_type;

    @FXML
    private TableColumn<GrandPrix, String> col_direction;

    @FXML
    private TableColumn<GrandPrix, Double> col_length;

    @FXML
    private TableColumn<GrandPrix, Integer> col_eventAmount;

    ObservableList<GrandPrix> listM;

    public void UpdateTable(){
        col_name.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        col_circuit.setCellValueFactory(cellData -> cellData.getValue().circuitProperty());
        col_type.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        col_direction.setCellValueFactory(cellData -> cellData.getValue().directionProperty());
        col_length.setCellValueFactory(new PropertyValueFactory<>("Length"));
        col_eventAmount.setCellValueFactory(new PropertyValueFactory<>("EventAmount"));

        listM = DBConnect.getGrandPrixsData();
        table_grandPrixs.setItems(listM);
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

