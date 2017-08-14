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
public class InhousePart extends Part{
    
    int machineID;
    
    public InhousePart(int partID, String name, double price, int inStock, int min, int max, int machineID) {
        setPartID(partID);
        setName(name);
        setPrice(price);
        setInStock(inStock);
        setMin(min);
        setMax(max);
        setMachineID(machineID);
    }
    
    
    private void setMachineID(int machineID) {
        this.machineID = machineID;
    }
    
    public int getMachineID() {
        return machineID;
    }
    
    
    
}
