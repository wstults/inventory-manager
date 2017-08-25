/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public abstract class Part {
    
    private final SimpleIntegerProperty PartID= new SimpleIntegerProperty(0);
    private final SimpleStringProperty Name=new SimpleStringProperty("");
    private final SimpleDoubleProperty Price=new SimpleDoubleProperty(0.00);
    private final SimpleIntegerProperty InStock= new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty Min= new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty Max= new SimpleIntegerProperty(0);
    
    public Part () {
        
        
    }
    
    
    public void setName(String name) {
        Name.set(name);
    }
    
    public String getName() {
        return Name.get();
    }
    
    public StringProperty nameProperty() {
        return Name;
    }
    
    public void setPrice(double price) {
        Price.set(price);
    }
    
    public double getPrice() {
        return Price.get();
    }
    
    public DoubleProperty priceProperty() {
        return Price;
    }
    
    public void setInStock(int inStock) {
        InStock.set(inStock);
    }
    
    public int getInStock() {
        return InStock.get();
    }
    
    public IntegerProperty inStockProperty() {
        return InStock;
    }
    
    public void setMin(int min) {
        Min.set(min);
    }
    
    public int getMin() {
        return Min.get();
    }
    
    public IntegerProperty minProperty() {
        return Min;
    }
    
    public void setMax(int max) {
        Max.set(max);
    }
    
    public int getMax() {
        return Max.get();
    }
    
    public IntegerProperty maxProperty() {
        return Max;
    }
    
    public void setPartID(int partID) {
        PartID.set(partID);
    }
    
    public int getPartID() {
        return PartID.get();
    }
    
    public IntegerProperty partIDProperty() {
        return PartID;
    }
    
    
}
