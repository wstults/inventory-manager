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
    
    
    
    public void setPrice(double price) {
        Price.set(price);
    }
    
    public double getPrice() {
        return Price.get();
    }
    
    
    
    public void setInStock(int inStock) {
        InStock.set(inStock);
    }
    
    public int getInStock() {
        return InStock.get();
    }
    
    
    
    public void setMin(int min) {
        Min.set(min);
    }
    
    public int getMin() {
        return Min.get();
    }
    
    
    
    public void setMax(int max) {
        Max.set(max);
    }
    
    public int getMax() {
        return Max.get();
    }
    
    
    
    public void addAssociatedPart(Part part) {
        associatedParts.add(part);
    }
    
    public boolean removeAssociatedPart(int partID) {
        associatedParts.stream().filter((p) -> (p.getPartID() == partID)).forEach((p) -> {
            associatedParts.remove(p);
        });
        return true;
    }
    
    public Part lookupAssociatedPart(int productID) {
        // functionality is handled via the initialize method in ModifyProductScreenController
        InhousePart placeHolder = new InhousePart(777, "Placeholder", 5.00, 55, 1, 99, 4343);
        return placeHolder;
    } 
    
    public void setProductID(int productID) {
        ProductID.set(productID);
    }
    
    public int getProductID() {
        return ProductID.get();
    }
    
    
    
}
