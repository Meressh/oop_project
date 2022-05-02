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


public class MainFrameController implements Initializable {

    // Login caller
    @FXML
    private TextField temp_caller_id;
    @FXML
    private TextField temp_caller_name;
    @FXML
    private Button loginCaller;
    @FXML
    private TextField callerLoginError;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // updateLists(userList, vipuserList, garageList, specialgaragesList);
    }
    
    // Create caller
    public void createCaller(ActionEvent event) {
        try {
            if (temp_caller_name.getText().isEmpty()) {
                callerLoginError.setText("Please enter a valid Name");
            }

            if (temp_caller_id.getText().isEmpty()) {
                callerLoginError.setText("Please enter a valid ID");
            }

            if (!temp_caller_id.getText().isEmpty() && !temp_caller_name.getText().isEmpty()) {

                Config.createCaller(temp_caller_id.getText(), temp_caller_name.getText(), null, null, null, null);

                callerLoginError.setText("Caller succesfully created");

                // Switch to dashboard
                switchToCallerDashboard();
            }
        }
        catch (Exception e) {
            System.out.println(e);
            callerLoginError.setText("Some Error was made");
        }
    }
    // Switch to caller dashboard
    public void switchToCallerDashboard() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/caller_dashboard.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) loginCaller.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
