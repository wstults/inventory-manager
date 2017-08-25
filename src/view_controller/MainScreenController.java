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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Inventory;
import model.Part;
import model.Product;

public class MainScreenController {

    @FXML
    private TableView<Part> partsTable;

    @FXML
    private TableColumn<?, ?> partIDcolumn;

    @FXML
    private TableColumn<?, ?> partNameColumn;

    @FXML
    private TableColumn<?, ?> partInventoryLevelColumn;

    @FXML
    private TableColumn<?, ?> partPriceColumn;

    @FXML
    private Button addPartButton;

    @FXML
    private Button modifyPartButton;

    @FXML
    private Button deletePartButton;

    @FXML
    private Button searchPartButton;

    @FXML
    private TextField searchPartField;

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private TableColumn<?, ?> productIDColumn;

    @FXML
    private TableColumn<?, ?> productNameColumn;

    @FXML
    private TableColumn<?, ?> productInventoryLevelColumn;

    @FXML
    private TableColumn<?, ?> productPriceColumn;

    @FXML
    private Button addProductButton;

    @FXML
    private Button modifyProductButton;

    @FXML
    private Button deleteProductButton;

    @FXML
    private Button searchProductButton;

    @FXML
    private TextField searchProductField;

    @FXML
    private Button exitButton;
    
    private MainApp mainApp;
    
    public MainScreenController() {
        
    }
    
    @FXML
    public void initialize() {
        partIDcolumn.setCellValueFactory(new PropertyValueFactory<>("PartID"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        productIDColumn.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
        
    } 

    @FXML
    void handleAddPart(ActionEvent event) throws IOException {
        Parent addPartParent = FXMLLoader.load(getClass().getResource("AddModifyInhousePartScreen.fxml"));
        Scene addPartScene = new Scene(addPartParent);
        Stage addPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addPartStage.hide();
        addPartStage.setScene(addPartScene);
        addPartStage.show();

    }

    @FXML
    void handleAddProduct(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==addProductButton) {
            stage=(Stage) addProductButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("AddModifyProductScreen.fxml"));
        }

    }

    @FXML
    void handleDeletePart(ActionEvent event) {

    }

    @FXML
    void handleDeleteProduct(ActionEvent event) {

    }

    @FXML
    void handleExit(ActionEvent event) {

    }

    @FXML
    void handleModifyPart(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==modifyPartButton) {
            stage=(Stage) modifyPartButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ModifyInhousePartScreen.fxml"));
        }

    }

    @FXML
    void handleModifyProduct(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource()==modifyProductButton) {
            stage=(Stage) modifyProductButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("ModifyProductScreen.fxml"));
        }

    }

    @FXML
    void handleSearchPart(ActionEvent event) {

    }

    @FXML
    void handleSearchProduct(ActionEvent event) {

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        partsTable.setItems(Inventory.getAllParts());
        productsTable.setItems(Inventory.getProducts());
    }

}
