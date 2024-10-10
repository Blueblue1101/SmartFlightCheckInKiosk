package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * ID document login
 * @author  Ruibo Gang, Zhishang Yu
 * @version jdk15.0.2
 */
public class IDdocController {

    @FXML
    private Label confirm4;

    @FXML
    private CheckBox id_docField;

    @FXML
    private Button ok;

    @FXML
    private Button back;

    @FXML
    private AnchorPane toIDdocPage;
    /**
     * get passenger information
     */
    private static final OrderInfo orderInfo = new OrderInfo();

    /**
     * ok button event
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void ok(ActionEvent event) throws Exception{
        Boolean ID_doc = id_docField.isSelected();
        Jumpto jumpto = new Jumpto();
        Stage stage = new Stage();
        //log in false
        if((orderInfo.orderIndex = orderInfo.checkWithFile()) < 0||ID_doc==false){
            System.out.println("Log in Failed");
            jumpto.set("Warning.fxml", "WARNING");
            jumpto.start(stage);
            return;
        }

        jumpto.set("MainMenu.fxml", "Hello");


        //Close this window
        Stage stage_old = (Stage) toIDdocPage.getScene().getWindow();
        stage_old.close();
        //Close login window
        System.out.println(StageManager.STAGE);
        StageManager.STAGE.get("login").close();
        StageManager.STAGE.remove("login");
        //Open next window

        //close login page
        if(StageManager.STAGE.get("loginPage") != null){
            StageManager.STAGE.get("loginPage").close();
            StageManager.STAGE.remove("loginPage");
        }

        //register the login information
        StageManager.CONTROLLER.put("myLoginUserInfo", orderInfo);

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
