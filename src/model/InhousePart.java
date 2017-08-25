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
    
    private final SimpleIntegerProperty MachineID=new SimpleIntegerProperty(0);
    
    
    public InhousePart(int partID, String name, double price, int inStock, int min, int max, int machineID) {
        
        setPartID(partID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
        setMachineID(machineID);
    }
    
    
    public void setMachineID(int machineID) {
        MachineID.set(machineID);
    }
    
    public int getMachineID() {
        return MachineID.get();
    }
    
    public IntegerProperty machineIDProperty(){
        return MachineID;
    }
    
       
}
