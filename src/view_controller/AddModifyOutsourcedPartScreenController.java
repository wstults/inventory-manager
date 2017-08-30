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
import model.Inventory;
import model.OutsourcedPart;

public class AddModifyOutsourcedPartScreenController implements Initializable {

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
    private TextField partCompanyNameField;

    @FXML
    private TextField partMinField;

    @FXML
    private TextField partMaxField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    @FXML
    void handleCancel(ActionEvent event) throws IOException {
        if (ErrorCheck.cancelConfirm() == false) {
            return;
        }
        Counter.decrement();
        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene mainScreenScene = new Scene(mainScreenParent);
        Stage mainScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainScreenStage.hide();
        mainScreenStage.setScene(mainScreenScene);
        mainScreenStage.show();

    }

    @FXML
    void handleSave(ActionEvent event) throws IOException {
        String partID = partIDField.getText();
        String name = partNameField.getText();
        String inv = partInvField.getText();
        String price = partPriceField.getText();
        String max = partMaxField.getText();
        String min = partMinField.getText();
        String companyName = partCompanyNameField.getText();
        if (ErrorCheck.maxCheck(Integer.parseInt(min), Integer.parseInt(max)) == false) {
            return;
        }
        if (ErrorCheck.minCheck(Integer.parseInt(min), Integer.parseInt(max)) == false) {
            return;
        }
        if (ErrorCheck.invCheck(Integer.parseInt(min), Integer.parseInt(max), Integer.parseInt(inv)) == false) {
            return;
        }
        OutsourcedPart newOutsourcedPart;
        newOutsourcedPart = new OutsourcedPart(Integer.parseInt(partID), name, Double.parseDouble(price), Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max), companyName);
        Inventory.addPart(newOutsourcedPart); 
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

}
