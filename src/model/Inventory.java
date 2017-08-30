/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

/**
 *
 * @author William
 */
public class Inventory {
    
    @FXML
    public static final ObservableList<Product> products = FXCollections.observableArrayList();
    @FXML
    public static final ObservableList<Part> allParts = FXCollections.observableArrayList();
    
    
    
    @FXML
    public static ObservableList<Product> getProducts() {
        return products;
    }
    
    @FXML
    public static ObservableList<Part> getAllParts() {
        return allParts;
    }
    
    public static void addProduct(Product product){
        products.add(product);
    }
    
    public boolean removeProduct(IntegerProperty productID) {
        products.stream().filter((a) -> (productID == a.ProductID)).forEach((Product a) -> {
            products.remove(a);
        });
        return true;
    }
    
    public Product lookupProduct(IntegerProperty productID) {
        // funtionality is handled by handleSearchProduct method in MainScreenController
        Product placeHolder = new Product(999, "Placeholder", 20.00, 22, 1, 99);
        return placeHolder;
    } 
    
    public void updateProduct(int productID) {
        // funtionality is handled via the handleSave method in ModifyProductScreenController
    } 
    
    public static void addPart(Part part) {
        allParts.add(part);
    }
    
    public static boolean deletePart(Part part) {
        return allParts.remove(part);
        
    }
    
    public Part lookupPart(IntegerProperty partID) {
        // funtionality is handled by the handleSearchPart method in MainScreenController
        // as well as the handleSearch methods in AddModifyProductScreenController and ModifyProductScreenController
        InhousePart placeHolder = new InhousePart(888, "Placeholder", 5.00, 55, 1, 99, 4343);
        return placeHolder;
    } 
    
    public void updatePart(int partID) {
        // funtionality is handled by the handleSave methods in ModifyInhousePartController and ModifyOutsourcedPartController
    }
    
}
