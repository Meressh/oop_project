package GUI;

import Users.User;
import Users.VIPUser;

import java.util.Scanner;
import java.util.Timer;

import GUI.App;

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

public class Controller implements Initializable {
        // public static Caller caller;
        // List View data
        @FXML
        public ListView<String> userList;
        @FXML
        public ListView<String> vipuserList;
        @FXML
        public ListView<String> garageList;
        @FXML
        public ListView<String> specialgaragesList;

        // Login caller
        @FXML
        private TextField temp_caller_id;
        @FXML
        private TextField temp_caller_name;
        @FXML
        private Button loginCaller;
        @FXML
        private TextField callerLoginError;

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

        // Add VIP User
        @FXML
        private TextField temp_userVIP_id;
        @FXML
        private TextField temp_userVIP_name;
        @FXML
        private Button AddUserVIP;
        @FXML
        private TextField userVIPAddError;
        @FXML
        private TextField vip_psc;
        @FXML
        private TextField vip_address;
        @FXML
        private TextField vip_region;
        @FXML
        private TextField vip_state;
        // Add Special Garage
        @FXML
        private TextField temp_special_garage_owner;
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

        // Add Garage
        @FXML
        private TextField temp_garage_owner;
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

        // Add buttons in Caller dashboard
        @FXML
        private Button AddUserButton;
        @FXML
        private Button AddVIPUserButton;
        @FXML
        private Button AddSpecialGaragesButton;
        @FXML
        private Button AddGarageButton;

        // Caller
        public static Caller caller;
        public Timer time;

        public static int Auctions; // How many auction have been executed "today"
        public static int ActiveNumberOfUsers = 0; // How many users are now bidding
        public static int ActiveNumberOfVIPUsers = 0; // How many VIP users are now bidding

        public static int ActiveNumberOfStorages = 0; // How many Storages are now in auction
        public static int ActiveNumberOfStoragesSpecial = 0; // How many Special Storages are now in auction

        public static int ALlTimeUsers = 0; // All time users
        public static int ALlTimeVIPUsers = 0; // All time users

        public static int AllTimeStorages = 0; // All time Garages
        public static int AllTimeStoragesSpecial = 0; // All time Special Garages

        public static boolean Active = false; // If auction is rolling now

        public static ArrayList<User> Users = new ArrayList<User>(); // Create ArrayList for store Users which are added to auction
        public static ArrayList<VIPUser> VIPUsers = new ArrayList<VIPUser>(); // Create ArrayList for store VIPusers which are added to auction
        public static ArrayList<Garage> Garages = new ArrayList<Garage>(); // Create ArrayList for store Garages which are added to auction
        public static ArrayList<SpecialGarage> SpecialGarages = new ArrayList<SpecialGarage>(); // Create ArrayList for store SpecialGarages which are added to auction

        // List Data
        // @FXML
        // private ResourceBundle resources;

        // @FXML
        // private URL location;

        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {
                // updateLists(userList, vipuserList, garageList, specialgaragesList);
        }

        static void updateLists(ListView<String> listUsers, ListView<String> listVIPUsers, ListView<String> listGarage, ListView<String> listSpecialGarage) {
                for (int i = 0; i < Users.size(); i++) {
                        listUsers.getItems().add(Users.get(i).getName());
                }

                for (int i = 0; i < VIPUsers.size(); i++) {
                        listVIPUsers.getItems().add(VIPUsers.get(i).getName());
                }

                for (int i = 0; i < Garages.size(); i++) {
                        listGarage.getItems().add(Garages.get(i).getName());
                }

                for (int i = 0; i < SpecialGarages.size(); i++) {
                        listSpecialGarage.getItems().add(SpecialGarages.get(i).getName());
                }
        }

        public static boolean isNumeric(String strNum) {
                if (strNum == null) {
                        return false;
                }
                try {
                        double d = Double.parseDouble(strNum);
                }
                catch (NumberFormatException nfe) {
                        return false;
                }
                return true;
        }

        public void switchToCallerDashboard() throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("caller_dashboard.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                fxmlLoader.setController("GUI.Controller.java");
                Stage window = (Stage) loginCaller.getScene().getWindow();
                window.setScene(new Scene(root));
        }

