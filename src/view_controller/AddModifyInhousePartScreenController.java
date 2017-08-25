/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;
import model.Counter;
import model.InhousePart;
import model.Inventory;

public class AddModifyInhousePartScreenController implements Initializable{

    @FXML
    private RadioButton inHouseRadio;

    @FXML
    private RadioButton outsourcedRadio;

    @FXML
    private TextField partIDField;

    @FXML
    private TextField partNameField;

    @FXML
    private TextField partInvField;

    @FXML
    private TextField partPriceField;

    @FXML
    private TextField partMachineIDField;

    @FXML
    private TextField partMaxField;

    @FXML
    private TextField partMinField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;
    
    private MainApp mainApp;
    
    /*
    public void initialize() {
        partIDField.setText(Counter.getValue());
    } */

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
    void handleInHouse(ActionEvent event) {

    }

    @FXML
    void handleOutsourced(ActionEvent event) throws IOException {
        Counter.decrement();
        Parent handleOutsourcedParent = FXMLLoader.load(getClass().getResource("AddModifyOutsourcedPartScreen.fxml"));
        Scene handleOutsourcedScene = new Scene(handleOutsourcedParent);
        Stage handleOutsourcedStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        handleOutsourcedStage.hide();
        handleOutsourcedStage.setScene(handleOutsourcedScene);
        handleOutsourcedStage.show();

    }

    @FXML
    void handleSave(ActionEvent event) throws IOException {
        String partID = partIDField.getText();
        String name = partNameField.getText();
        String inv = partInvField.getText();
        String price = partPriceField.getText();
        String max = partMaxField.getText();
        String min = partMinField.getText();
        String machineID = partMachineIDField.getText();
        InhousePart newInhousePart;
        newInhousePart = new InhousePart(Integer.parseInt(partID), name, Double.parseDouble(price), Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max), Integer.parseInt(machineID));
        Inventory.addPart(newInhousePart); 
        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene mainScreenScene = new Scene(mainScreenParent);
        Stage mainScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainScreenStage.hide();
        mainScreenStage.setScene(mainScreenScene);
        mainScreenStage.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        partIDField.setText(Counter.getValue());
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    
    

  
}
