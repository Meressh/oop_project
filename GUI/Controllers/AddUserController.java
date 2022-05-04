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

    //Create User
    public void createUser(ActionEvent event) {
        // Try catch exception
        try {
            // Add VIP User
            //!!prerobit exception na vlastne 
            if (temp_user_name.getText().isEmpty()) {
                throw new Exception("Please enter a valid Name");
                // userAddError.setText();
            }
            
            if (temp_user_id.getText().isEmpty()) {
                throw new Exception("Please enter a valid ID");
            }
            
            if (!temp_user_id.getText().isEmpty() && !temp_user_name.getText().isEmpty()) {
                // Check for 
                Boolean boolean1 = true;

                for (int i = 0; i < Config.Users.size(); i++) {

                    if(Config.Users.get(i).getID().equals(temp_user_id.getText()) ){
                        userAddError.setText("ID of user already exists");
                        boolean1 = false;
                    }

                }
                if(boolean1){
                    Config.createUser(temp_user_id.getText(), temp_user_name.getText(), user_psc.getText(),
                            user_address.getText(), user_region.getText(), user_state.getText());

                    userAddError.setText("User created");
                }

            }
        }
        catch (Exception e) {
            userAddError.setText(e.getMessage());
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
