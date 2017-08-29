/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Counter;

public class AddModifyProductScreenController {

    @FXML
    private TextField productIDField;

    @FXML
    private TextField productNameField;

    @FXML
    private TextField productInvField;

    @FXML
    private TextField productPriceField;

    @FXML
    private TextField productMaxField;

    @FXML
    private TextField productMinField;

    @FXML
    private Button searchButton;

    @FXML
    private TextField partSearchField;

    @FXML
    private TableView<?> allPartsTable;

    @FXML
    private TableColumn<?, ?> partIDColumn;

    @FXML
    private TableColumn<?, ?> partNameColumn;

    @FXML
    private TableColumn<?, ?> partInventoryLevelColumn;

    @FXML
    private TableColumn<?, ?> partPriceColumn;

    @FXML
    private TableView<?> associatedPartsTable;

    @FXML
    private TableColumn<?, ?> associatedPartIDColumn;

    @FXML
    private TableColumn<?, ?> associatedPartNameColumn;

    @FXML
    private TableColumn<?, ?> associatedPartInventoryLevelColumn;

    @FXML
    private TableColumn<?, ?> associatedPartPriceColumn;

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    void handleAdd(ActionEvent event) {

    }

    @FXML
    void handleCancel(ActionEvent event) throws IOException {
        Counter.decrement();
        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene mainScreenScene = new Scene(mainScreenParent);
        Stage mainScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainScreenStage.hide();
        mainScreenStage.setScene(mainScreenScene);
        mainScreenStage.show();
    }

    @FXML
    void handleDelete(ActionEvent event) {

    }

    @FXML
    void handleSave(ActionEvent event) {

    }

    @FXML
    void handleSearch(ActionEvent event) {

    }

}
