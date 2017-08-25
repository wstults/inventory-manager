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
    
    private final SimpleStringProperty CompanyName=new SimpleStringProperty("");
    
        public OutsourcedPart(int partID, String name, double price, int inStock, int min, int max, String companyName) {
        setPartID(partID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
        setCompanyName(companyName);
    }
    
    
    private void setCompanyName(String companyName) {
        CompanyName.set(companyName);
    }
    
    public String getCompanyName() {
        return CompanyName.get();
    }
    
    public StringProperty companyNameProperty() {
        return CompanyName;
    }
    
}
