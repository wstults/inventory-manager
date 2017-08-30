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
import model.InhousePart;
import model.Inventory;
import static model.Inventory.allParts;
import model.OutsourcedPart;
import model.Part;
import static view_controller.MainScreenController.selectedInhousePart;
import static view_controller.MainScreenController.selectedOutsourcedPart;

public class ModifyInhousePartScreenController implements Initializable {

    @FXML
    private RadioButton inHouseRadioButton;

    @FXML
    private RadioButton outsourcedRadioButton;

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
    
    public static Part currentInhousePart;

    @FXML
    void handleCancel(ActionEvent event) throws IOException {
        if (ErrorCheck.cancelConfirm() == false) {
            return;
        }
        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene mainScreenScene = new Scene(mainScreenParent);
        Stage mainScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainScreenStage.hide();
        mainScreenStage.setScene(mainScreenScene);
        mainScreenStage.show();
    }

    @FXML
    void handleInHouse(ActionEvent event) {
        // no action required here
    }

    @FXML
    void handleOutsourced(ActionEvent event) throws IOException {
        if (ErrorCheck.modifyPartDeleteCheck() == false) {
            return;
        }
        int partID = selectedInhousePart.getPartID();
        String name = selectedInhousePart.getName();
        double price = selectedInhousePart.getPrice();
        int inStock = selectedInhousePart.getInStock();
        int min = selectedInhousePart.getMin();
        int max = selectedInhousePart.getMax();
        String companyName = "DEFAULT";
        
        selectedOutsourcedPart = new OutsourcedPart(partID, name, price, inStock, min, max, companyName);
        allParts.add(selectedOutsourcedPart);
        allParts.remove(selectedInhousePart);
        Parent modifyOutsourcedPartParent = FXMLLoader.load(getClass().getResource("ModifyOutsourcedPartScreen.fxml"));
        Scene modifyOutsourcedPartScene = new Scene(modifyOutsourcedPartParent);
        Stage modifyOutsourcedPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modifyOutsourcedPartStage.hide();
        modifyOutsourcedPartStage.setScene(modifyOutsourcedPartScene);
        modifyOutsourcedPartStage.show();
    }

    @FXML
    void handleSave(ActionEvent event) throws IOException {
        allParts.remove(selectedInhousePart);
        String partID = partIDField.getText();
        String name = partNameField.getText();
        String inv = partInvField.getText();
        String price = partPriceField.getText();
        String max = partMaxField.getText();
        String min = partMinField.getText();
        String machineID = partMachineIDField.getText();
        if (ErrorCheck.maxCheck(Integer.parseInt(min), Integer.parseInt(max)) == false) {
            return;
        }
        if (ErrorCheck.minCheck(Integer.parseInt(min), Integer.parseInt(max)) == false) {
            return;
        }
        if (ErrorCheck.invCheck(Integer.parseInt(min), Integer.parseInt(max), Integer.parseInt(inv)) == false) {
            return;
        }
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
        
        partIDField.setText(Integer.toString(selectedInhousePart.getPartID()));
        partNameField.setText(selectedInhousePart.getName());
        partInvField.setText(Integer.toString(selectedInhousePart.getInStock()));
        partPriceField.setText(Double.toString(selectedInhousePart.getPrice()));
        partMachineIDField.setText(Integer.toString(selectedInhousePart.getMachineID()));
        partMaxField.setText(Integer.toString(selectedInhousePart.getMax()));
        partMinField.setText(Integer.toString(selectedInhousePart.getMin()));
    }

}
