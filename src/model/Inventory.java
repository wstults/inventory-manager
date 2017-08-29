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
    /*
    public Product lookupProduct(IntegerProperty productID) {
        // funtionality will be addressed elsewhere - be sure to update comment
        
    } */
    
    public void updateProduct(int productID) {
        // funtionality will be addressed elsewhere - be sure to update comment
    } 
    
    public static void addPart(Part part) {
        allParts.add(part);
    }
    
    public static boolean deletePart(Part part) {
        return allParts.remove(part);
        
    }
    /*
    public Part lookupPart(IntegerProperty partID) {
        // funtionality will be addressed elsewhere - be sure to update comment
    } */
    
    public void updatePart(int partID) {
        // funtionality will be addressed elsewhere - be sure to update comment
    }
    
}
