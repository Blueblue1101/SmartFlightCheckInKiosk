package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.Data.Passager.service.Order;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.Data.Passager.util.PlaneUtil;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.List;

/**
 * book number login
 * @author Zhishang Yu, Xiaoyi Liang
 * @version jdk15.0.2
 */
public class BooknumController {

    @FXML
    private TextField booknumField;

    @FXML
    private Label confirm2;

    @FXML
    private Button ok;

    @FXML
    private Button back;

    @FXML
    private AnchorPane toBookNumPage;
    /**
     * get passenger information
     */
    private static final OrderInfo orderInfo = new OrderInfo();


    /**
     * ok button event
     * @param event click event
     * @throws Exception click no response
     */
    @FXML
    void ok(ActionEvent event) throws Exception{
        String BookingNumber = booknumField.getText();
        System.out.println("Booking Number: " + BookingNumber);
        Jumpto jumpto = new Jumpto();
        //log in false
        if((orderInfo.orderIndex = orderInfo.checkBookingNumber(BookingNumber)) < 0){
            System.out.println("Log in Failed");
            booknumField.setText("");
            jumpto.set("Warning.fxml", "WARNING");
            Stage stage = new Stage();
            jumpto.start(stage);
            return;
        }


        List<Order> orders = PlaneUtil.getOrdersFromCsv("csv/data.csv", "UTF-8");

        jumpto.set("MainMenu.fxml", "Hello");
        Stage stage = new Stage();

        //Close this window
        Stage stage_old = (Stage) toBookNumPage.getScene().getWindow();
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
    void back() {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }


}
