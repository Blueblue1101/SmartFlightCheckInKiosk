package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * choose login ways
 * @author Ruoqi Zhang
 * @version jdk15.0.2
 */
public class LoginController {
    /**
     * the label confirm
     */
    public Label confirm;
    @FXML
    private Button booknum_button;
    @FXML
    private Button iddoc_button;
    @FXML
    private Button surname_button;
    @FXML
    private Button back;

    /**
     * choose book number
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void toBookNumPage(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("BookNum.fxml", "Booking Number");
        Stage stage = new Stage();
        StageManager.STAGE.put("login", stage);
        jumpto.start(stage);
    }
    /**
     * choose surname login
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void toSurnamePage(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("Surname.fxml", "Surname & ID Number");
        Stage stage = new Stage();
        StageManager.STAGE.put("login", stage);
        jumpto.start(stage);
    }
    /**
     * choose ID document login
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void toIDdocPage(ActionEvent event) throws Exception{
        Jumpto jumpto = new Jumpto();
        jumpto.set("IDdoc.fxml", "ID Documnet");
        Stage stage = new Stage();
        StageManager.STAGE.put("login", stage);
        jumpto.start(stage);
    }

    /**
     * back button event
     * @throws Exception click no response
     */
    @FXML
    void back()throws Exception{
        Jumpto jumpto = new Jumpto();
        jumpto.set("ChooseLogin.fxml", "Choose Login");
        Stage stage = new Stage();

        jumpto.start(stage);
        Stage stage_old = (Stage) back.getScene().getWindow();
        stage_old.close();
    }

}
