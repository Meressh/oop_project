package GUI.Controllers;

import Users.User;
import Users.VIPUser;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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

public class AuctionController implements Initializable {
    // List View data
    @FXML
    public ListView<String> garageList;
    @FXML
    public ListView<String> specialgaragesList;

    @FXML
    private TextField name_of_garage;
    @FXML
    private TextField id_of_user;
    @FXML
    private TextField price;
    @FXML
    private Button Bid;
    @FXML
    private TextField bidError;

    @FXML
    private TextField bidInfo;
    @FXML
    private TextField secondsShow;

    @FXML
    private Button switchToDashboard;
    @FXML
    private Button closeAuction;

    Integer second = 35;
    Timer timer;

    public void bid(ActionEvent event) {
        try {
            // Add VIP User
            if (name_of_garage.getText().isEmpty()) {
                bidError.setText("Please enter a valid Name of garage");
            }

            if (id_of_user.getText().isEmpty()) {
                bidError.setText("Please enter a valid ID of user");
            }

            if (price.getText().isEmpty() || !Config.isNumeric(price.getText())) {
                bidError.setText("Please enter a valid price");
            }

            if (!name_of_garage.getText().isEmpty() && !id_of_user.getText().isEmpty() && !price.getText().isEmpty() && Config.isNumeric(price.getText())) {

                Boolean check = Config.addBid(name_of_garage.getText(), id_of_user.getText(), Integer.parseInt(price.getText()));

                if (check) {
                    bidError.setText("Bid added successfully");
                }
                else {
                    bidError.setText("Bid not added");
                }

            }
        }
        catch (Exception e) {
            bidError.setText("Some Error was made");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        bidInfo.setText("Auction is Active");

        for (int i = 0; i < Config.Garages.size(); i++) {
            garageList.getItems().add(Config.Garages.get(i).getName());
        }

        for (int i = 0; i < Config.SpecialGarages.size(); i++) {
            specialgaragesList.getItems().add(Config.SpecialGarages.get(i).getName());
        }

        timer = new Timer();
        timer.schedule(new printSeconds(), 0, 1000);

        // new java.util.Timer().schedule(
        //         new java.util.TimerTask() {
        //             @Override
        //             public void run() {
        //                 System.out.println("Marek");
        //             }
        //         },
        //         35000);
    }
    
    class printSeconds extends TimerTask {
        public void run() {
            //Print seconds
            System.out.println(second);
            secondsShow.setText(Integer.toString(second));
            
            second--;

            System.out.println(Config.Active);

            //Stop timer
            if(second == 0) {

                try {
                    CloseAuction();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                

                timer.cancel();
            }

        }
    }
    
    public void switchToCallerDashboard() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/caller_dashboard.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) switchToDashboard.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    public void CloseAuction() throws Exception {
        Config.Active = false;
        bidInfo.setText("Auction was closed");
        timer.cancel();
        

        Config.Garages.clear();
        Config.SpecialGarages.clear();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/auction_closed.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) closeAuction.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
