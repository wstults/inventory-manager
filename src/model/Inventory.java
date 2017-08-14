/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Inventory {
    
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Part> allParts = new ArrayList<>();
    
    public void addProduct(Product product){
        // method text
    }
    
    public boolean removeProduct(int productID) {
        // method text
        return true;
    }
    
    public Product lookupProduct(int productID) {
        for (Product a : products) {
            if (productID == a.productID) 
            return a;
    }
    
    public void updateProduct(int productID) {
        // method text
    } 
    
    public void addPart(Part part) {
        //method text
    }
    
    public boolean deletePart(Part part) {
        // method text
        return true;
    }
    
    public Part lookupPart(int partID) {
        // method text
    }
    
    public void updatePart(int partID) {
        // method text
    }
    
}
