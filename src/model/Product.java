/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author William
 */
public class Product {
    
    public ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    
    final SimpleIntegerProperty ProductID=new SimpleIntegerProperty(0);
    private final SimpleStringProperty Name=new SimpleStringProperty("");
    private final SimpleDoubleProperty Price=new SimpleDoubleProperty(0.00);
    private final SimpleIntegerProperty InStock=new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty Min=new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty Max=new SimpleIntegerProperty(0);
    
    public Product (int productID, String name, double price, int inStock, int min, int max) {
        setProductID(productID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
    }
    
    public ObservableList<Part> getAssociatedParts() {
        return associatedParts;
    }
    
    
    public void setName(String name){
        Name.set(name);
    }
    
    public String getName() {
        return Name.get();
    }
    
    /*public StringProperty nameProperty() {
        return name;
    }*/
    
    public void setPrice(double price) {
        Price.set(price);
    }
    
    public double getPrice() {
        return Price.get();
    }
    
    /*public DoubleProperty priceProperty() {
        return price;
    }*/
    
    public void setInStock(int inStock) {
        InStock.set(inStock);
    }
    
    public int getInStock() {
        return InStock.get();
    }
    
    /*public IntegerProperty inStockProperty() {
        return inStock;
    }*/
    
    public void setMin(int min) {
        Min.set(min);
    }
    
    public int getMin() {
        return Min.get();
    }
    
    /*public IntegerProperty minProperty() {
        return min;
    }*/
    
    public void setMax(int max) {
        Max.set(max);
    }
    
    public int getMax() {
        return Max.get();
    }
    
    /*public IntegerProperty maxProperty() {
        return max;
    }*/
    
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }
    
    public boolean removeAssociatedPart(int partID) {
        associatedParts.stream().filter((p) -> (p.getPartID() == partID)).forEach((p) -> {
            associatedParts.remove(p);
        });
        return true;
    }
    /*
    public Part lookupAssociatedPart(int productID) {
        // functionality will be addressed elsewhere - return to update comment
        
    } */
    
    public void setProductID(int productID) {
        ProductID.set(productID);
    }
    
    public int getProductID() {
        return ProductID.get();
    }
    
    /*public IntegerProperty productIDProperty() {
        return productID;
    }*/
    
}
