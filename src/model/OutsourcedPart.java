/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author William
 */
public class OutsourcedPart extends Part {
    
    private final StringProperty companyName;
    
        public OutsourcedPart(int partID, String name, double price, int inStock, int min, int max, String companyName) {
        Part.setPartID(partID);
        Part.setName(name);
        Part.setPrice(price);
        Part.setInStock(inStock);
        Part.setMin(min);
        Part.setMax(max);
        this.companyName = new SimpleStringProperty(companyName);
    }
    
    
    public void setCompanyName(String companyName) {
        this.companyName.set(companyName);
    }
    
    public String getCompanyName() {
        return companyName.get();
    }
    
    public StringProperty companyNameProperty() {
        return companyName;
    }
    
}
