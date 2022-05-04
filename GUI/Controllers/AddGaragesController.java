package GUI.Controllers;

import GUI.Config.Config;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddGaragesController {
    
    // Add Garage
    @FXML
    private TextField temp_garage_owner;
    @FXML
    private TextField temp_garage_name;
    @FXML
    private TextField temp_garage_size;
    @FXML
    private CheckBox temp_garage_is_locked;
    @FXML
    private TextField temp_garage_minimum_price;
    @FXML
    private TextArea temp_garage_description;
    @FXML
    private Button AddGarage;
    @FXML
    private TextField GarageAddError;
    @FXML
    private Button loginCaller;
    
    public void createGarage(ActionEvent event) {
        try {
            if (temp_garage_owner.getText().isEmpty()) {
                GarageAddError.setText("Please enter a valid User Name");
            }
            if (temp_garage_size.getText().isEmpty()) {
                GarageAddError.setText("Please enter a size");
            }
            // if (temp_garage_is_locked.getText().isEmpty()) {
                // GarageAddError.setText("Please check the box if is locked or not");
                // }
                if (temp_garage_minimum_price.getText().isEmpty()) {
                    GarageAddError.setText("Please enter a minimum price for the garage");
                }
                if (temp_garage_description.getText().isEmpty()) {
                    GarageAddError.setText("Please enter a description for the garage");
                }
                if (!Config.isNumeric(temp_garage_size.getText()) || !Config.isNumeric(temp_garage_minimum_price.getText())) {
                    GarageAddError.setText("Please enter a integers for Minimum price or for size");
                }
                
                if (!temp_garage_owner.getText().isEmpty() && !temp_garage_size.getText().isEmpty() && !temp_garage_minimum_price.getText().isEmpty() && !temp_garage_description.getText().isEmpty() && Config.isNumeric(temp_garage_size.getText()) &&
                        Config.isNumeric(temp_garage_minimum_price.getText())) {
                    
                    System.out.println(temp_garage_owner.getText());
                    System.out.println(temp_garage_description.getText());
                    System.out.println(Integer.parseInt(temp_garage_size.getText()));
                    System.out.println(Integer.parseInt(temp_garage_minimum_price.getText()));
                    
                    Config.createGarage( temp_garage_owner.getText(), null, true, temp_garage_description.getText(), Integer.parseInt(temp_garage_size.getText()), false, Integer.parseInt(temp_garage_minimum_price.getText()), temp_garage_name.getText());
                    GarageAddError.setText("Storage Created");
                }
            }
            catch (Exception e) {
                GarageAddError.setText(e.getMessage());
            }
        }
        
        public void switchToCallerDashboard() throws Exception {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/caller_dashboard.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage window = (Stage) loginCaller.getScene().getWindow();
            window.setScene(new Scene(root));
        }
    }
    