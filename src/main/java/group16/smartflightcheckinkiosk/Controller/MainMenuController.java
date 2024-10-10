package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * the main menu
 * @author  Xiaoyi Liang
 * @version jdk15.0.2
 */
public class MainMenuController  implements Initializable{



    @FXML
    private VBox rootLayout;

    /**
     * quit the main menu
     * @param event click on
     * @throws Exception
     */
    @FXML
    void quit(ActionEvent event)throws Exception{
        Jumpto jumpto = new Jumpto();
        jumpto.set("ChooseLogin.fxml", "Login");
        Stage stage = new Stage();
        Stage stage_old = (Stage) rootLayout.getScene().getWindow();
        stage_old.close();
        jumpto.start(stage);
    }

    /**
     * meal choose
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void gotoMealChoose(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("MealChoose.fxml", "Meal Choose");
        Stage stage = new Stage();
        jumpto.start(stage);
    }

    /**
     * seat choose
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void gotoSeatChoose(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("SeatChoose.fxml", "Seat Choose");
        Stage stage = new Stage();
        jumpto.start(stage);
    }

    /**
     * booked flight
     * @param event click on
     * @throws Exception click on response
     */
    @FXML
    void gotoBookedFlight(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("BookedFlight.fxml", "Booked Flight");
        Stage stage = new Stage();
        jumpto.start(stage);
    }

    /**
     * check budget
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void gotoBudget(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("Budget.fxml", "Budget");
        Stage stage = new Stage();
        jumpto.start(stage);
    }

    /**
     * Boardingpass check
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    void gotoBoardingpassCheck(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("BoardingpassCheck.fxml", "boardingpass-check");
        Stage stage = new Stage();
        jumpto.start(stage);
    }
    ///////主页
    /**
     * user information
     */
        public  String[] userInfo;
        @FXML
        private Label BookingFlight;
        @FXML
        private Label BookingNumber;
        @FXML
        private Label Surname;
        @FXML
        private Label DepatureTime;
        @FXML
        private Label ArrivingTime;
        @FXML
        private Label DepatureCity;
        @FXML
        private Label ArrivingCity;

    /**
     * change the text
     */
        public void ChangeText(){
            BookingFlight.setText(userInfo[0]);
            BookingNumber.setText(userInfo[1]);
            Surname.setText(userInfo[2]);
            DepatureTime.setText(userInfo[3]);
            ArrivingTime.setText(userInfo[4]);
            DepatureCity.setText(userInfo[5]);
            ArrivingCity.setText(userInfo[6]);
        }



        @Override
        public void initialize(URL arg0, ResourceBundle arg1) {

            userInfo = new String[7];
            OrderInfo orderInfo = (OrderInfo) StageManager.CONTROLLER.get("myLoginUserInfo");
            if(orderInfo == null){
                System.out.println("The illegal log in");
                return;
            }
            userInfo[0] = orderInfo.orders.get(orderInfo.orderIndex).getBookingFlight();
            userInfo[1] = orderInfo.orders.get(orderInfo.orderIndex).getBookingNumber();
            userInfo[2] = orderInfo.orders.get(orderInfo.orderIndex).getSurname();
            userInfo[3] = orderInfo.orders.get(orderInfo.orderIndex).getDepatureTime();
            userInfo[4] = orderInfo.orders.get(orderInfo.orderIndex).getArrivingTime();
            userInfo[5] = orderInfo.orders.get(orderInfo.orderIndex).getDepatureCity();
            userInfo[6] = orderInfo.orders.get(orderInfo.orderIndex).getArrivingCity();
            ChangeText();
        }



}
