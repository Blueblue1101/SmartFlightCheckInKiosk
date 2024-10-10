package group16.smartflightcheckinkiosk;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;//import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class ChooseLogin extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ChooseLogin.fxml"));
        primaryStage.setScene(new Scene(root,600,400));
        primaryStage.setTitle("Log In");

        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }
}