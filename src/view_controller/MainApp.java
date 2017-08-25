/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view_controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.InhousePart;
import model.Inventory;
import model.OutsourcedPart;
import model.Product;
import view_controller.MainScreenController;

/**
 *
 * @author William
 */
public class MainApp extends Application {
    
    



    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    

    
    public static void main(String[] args) {
        
        InhousePart newInhousePart = new InhousePart(0001, "Gizmo", 5.00, 55, 1, 99, 4343);
        Inventory.addPart(newInhousePart);
        OutsourcedPart newOutsourcedPart = new OutsourcedPart(0002, "Cog", 10.00, 55, 1, 99, "Cogworld");
        Inventory.addPart(newOutsourcedPart);
        Product newProduct = new Product(3, "Contraption", 20.00, 22, 1, 99);
        Inventory.addProduct(newProduct);
        newProduct.addAssociatedPart(newInhousePart);
        newProduct.addAssociatedPart(newOutsourcedPart);
        
        launch(args);
        
        
        
    }
    
    
    
}
