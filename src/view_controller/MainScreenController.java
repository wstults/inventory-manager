/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Part;
import model.Product;

/**
 * FXML Controller class
 *
 * @author William
 */
public class MainScreenController implements Initializable {
    
    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TableView<Product> productsTable;
    @FXML
    private TableColumn<Part, IntegerProperty> partIDcolumn;
    @FXML
    private TableColumn<Part, StringProperty> partNameColumn;
    @FXML
    private TableColumn<Part, IntegerProperty> partInventoryLevelColumn;
    @FXML
    private TableColumn<Part, DoubleProperty> partPriceColumn;
    @FXML
    private TableColumn<Product, IntegerProperty> productIDColumn;
    @FXML
    private TableColumn<Product, StringProperty> productNameColumn;
    @FXML
    private TableColumn<Product, IntegerProperty> productInventoryLevelColumn;
    @FXML
    private TableColumn<Product, DoubleProperty> productPriceColumn;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleSearchPart() {
    //method text
}
    
    @FXML
    private void handleSearchProduct() {
    //method text
}
    
    @FXML
    private void handleAddPart() {
    // method text
}
    
    @FXML
    private void handleModifyPart() {
        // method text
    }
    
    @FXML
    private void handleDeletePart() {
        // method text
    }
    
    @FXML
    private void handleAddProduct() {
        // method text
    }
    
    @FXML
    private void handleModifyProduct() {
        // mthod text
    }
    
    @FXML
    private void handleDeleteProduct() {
        // method text
    }
    
    @FXML
    private void handleExit() {
        // method text
    }
    
}
