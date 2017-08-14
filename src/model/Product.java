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
public class Product {
    
    ArrayList<Part> associatedParts = new ArrayList<>();
    
    int productID;
    String name;
    double price;
    int inStock;
    int min;
    int max;
    
    public Product (int productID, String name, double price, int inStock, int min, int max) {
        setProductID(productID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
    }
    
    
    private void setName(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    private void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    private void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
    public int getInStock() {
        return inStock;
    }
    
    private void setMin(int min) {
        this.min = min;
    }
    
    public int getMin() {
        return min;
    }
    
    private void setMax(int max) {
        this.max = max;
    }
    
    public int getMax() {
        return max;
    }
    
    public void addAssociatedPart(Part part) {
        // method text
    }
    
    public boolean removeAssociatedPart(int partID) {
        // method text
        return true;
    }
    
    public Part lookupAssociatedPart(int productID) {
        // method text
        
    }
    
    private void setProductID(int productID) {
        this.productID = productID;
    }
    
    public int getProductID() {
        return productID;
    }
    
}
