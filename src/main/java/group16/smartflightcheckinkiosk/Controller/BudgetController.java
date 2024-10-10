package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Data.Passager.service.Order;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.Data.Passager.util.PlaneUtil;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * check budget
 * @author Zhishang Yu, Xiaoyi Liang
 * @version jdk15.0.2
 */
public class BudgetController implements Initializable {
    @FXML
    private Text meal;
    @FXML
    private Text meal_pay;
    @FXML
    private Text seat;
    @FXML
    private Text seat_pay;
    //    @FXML
//    private Text luggage_pay;
    @FXML
    private Text total_pay;
    @FXML
    private TextField cardnumField;
    @FXML
    private Text not_balance;
    @FXML
    private Text not_correct;
    @FXML
    private Text success;

    @FXML
    private Button back;

    @FXML
    private Button ok;
    /**
     * get passenger information
     */
    private OrderInfo orderInfo;

    /**
     * ok button event
     * @param event click event
     * @throws Exception click no response
     */
    @FXML
    void ok(ActionEvent event) throws Exception{

        String cardNum = cardnumField.getText();
        if(orderInfo == null){
            System.out.println("Not initialized");
            return;
        }
        Order order = orderInfo.orders.get(orderInfo.orderIndex);

        if(cardNum == null || !cardNum.equals(order.getCreditNumber())){
            clear();
            not_correct.setText("sorry, your car number is not correct");//if card number is wrong
        }
        else if(order.getBalance() < order.getMealFee() + order.getSeatFee()){
            clear();
            not_balance.setText("sorry, your balance is not enough");//if balance is not enough
        }
        else if(order.getPayed() == 1){
            System.out.println("You have payed for it");
        }
        else{
            //pay
            order.setBalance(order.getBalance() - (order.getMealFee() + order.getSeatFee()));
            order.setPayed((byte)1);
            //page
            clear();
            cardnumField.setText("");
            success.setText("successfully paid!O(∩_∩)O");
            System.out.println("payed successfully!!");
            ok.setDisable(true);
            ok.setText("paid");
            //write csv
            PlaneUtil.setOrdersToCsv(orderInfo.orders , "csv/data.csv", "UTF-8");
        }
    }

    /**
     * clear the text
     */
    private void clear(){
        not_balance.setText("");
        not_correct.setText("");
        success.setText("");
    }

    /**
     * back button event
     */
    @FXML
    void back() {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.close();
    }

    /**
     * initialize the information
     * @param url URL
     * @param resourceBundle ResourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //user information
        OrderInfo orderInfo = (OrderInfo) StageManager.CONTROLLER.get("myLoginUserInfo");
        if (orderInfo == null) {
            System.out.println("The illegal log in!!!");
            return;
        }

        this.orderInfo = orderInfo;
        //user information
        Order order = orderInfo.orders.get(orderInfo.orderIndex);
        //meal
        meal.setText(order.getMeal());
        meal_pay.setText(String.valueOf(order.getMealFee()));
        //seat
        seat.setText(order.getSeat());
        seat_pay.setText(String.valueOf(order.getSeatFee()));
        //price
        total_pay.setText(String.valueOf(order.getMealFee() + order.getSeatFee()));

        if(order.getPayed() == 1){
            ok.setDisable(true);
            ok.setText("paid");
        }
    }
}
