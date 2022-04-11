package GUI.Controllers;

import Users.User;
import Users.VIPUser;

import java.util.Scanner;
import java.util.Timer;
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

public class Controller{
        
       
        
        
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
        
        
}