        public void switchToAddUser() throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_user.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage window = (Stage) AddUserButton.getScene().getWindow();
                window.setScene(new Scene(root));
        }

        public void switchToAddGarage() throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_garages.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage window = (Stage) AddGarageButton.getScene().getWindow();
                window.setScene(new Scene(root));
        }
        public void switchToAddSpecialGarages() throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_special_garages.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage window = (Stage) AddSpecialGaragesButton.getScene().getWindow();
                window.setScene(new Scene(root));
        }

        public void switchToAddVIPUsers() throws Exception {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_vip_user.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage window = (Stage) AddVIPUserButton.getScene().getWindow();
                window.setScene(new Scene(root));
        }

        public void createCaller(ActionEvent event) {
                try {
                        if (temp_caller_name.getText().isEmpty()) {
                                callerLoginError.setText("Please enter a valid Name");
                        }

                        if (temp_caller_id.getText().isEmpty()) {
                                callerLoginError.setText("Please enter a valid ID");
                        }

                        if (!temp_caller_id.getText().isEmpty() && !temp_caller_name.getText().isEmpty()) {
                                caller = new Caller(temp_caller_id.getText(), temp_caller_name.getText(), null, null, null, null);

                                // Switch to dashboard
                                switchToCallerDashboard();
                        }
                }
                catch (Exception e) {
                        System.out.println(e);
                        callerLoginError.setText("Some Error was made");
                }
        }

        public void createVIPUser(ActionEvent event) {
                try {
                        if (temp_userVIP_name.getText().isEmpty()) {
                                userVIPAddError.setText("Please enter a valid Name");
                        }

                        if (temp_userVIP_id.getText().isEmpty()) {
                                userVIPAddError.setText("Please enter a valid ID");
                        }

                        if (!temp_userVIP_id.getText().isEmpty() && !temp_userVIP_name.getText().isEmpty()) {
                                VIPUsers.add(ActiveNumberOfVIPUsers, caller.AddVIPUser(temp_userVIP_id.getText(), temp_userVIP_name.getText(), vip_psc.getText(), vip_address.getText(), vip_region.getText(), vip_state.getText()));

                                ActiveNumberOfVIPUsers++;
                                ALlTimeVIPUsers++;
                                userVIPAddError.setText("VIP User created");
                        }
                }
                catch (Exception e) {
                        System.out.println(e);
                        userVIPAddError.setText("Some Error was made");
                }
        }

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
                                User CurretnUser = caller.AddUser(temp_user_id.getText(), temp_user_name.getText(), user_psc.getText(), user_address.getText(), user_region.getText(), user_state.getText());

                                Users.add(ActiveNumberOfUsers, CurretnUser);

                                ActiveNumberOfUsers++;
                                ALlTimeUsers++;
                                userAddError.setText("User created");
                        }
                }
                catch (Exception e) {
                        userAddError.setText("Some Error was made");
                }
        }

        public void createGarage(ActionEvent event) {
                try {
                        if (temp_garage_owner.getText().isEmpty()) {
                                GarageAddError.setText("Please enter a valid User Name");
                        }
                        if (temp_garage_size.getText().isEmpty()) {
                                GarageAddError.setText("Please enter a size");
                        }
                        // if (temp_garage_is_locked.getText().isEmpty()) {
                        //         GarageAddError.setText("Please check the box if is locked or not");
                        // }
                        if (temp_garage_minimum_price.getText().isEmpty()) {
                                GarageAddError.setText("Please enter a minimum price for the garage");
                        }
                        if (temp_garage_description.getText().isEmpty()) {
                                GarageAddError.setText("Please enter a description for the garage");
                        }
                        if(!isNumeric(temp_garage_size.getText()) || !isNumeric(temp_garage_minimum_price.getText())){
                                GarageAddError.setText("Please enter a integers for Minimum price or for size");
                        }

                        if (!temp_garage_owner.getText().isEmpty() && !temp_garage_size.getText().isEmpty() && !temp_garage_minimum_price.getText().isEmpty() && !temp_garage_description.getText().isEmpty() &&isNumeric(temp_garage_size.getText()) && isNumeric(temp_garage_minimum_price.getText()) ) {

                                System.out.println(temp_garage_owner.getText());
                                System.out.println(temp_garage_description.getText());
                                System.out.println(Integer.parseInt(temp_garage_size.getText()));
                                System.out.println(Integer.parseInt(temp_garage_minimum_price.getText()));

                                Garage CurrentGarage = caller.AddGarage(temp_garage_owner.getText(), null, true, temp_garage_description.getText(), Integer.parseInt(temp_garage_size.getText()) , false, Integer.parseInt(temp_garage_minimum_price.getText()));
                                System.out.println("aaaaaa" + CurrentGarage.getOldOwner());
                                

                                Garages.add(ActiveNumberOfStorages, CurrentGarage);

                                ActiveNumberOfStorages++;
                                AllTimeStorages++;

                                GarageAddError.setText("Storage Created");
                        }
                }
                catch (Exception e) {
                        callerLoginError.setText("Some Error was made");
                }
        }

        public void createSpecialGarage(ActionEvent event) {
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

                        if (!temp_caller_id.getText().isEmpty() && !temp_caller_name.getText().isEmpty()) {
                                SpecialGarage CurrentSpecialGarage = caller.AddSpecialGarage(temp_garage_owner.getText(), null, (temp_garage_is_locked.getText().isEmpty() ? true : false),temp_garage_description.getText(), Integer.parseInt(temp_garage_size.getText()) , false, Integer.parseInt(temp_garage_minimum_price.getText()));

                                SpecialGarages.add(ActiveNumberOfStoragesSpecial, caller.AddSpecialGarage());

                                ActiveNumberOfStoragesSpecial++;
                                AllTimeStoragesSpecial++;

                                callerLoginError.setText("Special storage Created");
                        }
                }
                catch (Exception e) {
                        callerLoginError.setText("Some Error was made");
                }
        }
}