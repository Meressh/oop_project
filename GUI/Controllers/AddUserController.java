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
public class AddUserController {
    // Add User
    @FXML
    private TextField temp_user_id;
    @FXML
    private TextField temp_user_name;
    @FXML
    private Button AddUser;
    @FXML
    private TextField userAddError;
    @FXML
    private TextField user_psc;
    @FXML
    private TextField user_address;
    @FXML
    private TextField user_region;
    @FXML
    private TextField user_state;
    @FXML
    private Button loginCaller;

    public void createUser(ActionEvent event) {
        try {
            // Add VIP User
            if (temp_user_name.getText().isEmpty()) {
                userAddError.setText("Please enter a valid Name");
            }
            
            if (temp_user_id.getText().isEmpty()) {
                userAddError.setText("Please enter a valid ID");
            }
            
            if (!temp_user_id.getText().isEmpty() && !temp_user_name.getText().isEmpty()) {

                Config.createUser(temp_user_id.getText(), temp_user_name.getText(), user_psc.getText(), user_address.getText(), user_region.getText(), user_state.getText());

                userAddError.setText("User created");
            }
        }
        catch (Exception e) {
            userAddError.setText("Some Error was made");
        }
    }

    public void switchToCallerDashboard() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/caller_dashboard.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) loginCaller.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
