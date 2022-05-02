package GUI.Controllers;

import GUI.Config.Config;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class AddVipUserController {
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
    @FXML
    private Button loginCaller;
    
    //Create VIP User
    public void createVIPUser(ActionEvent event) {
        try {
            if (temp_userVIP_name.getText().isEmpty()) {
                userVIPAddError.setText("Please enter a valid Name");
            }
            
            if (temp_userVIP_id.getText().isEmpty()) {
                userVIPAddError.setText("Please enter a valid ID");
            }
            
            if (!temp_userVIP_id.getText().isEmpty() && !temp_userVIP_name.getText().isEmpty()) {
                Config.createVIPUser(temp_userVIP_id.getText(), temp_userVIP_name.getText(), vip_psc.getText(), vip_address.getText(), vip_region.getText(), vip_state.getText());
                
                userVIPAddError.setText("VIP User created");
            }
        }
        catch (Exception e) {
            System.out.println(e);
            userVIPAddError.setText("Some Error was made");
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
