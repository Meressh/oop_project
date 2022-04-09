package GUI;

import Users.User;
import Users.VIPUser;

import java.util.Scanner;
import java.util.Timer;

import GUI.App;

import java.util.ArrayList;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
        // public static Caller caller;
        //Login caller
        @FXML
        private TextField temp_caller_id;
        @FXML
        private TextField temp_caller_name;
        @FXML
        private Button loginCaller;
        @FXML
        private TextField callerLoginError;
        
        //Add User
        @FXML
        private TextField temp_user_id;
        @FXML
        private TextField temp_user_name;
        @FXML
        private Button AddUser;
        @FXML
        private TextField userAddError;
        
        // Add VIP User
        @FXML
        private TextField temp_userVIP_id;
        @FXML
        private TextField temp_userVIP_name;
        @FXML
        private Button AddUserVIP;
        @FXML
        private TextField userVIPAddError;

        // Add Special Garage
        @FXML
        private TextField temp_special_garage_owner;
        @FXML
        private TextField temp_special_garage_size;
        @FXML
        private TextField temp_special_garage_specialItems;
        @FXML
        private TextField temp_special_garage_is_locked;
        @FXML
        private TextField temp_special_garage_minimum_price;
        @FXML
        private TextField temp_special_garage_description;
        @FXML
        private TextField temp_special_garage_history;
        @FXML
        private Button AddSpecialGarage;
        @FXML
        private TextField specialGarageAddError;
        
        //Add buttons in Caller dashboard
        @FXML
        private Button AddUserButton;
        @FXML
        private Button AddVIPUserButton;
        @FXML
        private Button AddSpecialGaragesButton;
        @FXML
        private Button AddGarageButton;
        
        
        // Caller
        Caller caller;
        
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
        
        // Setup timer
        // public static void Timer() {
                //         long startTime = System.nanoTime(); // Start nanoTimer
                // }
                
                // Function which save / edit / delete data durring live auction
                // public static void ProcessBid(int bid, Storage storage) {
                        //         if (bid > storage.MinimumPrice) {
                                //                 BidValue = bid;
                                //         }
                                // }
                                public void switchToCallerDashboard() throws Exception{
                                        // Parent root = FXMLLoader.load(getClass().getResource("caller_dashboard.fxml"));
                                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("caller_dashboard.fxml"));
                                        Parent root = (Parent) fxmlLoader.load();
                                        Stage window = (Stage) loginCaller.getScene().getWindow();
                                        window.setScene(new Scene(root));
                                }
                                
                                public void switchToAddUser() throws Exception {
                                        // Parent root = FXMLLoader.load(getClass().getResource("caller_dashboard.fxml"));
                                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_user.fxml"));
                                        Parent root = (Parent) fxmlLoader.load();
                                        Stage window = (Stage) AddUserButton.getScene().getWindow();
                                        window.setScene(new Scene(root));
                                }
                                
                                public void switchToAddGarage() throws Exception {
                                        // Parent root = FXMLLoader.load(getClass().getResource("caller_dashboard.fxml"));
                                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_garages.fxml"));
                                        Parent root = (Parent) fxmlLoader.load();
                                        Stage window = (Stage) AddGarageButton.getScene().getWindow();
                                        window.setScene(new Scene(root));
                                }
                                
                                public void switchToAddSpecialGarages() throws Exception {
                                        // Parent root = FXMLLoader.load(getClass().getResource("caller_dashboard.fxml"));
                                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_special_garages.fxml"));
                                        Parent root = (Parent) fxmlLoader.load();
                                        Stage window = (Stage) AddSpecialGaragesButton.getScene().getWindow();
                                        window.setScene(new Scene(root));
                                }
                                
                                public void switchToAddVIPUsers() throws Exception {
                                        // Parent root = FXMLLoader.load(getClass().getResource("caller_dashboard.fxml"));
                                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add_vip_user.fxml"));
                                        Parent root = (Parent) fxmlLoader.load();
                                        Stage window = (Stage) AddVIPUserButton.getScene().getWindow();
                                        window.setScene(new Scene(root));
                                }
                                
                                public void createCaller(ActionEvent event) {
                                        try {
                                                callerLoginError.setText("Please enter a valid Name");
                                                
                                                if (temp_caller_name.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid Name");
                                                }
                                                
                                                if(temp_caller_id.getText().isEmpty()){
                                                        callerLoginError.setText("Please enter a valid ID");
                                                }
                                                
                                                if(!temp_caller_id.getText().isEmpty() && !temp_caller_name.getText().isEmpty()){
                                                        caller = new Caller(temp_caller_id.getText(), temp_caller_name.getText());
                                                        System.out.println(caller.getName());
                                                        
                                                        // Switch to dashboard
                                                        switchToCallerDashboard();
                                                }
                                        } catch (Exception e) {
                                                callerLoginError.setText("Some Error was made");
                                        }
                                }
                                
                                public void createVIPUser(ActionEvent event) {
                                        try {
                                                callerLoginError.setText("Please enter a valid Name");
                                                
                                                if (temp_caller_name.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid Name");
                                                }
                                                
                                                if (temp_caller_id.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid ID");
                                                }
                                                
                                                if (!temp_caller_id.getText().isEmpty() && !temp_caller_name.getText().isEmpty()) {
                                                        VIPUsers.add(ActiveNumberOfVIPUsers, caller.AddVIPUser());
                                                        
                                                        ActiveNumberOfVIPUsers++;
                                                        ALlTimeVIPUsers++;

                                                        callerLoginError.setText("VIP User created");
                                                }
                                        }
                                        catch (Exception e) {
                                                callerLoginError.setText("Some Error was made");
                                        }
                                }
                                
                                public void createUser(ActionEvent event) {
                                        try {
                                                callerLoginError.setText("Please enter a valid Name");
                                                
                                                if (temp_caller_name.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid Name");
                                                }
                                                
                                                if (temp_caller_id.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid ID");
                                                }
                                                
                                                if (!temp_caller_id.getText().isEmpty() && !temp_caller_name.getText().isEmpty()) {
                                                        Users.add(ActiveNumberOfUsers, caller.AddUser());
                                                        ActiveNumberOfUsers++;
                                                        ALlTimeUsers++;
                                                        
                                                        callerLoginError.setText("User created");
                                                }
                                        }
                                        catch (Exception e) {
                                                callerLoginError.setText("Some Error was made");
                                        }
                                }
                                
                                public void createGarage(ActionEvent event) {
                                        try {
                                                callerLoginError.setText("Please enter a valid Name");
                                                
                                                if (temp_caller_name.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid Name");
                                                }
                                                
                                                if (temp_caller_id.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid ID");
                                                }
                                                
                                                if (!temp_caller_id.getText().isEmpty() && !temp_caller_name.getText().isEmpty()) {
                                                        Garages.add(ActiveNumberOfStorages, caller.AddGarage());
                                                        
                                                        ActiveNumberOfStorages++;
                                                        AllTimeStorages++;

                                                        callerLoginError.setText("Storage Created");
                                                }
                                        }
                                        catch (Exception e) {
                                                callerLoginError.setText("Some Error was made");
                                        }
                                }
                                
                                public void createSpecialGarage(ActionEvent event) {
                                        try {
                                                callerLoginError.setText("Please enter a valid Name");
                                                
                                                if (temp_caller_name.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid Name");
                                                }
                                                
                                                if (temp_caller_id.getText().isEmpty()) {
                                                        callerLoginError.setText("Please enter a valid ID");
                                                }
                                                
                                                if (!temp_caller_id.getText().isEmpty() && !temp_caller_name.getText().isEmpty()) {
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
                                
                                // Place where all begins
                                public static void main(String[] args) {
                                        
                                        // ?? Add some storages which will be sold -> iny sposob pridavania ako pri pridavani Vyvolavaca/Caller -> getters/setters
                                        System.out.println("Pridajte sklady na predaj!");
                                        
                                        do {
                                                // ?? Basic Garage
                                                if (option.equals("1")) {
                                                        Garages.add(ActiveNumberOfStorages, caller.AddGarage());
                                                        
                                                        ActiveNumberOfStorages++;
                                                        AllTimeStorages++;
                                                }
                                                
                                                // ?? Special Garage
                                                if (option.equals("2")) {
                                                        SpecialGarages.add(ActiveNumberOfStoragesSpecial, caller.AddSpecialGarage());
                                                        
                                                        ActiveNumberOfStoragesSpecial++;
                                                        AllTimeStoragesSpecial++;
                                                }
                                                
                                                // ?? User
                                                if (option.equals("3")) {
                                                        Users.add(ActiveNumberOfUsers, caller.AddUser());
                                                        
                                                        ActiveNumberOfUsers++;
                                                        ALlTimeUsers++;
                                                }
                                                
                                                // ?? VIPUser
                                                if (option.equals("4")) {
                                                        VIPUsers.add(ActiveNumberOfVIPUsers, caller.AddVIPUser());
                                                        
                                                        ActiveNumberOfVIPUsers++;
                                                        ALlTimeVIPUsers++;
                                                }
                                                
                                                if (option.equals("0")) {
                                                        System.out.println("Koniec aukčného dňa!");
                                                        
                                                        // ?? Print stats
                                                        System.out.println("Statistiky dňa:");
                                                        // Todo vypisat statistiky dna !
                                                        System.exit(0);
                                                }
                                                
                                                scanner_while.close();
                                                
                                        } while (!option.equals("5"));
                                        
                                        // ?? Start timer
                                        // Timer();
                                        
                                        // // ?? Start Auction
                                        // Active = true;
                                        // Auctions++;
                                        
                                        // for (int i = 0; i < Garages.size(); i++) {
                                                //         System.out.println("Nazov skladu je " + Garages.get(i).getName());
                                                //         System.out.println("Minimalna cena skladu je " + Garages.get(i).getMinimumPrice());
                                                //         System.out.println("Predchadzajúci majiteľ skladu je " + Garages.get(i).getOldOwner());
                                                //         System.out.println("Majiteľ skladu je " + Garages.get(i).getOwner());
                                                //         System.out.println("Sklad je zamknutý" + Garages.get(i).getLocked());
                                                //         System.out.println("Popis skladu" + Garages.get(i).getDescription());
                                                //         System.out.println("Rozmery skladu su " + Garages.get(i).getSize());
                                                //         System.out.println("Sklad je predaný" + Garages.get(i).getSold());
                                                
                                                //         // System.out.println("Minimalna cena skladu je " + Garages.get(i).getPrice());
                                                // }
                                                
                                        }
                                }
                                