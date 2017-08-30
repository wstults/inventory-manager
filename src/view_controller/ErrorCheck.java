/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import model.Part;
import model.Product;

/**
 *
 * @author William
 */
public class ErrorCheck {
    
    public static boolean invCheck(int min, int max, int inv) {
        boolean invAccept = true;
        if (inv < min) {
            invAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("Inventory level must be greater than or equal to minimum.");

            alert.showAndWait();
        }
        else if (inv > max) {
            invAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("Inventory level must be less than or equal to maximum.");

            alert.showAndWait();
        
        }
        return invAccept;
    }
    
    public static boolean maxCheck (int min, int max) {
        boolean maxAccept = true;
        if (max < min) {
            maxAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("Maximum cannot be less than minimum.");

            alert.showAndWait();
        }
        return maxAccept;
    }
    
    public static boolean minCheck (int min, int max) {
        boolean minAccept = true;
        if (max < min) {
            minAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("Minimum cannot be greater than maximum.");

            alert.showAndWait();
        }
        return minAccept;
    }
    
    public static boolean associatedPartCheck(Product product) {
        boolean associatedPartAccept = true;
        if (product.associatedParts.isEmpty() == true) {
            associatedPartAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("Products must have at least one associated part.");

            alert.showAndWait();
        }
        return associatedPartAccept;
    }
    
    public static boolean productDeleteCheck(Product product) {
        boolean productDeleteAccept = true;
        if (product.associatedParts.isEmpty() == false) {
            productDeleteAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("You may not delete a product that has associated parts.");

            alert.showAndWait();
        }
        return productDeleteAccept;
    }
    
    public static boolean deleteConfirm() {
        boolean deleteAccept = false;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirm Delete!");
        alert.setContentText("Are you sure you want to delete?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            deleteAccept = true;
        }
        return deleteAccept;
    }
    
    public static boolean cancelConfirm() {
        boolean cancelAccept = false;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirm Cancel!");
        alert.setContentText("Are you sure you want to cancel?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            cancelAccept = true;
        }
        return cancelAccept;
    }
    
    public static boolean productPartsPriceCheck (Product product, double price) {
        boolean productPartsPriceAccept = true;
        double partsPriceTotal = 0.00;
        for (Part a : product.associatedParts) {
            partsPriceTotal = partsPriceTotal + a.getPrice();
        }
        if (price < partsPriceTotal) {
            productPartsPriceAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("Product price is less than the sum of the prices of its parts.");

            alert.showAndWait();
        }
        return productPartsPriceAccept;
    }
    
    public static boolean nameCheck(String name) {
        boolean nameAccept = true;
        if ("".equals(name)) {
            nameAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("You must enter a name.");

            alert.showAndWait();
        }
        return nameAccept;
    }
    
    public static boolean priceCheck(String price) {
        boolean priceAccept = true;
        if ("".equals(price)) {
            priceAccept = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText("Error");
            alert.setContentText("You must enter a price.");

            alert.showAndWait();
        }
        return priceAccept;
    }
    
    public static boolean invCheckDefault(String inv) {
        boolean invAccept = true;
        if ("".equals(inv)) {
            invAccept = false;
        }
        return invAccept;
    }
    
    public static boolean modifyPartDeleteCheck() {
        boolean modifyPartDeleteAccept = false;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirm Delete!");
        alert.setContentText("WARNING: Changing the part's Inhouse / Outsourced status will delete the current part and recreate a new part.  Proceed?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            modifyPartDeleteAccept = true;
        }
        return modifyPartDeleteAccept;
    }
    
    public static boolean exitCheck() {
        boolean exitAccept = false;
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Confirm Delete!");
        alert.setContentText("Exit the application?");
        
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            exitAccept = true;
        }
        return exitAccept;
    }
    
}
