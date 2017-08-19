/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author William
 */
public abstract class Part {
    
    static IntegerProperty partID;
    private static StringProperty name;
    private static DoubleProperty price;
    private static IntegerProperty inStock;
    private static IntegerProperty min;
    private static IntegerProperty max;
    
    public Part () {
        
        
    }
    
    
    protected static void setName(String name) {
        Part.name.set(name);
    }
    
    public String getName() {
        return name.get();
    }
    
    public StringProperty nameProperty() {
        return name;
    }
    
    protected static void setPrice(double price) {
        Part.price.set(price);
    }
    
    public double getPrice() {
        return price.get();
    }
    
    public DoubleProperty priceProperty() {
        return price;
    }
    
    protected static void setInStock(int inStock) {
        Part.inStock.set(inStock);
    }
    
    public int getInStock() {
        return inStock.get();
    }
    
    public IntegerProperty inStockProperty() {
        return inStock;
    }
    
    protected static void setMin(int min) {
        Part.min.set(min);
    }
    
    public int getMin() {
        return min.get();
    }
    
    public IntegerProperty minProperty() {
        return min;
    }
    
    protected static void setMax(int max) {
        Part.max.set(max);
    }
    
    public int getMax() {
        return max.get();
    }
    
    public IntegerProperty maxProperty() {
        return max;
    }
    
    protected static void setPartID(int partID) {
        Part.partID.set(partID);
    }
    
    public int getPartID() {
        return partID.get();
    }
    
    public IntegerProperty partIDProperty() {
        return partID;
    }
    
    
}
