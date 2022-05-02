package GUI.Controllers;

import GUI.Config.Config;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AuctionControllerEnds implements Initializable {
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

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        for (int i = 0; i < Config.Garages.size(); i++) {
            garageList.getItems().add(Config.Garages.get(i).getName());
        }

        for (int i = 0; i < Config.SpecialGarages.size(); i++) {
            specialgaragesList.getItems().add(Config.SpecialGarages.get(i).getName());
        }
    }
    // Switch to caller dashboard
    public void switchToCallerDashboard() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/caller_dashboard.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage window = (Stage) switchToDashboard.getScene().getWindow();
        window.setScene(new Scene(root));
    }

}
