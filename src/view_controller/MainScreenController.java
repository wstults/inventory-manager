/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;


import java.io.IOException;
import static javafx.application.Platform.exit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import model.InhousePart;
import model.Inventory;
import static model.Inventory.allParts;
import static model.Inventory.products;
import model.OutsourcedPart;
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
    
    @FXML
    public ObservableList<Part> partsData=FXCollections.observableArrayList();
    @FXML
    public ObservableList<Product> productsData=FXCollections.observableArrayList();
    
    public static InhousePart selectedInhousePart;
    public static OutsourcedPart selectedOutsourcedPart;
    public static Product selectedProduct;
    
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
        partsTable.setItems(Inventory.getAllParts());
        productsTable.setItems(Inventory.getProducts());
        
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
        Parent addProductParent = FXMLLoader.load(getClass().getResource("AddModifyProductScreen.fxml"));
        Scene addProductScene = new Scene(addProductParent);
        Stage addProductStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        addProductStage.hide();
        addProductStage.setScene(addProductScene);
        addProductStage.show();

    }

    @FXML
    void handleDeletePart(ActionEvent event) throws IOException {
        if (ErrorCheck.deleteConfirm() == false) {
            return;
        }
        allParts.remove(partsTable.getSelectionModel().getSelectedItem());
        partsTable.setItems(Inventory.getAllParts());
        
    }

    @FXML
    void handleDeleteProduct(ActionEvent event) throws IOException {
        if (ErrorCheck.deleteConfirm() == false) {
            return;
        }
        if (ErrorCheck.productDeleteCheck(productsTable.getSelectionModel().getSelectedItem()) == false) {
            return;
        }
        products.remove(productsTable.getSelectionModel().getSelectedItem());
        productsTable.setItems(Inventory.getProducts());
    }

    @FXML
    void handleExit(ActionEvent event) {
        exit();
    }

    @FXML
    void handleModifyPart(ActionEvent event) throws IOException {
        
        if (partsTable.getSelectionModel().getSelectedItem() instanceof InhousePart) {
            selectedInhousePart = (InhousePart) partsTable.getSelectionModel().getSelectedItem();
            Parent modifyInhousePartParent = FXMLLoader.load(getClass().getResource("ModifyInhousePartScreen.fxml"));
            Scene modifyInhousePartScene = new Scene(modifyInhousePartParent);
            Stage modifyInhousePartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifyInhousePartStage.hide();
            modifyInhousePartStage.setScene(modifyInhousePartScene);
            modifyInhousePartStage.show();
            
        } else {
            selectedOutsourcedPart = (OutsourcedPart) partsTable.getSelectionModel().getSelectedItem();
            Parent modifyOutsourcedPartParent = FXMLLoader.load(getClass().getResource("ModifyOutsourcedPartScreen.fxml"));
            Scene modifyOutsourcedPartScene = new Scene(modifyOutsourcedPartParent);
            Stage modifyOutsourcedPartStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            modifyOutsourcedPartStage.hide();
            modifyOutsourcedPartStage.setScene(modifyOutsourcedPartScene);
            modifyOutsourcedPartStage.show();
            }
        
    }

    @FXML
    void handleModifyProduct(ActionEvent event) throws IOException {
        selectedProduct = productsTable.getSelectionModel().getSelectedItem();
        Parent modifyProductParent = FXMLLoader.load(getClass().getResource("ModifyProductScreen.fxml"));
        Scene modifyProductScene = new Scene(modifyProductParent);
        Stage modifyProductStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        modifyProductStage.hide();
        modifyProductStage.setScene(modifyProductScene);
        modifyProductStage.show();
        

    }

    @FXML
    void handleSearchPart(ActionEvent event) {
        String searchPart = searchPartField.getText();
        boolean found = false;
        if ("".equals(searchPart)) {
            partsTable.setItems(Inventory.getAllParts());
            found = true;
        }
        try {
            int partNumber = Integer.parseInt(searchPart);
            for (Part a : Inventory.allParts) {
                if (a.getPartID() == partNumber) {
                    found = true;
                    partsData.add(a);
                    partIDcolumn.setCellValueFactory(new PropertyValueFactory<>("PartID"));
                    partNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
                    partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
                    partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
                    partsTable.setItems(partsData);
                    
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
                partsData.add(a);
                partIDcolumn.setCellValueFactory(new PropertyValueFactory<>("PartID"));
                partNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
                partInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
                partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
                partsTable.setItems(partsData);
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

    @FXML
    void handleSearchProduct(ActionEvent event) {
        String searchProduct = searchProductField.getText();
        boolean found = false;
        if ("".equals(searchProduct)) {
            productsTable.setItems(Inventory.getProducts());
            found = true;
        }
        try {
            int productNumber = Integer.parseInt(searchProduct);
            for (Product a : Inventory.products) {
                if (a.getProductID() == productNumber) {
                    found = true;
                    productsData.add(a);
                    productIDColumn.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
                    productNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
                    productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
                    productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
                    productsTable.setItems(productsData);
                    
                }
            }
            if (found==false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Product not found");

            alert.showAndWait();
            }
            
        }
        catch(NumberFormatException e){
        for (Product a: Inventory.products) {
            if (a.getName().equals(searchProduct)){
                found=true;
                productsData.add(a);
                productIDColumn.setCellValueFactory(new PropertyValueFactory<>("ProductID"));
                productNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
                productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<>("InStock"));
                productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("Price"));
                productsTable.setItems(productsData);
            }
        }
        if (found==false){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Error");
            alert.setContentText("Product not found");

            alert.showAndWait();
        }
        
    }


    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        partsTable.setItems(Inventory.getAllParts());
        productsTable.setItems(Inventory.getProducts());
    }

}
