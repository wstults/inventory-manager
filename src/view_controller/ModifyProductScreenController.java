/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import static model.Inventory.products;
import model.Part;
import model.Product;
import static view_controller.MainScreenController.selectedProduct;

public class ModifyProductScreenController implements Initializable {

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
    private TextField searchPartField;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<Part> allPartsTable;

    @FXML
    private TableColumn<?, ?> partIDColumn;

    @FXML
    private TableColumn<?, ?> partNameColumn;

    @FXML
    private TableColumn<?, ?> partInventoryLevelColumn;

    @FXML
    private TableColumn<?, ?> partPriceColumn;

    @FXML
    private TableView<Part> associatedPartsTable;

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
    public ObservableList<Part> partSearchData=FXCollections.observableArrayList();

    @FXML
    void handleAdd(ActionEvent event) throws IOException {
        selectedProduct.associatedParts.add(allPartsTable.getSelectionModel().getSelectedItem());
        associatedPartsTable.setItems(selectedProduct.getAssociatedParts());
    }

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
    void handleDelete(ActionEvent event) throws IOException {
        if (ErrorCheck.deleteConfirm() == false) {
            return;
        }
        selectedProduct.associatedParts.remove(associatedPartsTable.getSelectionModel().getSelectedItem());
        associatedPartsTable.setItems(selectedProduct.getAssociatedParts());
    }

    @FXML
    void handleSave(ActionEvent event) throws IOException {
        
        String productID = productIDField.getText();
        String name = productNameField.getText();
        String inv = productInvField.getText();
        String price = productPriceField.getText();
        String max = productMaxField.getText();
        String min = productMinField.getText();
        if (ErrorCheck.invCheckDefault(inv) == false) {
            inv = "0";
        }
        if (ErrorCheck.maxCheck(Integer.parseInt(min), Integer.parseInt(max)) == false) {
            return;
        }
        if (ErrorCheck.minCheck(Integer.parseInt(min), Integer.parseInt(max)) == false) {
            return;
        }
        if (ErrorCheck.invCheck(Integer.parseInt(min), Integer.parseInt(max), Integer.parseInt(inv)) == false) {
            return;
        }
        if (ErrorCheck.associatedPartCheck(selectedProduct) == false) {
            return;
        }
        if (ErrorCheck.nameCheck(name) == false) {
            return;
        }
        if (ErrorCheck.priceCheck(price) == false) {
            return;
        }
        if (ErrorCheck.productPartsPriceCheck(selectedProduct, Double.parseDouble(price)) == false) {
            return;
        }
        Product newProduct;
        newProduct = new Product(Integer.parseInt(productID), name, Double.parseDouble(price), Integer.parseInt(inv), Integer.parseInt(min), Integer.parseInt(max));
        Inventory.addProduct(newProduct);
        newProduct.associatedParts = selectedProduct.getAssociatedParts();
        products.remove(selectedProduct);
        Parent mainScreenParent = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene mainScreenScene = new Scene(mainScreenParent);
        Stage mainScreenStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        mainScreenStage.hide();
        mainScreenStage.setScene(mainScreenScene);
        mainScreenStage.show();
    }

    @FXML
    void handleSearch(ActionEvent event) throws IOException {
        String searchPart = searchPartField.getText();
        boolean found = false;
        if ("".equals(searchPart)) {
            allPartsTable.setItems(Inventory.getAllParts());
            found = true;
        }
        try {
            int partNumber = Integer.parseInt(searchPart);
            for (Part a : Inventory.allParts) {
                if (a.getPartID() == partNumber) {
                    found = true;
                    partSearchData.add(a);
                    partIDColumn.setCellValueFactory(new PropertyValueFactory<>("PartID"));
                    partNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
                    partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
                    partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
                    allPartsTable.setItems(partSearchData);
                    
                }
            }
            if (found==false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Part not found");

            alert.showAndWait();
            }
            
        }
        catch(NumberFormatException e){
        for (Part a: Inventory.allParts) {
            if (a.getName().equals(searchPart)){
                found=true;
                partSearchData.add(a);
                partIDColumn.setCellValueFactory(new PropertyValueFactory<>("PartID"));
                partNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
                partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
                partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
                allPartsTable.setItems(partSearchData);
            }
        }
        if (found==false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Part not found");

            alert.showAndWait();
        }
        
    }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productIDField.setText(Integer.toString(selectedProduct.getProductID()));
        productNameField.setText(selectedProduct.getName());
        productInvField.setText(Integer.toString(selectedProduct.getInStock()));
        productPriceField.setText(Double.toString(selectedProduct.getPrice()));
        productMaxField.setText(Integer.toString(selectedProduct.getMax()));
        productMinField.setText(Integer.toString(selectedProduct.getMin()));
        partIDColumn.setCellValueFactory(new PropertyValueFactory<>("PartID"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        associatedPartIDColumn.setCellValueFactory(new PropertyValueFactory<>("PartID"));
        associatedPartNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        associatedPartInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
        associatedPartPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        allPartsTable.setItems(Inventory.getAllParts());
        associatedPartsTable.setItems(selectedProduct.getAssociatedParts());
    }

}
