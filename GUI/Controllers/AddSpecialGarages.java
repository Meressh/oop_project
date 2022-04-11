package GUI.Controllers;

import Users.User;
import Users.VIPUser;

import java.util.Scanner;
import java.util.Timer;

import GUI.Config.Config;

import java.util.ArrayList;
import java.util.List;

import Storages.Garage;
import Storages.SpecialGarage;
import Storages.Storage;
import Users.Caller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class AddSpecialGarages {
    
    // Add Special Garage
    @FXML
    private TextField temp_special_garage_owner;
    @FXML
    private TextField temp_special_garage_name;
    @FXML
    private TextField temp_special_garage_size;
    @FXML
    private TextField temp_special_garage_specialItems;
    @FXML
    private CheckBox temp_special_garage_is_locked;
    @FXML
    private TextField temp_special_garage_minimum_price;
    @FXML
    private TextArea temp_special_garage_description;
    @FXML
    private TextArea temp_special_garage_history;
    @FXML
    private Button AddSpecialGarage;
    @FXML
    private TextField specialGarageAddError;
    @FXML
    private Button loginCaller;
    
    public void createSpecialGarage(ActionEvent event) {
        try {
            // private CheckBox temp_special_garage_is_locked;
            
            if (temp_special_garage_owner.getText().isEmpty()) {
                specialGarageAddError.setText("Please enter a valid User Name");
            }
            if (temp_special_garage_size.getText().isEmpty()) {
                specialGarageAddError.setText("Please enter a size");
            }
            // if (temp_garage_is_locked.getText().isEmpty()) {
                // specialGarageAddError.setText("Please check the box if is locked or not");
                // }
                if (temp_special_garage_minimum_price.getText().isEmpty()) {
                    specialGarageAddError.setText("Please enter a minimum price for the garage");
                }
                if (temp_special_garage_specialItems.getText().isEmpty()) {
                    specialGarageAddError.setText("Please enter Special Items for the garage");
                }
                if (temp_special_garage_description.getText().isEmpty()) {
                    specialGarageAddError.setText("Please enter a description for the garage");
                }
                if (temp_special_garage_history.getText().isEmpty()) {
                    specialGarageAddError.setText("Please enter the history for the garage");
                }
                
                if (!Config.isNumeric(temp_special_garage_size.getText()) || !Config.isNumeric(temp_special_garage_minimum_price.getText())) {
                    specialGarageAddError.setText("Please enter a integers for Minimum price or for size");
                }
                
                if (!temp_special_garage_owner.getText().isEmpty() && !temp_special_garage_size.getText().isEmpty() && !temp_special_garage_history.getText().isEmpty() && !temp_special_garage_specialItems.getText().isEmpty() &&
                !temp_special_garage_minimum_price.getText().isEmpty() && !temp_special_garage_description.getText().isEmpty() && Config.isNumeric(temp_special_garage_size.getText()) && Config.isNumeric(temp_special_garage_minimum_price.getText())) {
                    
                    
                    Config.createSpecialGarage(temp_special_garage_owner.getText(), null, true, temp_special_garage_description.getText(), Integer.parseInt(temp_special_garage_size.getText()), false,
                            Integer.parseInt(temp_special_garage_minimum_price.getText()), temp_special_garage_specialItems.getText(), temp_special_garage_history.getText(), temp_special_garage_name.getText());
                    
                    specialGarageAddError.setText("Special storage Created");
                }
            }
            catch (Exception e) {
                System.out.println(e);
                specialGarageAddError.setText("Some Error was made");
            }
            
        }
        
        public void switchToCallerDashboard() throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/caller_dashboard.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage window = (Stage) loginCaller.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }
    