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

/**
 * FXML Controller class
 *
 * @author William
 */
public class AddModifyProductScreenController implements Initializable {
    
    @FXML
    private TableView<Part> allPartsTable;
    @FXML
    private TableView<Part> associatedPartsTable;
    @FXML
    private TableColumn<Part, IntegerProperty> partIDColumn;
    @FXML
    private TableColumn<Part, StringProperty> partNameColumn;
    @FXML
    private TableColumn<Part, IntegerProperty> partInventoryLevelColumn;
    @FXML
    private TableColumn<Part, DoubleProperty> partPriceColumn;
    @FXML
    private TableColumn<Part, IntegerProperty> associatedPartIDColumn;
    @FXML
    private TableColumn<Part, StringProperty> associatedPartNameColumn;
    @FXML
    private TableColumn<Part, IntegerProperty> associatedPartInventoryLevelColumn;
    @FXML
    private TableColumn<Part, DoubleProperty> associatedPartPriceColumn;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleSearch() {
        // method text
    }
    
    @FXML
    private void handleAdd() {
        // method text
    }
    
    @FXML
    private void handleDelete() {
        // method text
    }
    
    @FXML
    private void handleSave() {
        // method text
    }
    
    @FXML
    private void handleCancel() {
        // method text
    }
    
}
