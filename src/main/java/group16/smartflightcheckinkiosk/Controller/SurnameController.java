package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * surname login
 * @author  Ruibo Gang, Zhishang Yu
 * @version jdk15.0.2
 */
public class SurnameController {

    @FXML
    private Label confirm3;

    @FXML
    private Label id_num;

    @FXML
    private TextField id_numField;

    @FXML
    private Button ok;

    @FXML
    private Button back;

    @FXML
    private Label surname;

    @FXML
    private TextField surnameField;

    @FXML
    private AnchorPane toSurnamePage;
    /**
     * passenger information
     */
    private static final OrderInfo orderInfo = new OrderInfo();

    /**
     * ok button event
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void ok(ActionEvent event) throws Exception{
        String Surname = surnameField.getText();
        String IDnumber = id_numField.getText();
        System.out.println("Surname: " + Surname);
        System.out.println("ID Number: " + IDnumber);
        Jumpto jumpto = new Jumpto();
        //log in false
        if((orderInfo.orderIndex = orderInfo.checkUsernameAndID(Surname, IDnumber)) < 0){
            System.out.println("Log in Failed");
            id_numField.setText("");
            jumpto.set("Warning.fxml", "WARNING");
            Stage stage = new Stage();
            jumpto.start(stage);
            return;
        }


        jumpto.set("MainMenu.fxml", "Hello");
        Stage stage = new Stage();

        //Close this window
        Stage stage_old = (Stage) toSurnamePage.getScene().getWindow();
        stage_old.close();
        //Close login window
        StageManager.STAGE.get("login").close();
        StageManager.STAGE.remove("login");

        //close login page
        if(StageManager.STAGE.get("loginPage") != null){
            StageManager.STAGE.get("loginPage").close();
            StageManager.STAGE.remove("loginPage");
        }

        //register the login information
        StageManager.CONTROLLER.put("myLoginUserInfo", orderInfo);

        //Open next window
        jumpto.start(stage);
    }

    /**
     * back button event
     */
    @FXML
    void back(){
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();

    }

}

