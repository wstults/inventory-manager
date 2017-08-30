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

public class ModifyOutsourcedPartScreenController implements Initializable {

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
    private TextField partCompanyNameField;

    @FXML
    private TextField partMinField;

    @FXML
    private TextField partMaxField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;
    
    public static Part currentOutsourcedPart;

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
    void handleInHouse(ActionEvent event) throws IOException {
        if (ErrorCheck.modifyPartDeleteCheck() == false) {
            return;
        }
        int partID = selectedOutsourcedPart.getPartID();
        String name = selectedOutsourcedPart.getName();
        double price = selectedOutsourcedPart.getPrice();
        int inStock = selectedOutsourcedPart.getInStock();
        int min = selectedOutsourcedPart.getMin();
        int max = selectedOutsourcedPart.getMax();
        int machineID = 1234;
        
        selectedInhousePart = new InhousePart(partID, name, price, inStock, min, max, machineID);
        allParts.add(selectedInhousePart);
        allParts.remove(selectedOutsourcedPart);
        Parent modifyInhousePartParent = FXMLLoader.load(getClass().getResource("ModifyInhousePartScreen.fxml"));
        Scene modifyInhousePartScene = new Scene(modifyInhousePartParent);
        Stage modifyInhousePartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modifyInhousePartStage.hide();
        modifyInhousePartStage.setScene(modifyInhousePartScene);
        modifyInhousePartStage.show();

    }

    @FXML
    void handleSave(ActionEvent event) throws IOException {
        allParts.remove(selectedOutsourcedPart);
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
        partIDField.setText(Integer.toString(selectedOutsourcedPart.getPartID()));
        partNameField.setText(selectedOutsourcedPart.getName());
        partInvField.setText(Integer.toString(selectedOutsourcedPart.getInStock()));
        partPriceField.setText(Double.toString(selectedOutsourcedPart.getPrice()));
        partCompanyNameField.setText(selectedOutsourcedPart.getCompanyName());
        partMaxField.setText(Integer.toString(selectedOutsourcedPart.getMax()));
        partMinField.setText(Integer.toString(selectedOutsourcedPart.getMin()));
    }

}
