/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author William
 */
public abstract class Part {
    
    int partID;
    String name;
    double price;
    int inStock;
    int min;
    int max;
    
    
    protected void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    protected void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    protected void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
    public int getInStock() {
        return inStock;
    }
    
    protected void setMin(int min) {
        this.min = min;
    }
    
    public int getMin() {
        return min;
    }
    
    protected void setMax(int max) {
        this.max = max;
    }
    
    public int getMax() {
        return max;
    }
    
    protected void setPartID(int partID) {
        this.partID = partID;
    }
    
    public int getPartID() {
        return partID;
    }
    
    
}
