package group16.smartflightcheckinkiosk;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

// This class is used to jump to other page.
public class Jumpto extends Application {
    String fxml, title;
    public void set(String fxml, String title) {
        this.fxml = fxml;
        this.title = title;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(getClass().getResource(fxml));
        Scene scene = new Scene(root.load());
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}
