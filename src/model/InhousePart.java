/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author William
 */
public class InhousePart extends Part{
    
    private final IntegerProperty machineID;
    
    
    public InhousePart(int partID, String name, double price, int inStock, int min, int max, int machineID) {
        
        Part.setPartID(partID);
        Part.setName(name);
        Part.setPrice(price);
        Part.setInStock(inStock);
        Part.setMin(min);
        Part.setMax(max);
        this.machineID = new SimpleIntegerProperty(machineID);
    }
    
    
    private void setMachineID(int machineID) {
        this.machineID.set(machineID);
    }
    
    public int getMachineID() {
        return machineID.get();
    }
    
    public IntegerProperty machineIDProperty(){
        return machineID;
    }
    
       
}
