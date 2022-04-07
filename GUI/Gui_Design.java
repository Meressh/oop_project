package GUI;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;

public class Gui_Design extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        // primaryStage.setScene(new Scene(new Group(new Text(20, 20, "Hello World"))));
        primaryStage.show();
    }

}