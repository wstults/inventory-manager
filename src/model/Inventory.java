/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author William
 */
public class Inventory {
    
    private final ObservableList<Product> products = FXCollections.observableArrayList();
    private final ObservableList<Part> allParts = FXCollections.observableArrayList();
    
    public void addProduct(Product product){
        products.add(product);
    }
    
    public boolean removeProduct(IntegerProperty productID) {
        products.stream().filter((a) -> (productID == a.productID)).forEach((a) -> {
            products.remove(a);
        });
        return true;
    }
    
    public Product lookupProduct(IntegerProperty productID) {
        // funtionality will be addressed elsewhere - be sure to update comment
        
    }
    
    public void updateProduct(int productID) {
        // funtionality will be addressed elsewhere - be sure to update comment
    } 
    
    public void addPart(Part part) {
        allParts.add(part);
    }
    
    public boolean deletePart(Part part) {
        return allParts.remove(part);
        
    }
    
    public Part lookupPart(IntegerProperty partID) {
        // funtionality will be addressed elsewhere - be sure to update comment
    }
    
    public void updatePart(int partID) {
        // funtionality will be addressed elsewhere - be sure to update comment
    }
    
}
