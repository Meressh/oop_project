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

public class DashboardController implements Initializable {
    // List View data
    @FXML
    public ListView<String> userList;
    @FXML
    public ListView<String> vipuserList;
    @FXML
    public ListView<String> garageList;
    @FXML
    public ListView<String> specialgaragesList;
    
    // Add buttons in Caller dashboard
    @FXML
    private Button AddUserButton;
    @FXML
    private Button AddVIPUserButton;
    @FXML
    private Button AddSpecialGaragesButton;
    @FXML
    private Button AddGarageButton;
    @FXML
    private Button StartAuction;
    @FXML
    private Button switchToDashboard;
    @FXML
    private TextField small_amout_users;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        for (int i = 0; i < Config.Users.size(); i++) {
            userList.getItems().add(Config.Users.get(i).getName());
        }
        
        for (int i = 0; i < Config.VIPUsers.size(); i++) {
            vipuserList.getItems().add(Config.VIPUsers.get(i).getName());
        }
        
        for (int i = 0; i < Config.Garages.size(); i++) {
            garageList.getItems().add(Config.Garages.get(i).getName());
        }
        
        for (int i = 0; i < Config.SpecialGarages.size(); i++) {
            specialgaragesList.getItems().add(Config.SpecialGarages.get(i).getName());
        }
    }
    // Switch to Dashboard
    public void switchToCallerDashboard() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/caller_dashboard.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) switchToDashboard.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    // Start Auction
    public void startAuction() throws Exception {
        if(Config.Users.size() > 2){
            Config.Active = true;
            Config.Auctions = Config.Auctions + 1;

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/auction.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage window = (Stage) StartAuction.getScene().getWindow();
            window.setScene(new Scene(root));
        }else{
            small_amout_users.setText("Minimum of users is 2");
        }
    }
    // Switch to Add user Dashboard
    public void switchToAddUser() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/add_user.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) AddUserButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    // Switch to Add garage Dashboard
    public void switchToAddGarage() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/add_garages.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) AddGarageButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    // Switch to Add special garage Dashboard
    public void switchToAddSpecialGarages() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/add_special_garages.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) AddSpecialGaragesButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    // Switch to Add vip user Dashboard
    public void switchToAddVIPUsers() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/add_vip_user.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) AddVIPUserButton.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}