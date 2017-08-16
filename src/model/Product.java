/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author William
 */
public class Product {
    
    ArrayList<Part> associatedParts = new ArrayList<>();
    
    protected final IntegerProperty productID;
    private final StringProperty name;
    private final DoubleProperty price;
    private final IntegerProperty inStock;
    private final IntegerProperty min;
    private final IntegerProperty max;
    
    public Product (int productID, String name, double price, int inStock, int min, int max) {
        this.productID = new SimpleIntegerProperty(productID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.inStock = new SimpleIntegerProperty(inStock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
    }
    
    
    private void setName(String name){
        this.name.set(name);
    }
    
    public String getName() {
        return name.get();
    }
    
    public StringProperty nameProperty() {
        return name;
    }
    
    private void setPrice(double price) {
        this.price.set(price);
    }
    
    public double getPrice() {
        return price.get();
    }
    
    public DoubleProperty priceProperty() {
        return price;
    }
    
    private void setInStock(int inStock) {
        this.inStock.set(inStock);
    }
    
    public int getInStock() {
        return inStock.get();
    }
    
    public IntegerProperty inStockProperty() {
        return inStock;
    }
    
    private void setMin(int min) {
        this.min.set(min);
    }
    
    public int getMin() {
        return min.get();
    }
    
    public IntegerProperty minProperty() {
        return min;
    }
    
    private void setMax(int max) {
        this.max.set(max);
    }
    
    public int getMax() {
        return max.get();
    }
    
    public IntegerProperty maxProperty() {
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
        this.productID.set(productID);
    }
    
    public int getProductID() {
        return productID.get();
    }
    
    public IntegerProperty productIDProperty() {
        return productID;
    }
    
}
