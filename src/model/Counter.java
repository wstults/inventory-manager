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
public class Counter {

    
    private static int value = 1000;
    
    public static String getValue() {
        value++;
        return Integer.toString(value);
    }
    
    public static void decrement() {
        value--;
    }
    
    
    
}
