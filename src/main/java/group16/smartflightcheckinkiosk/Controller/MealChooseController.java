package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.Data.Passager.util.PlaneUtil;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
/**
 * choose meal
 * @author  Xiaoyi Liang, Zhishang Yu
 * @version jdk15.0.2
 */
public class MealChooseController implements Initializable {
    /**
     * user information
     */
    public static String[] userInfo;
    @FXML
    private Label LabelMeal1;
    @FXML
    private Label LabelMeal2;
    @FXML
    private Label LabelMeal3;
    @FXML
    private TabPane mealpane;

    /**
     * meal choose
     * @param event click button
     */
    public void MealChooseController(ActionEvent event) {
        // TODO Auto-generated constructor stub
        Button button = (Button) event.getSource();
        String mealPage = (String) button.getId();
        String meal = null;

        switch (mealPage){
            case "OrderMeal1":
                meal = LabelMeal1.getText();
                break;
            case "OrderMeal2":
                meal = LabelMeal2.getText();
                break;
            case "OrderMeal3":
                meal = LabelMeal3.getText();
                break;
        }

        //user information
        OrderInfo orderInfo = (OrderInfo) StageManager.CONTROLLER.get("myLoginUserInfo");
        if (orderInfo == null) System.out.println("The illegal log in!!!");


        //get meal and price
        String mealName = meal.substring(0, meal.indexOf("$"));
        Double mealPrice = Double.parseDouble(meal.substring(meal.indexOf("$") + 1, meal.length()));

        orderInfo.orders.get(orderInfo.orderIndex).setMeal(mealName);
        orderInfo.orders.get(orderInfo.orderIndex).setMealFee(mealPrice);
        //set right path
        PlaneUtil.setOrdersToCsv(orderInfo.orders , "csv/data.csv", "UTF-8");

        System.out.println("Got it！");
    }


    /**
     * initialize the information
     * @param arg0 URL
     * @param arg1 ResourceBundle
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        setMeal(1, "Tomato", 12.0);
        setMeal(2, "Meat", 3.0);
        setMeal(3, "Cucunumber", 55.0);
    }

    /**
     * set meal
     * @param type type of meal
     * @param name meal name
     * @param price meal price
     */
    @FXML
    public void setMeal(int type,String name, double price){
        switch(type){
            case 1:
                LabelMeal1.setText(name+"$"+price);
            case 2:
                LabelMeal2.setText(name+"$"+price);
            case 3:
                LabelMeal3.setText(name+"$"+price);
        }
    }

    /**
     * button click
     * @param event click on
     */
    @FXML
    public void orderButtonClicked(ActionEvent event) throws Exception {
        MealChooseController(event);
        gotoSuccess(event);
    }

    /**
     * go to main menu
     * @param event click on
     * @throws Exception click no response
     */
    @FXML
    public void gotoSuccess(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("Success.fxml", "Success!");
        Stage stage = new Stage();
        jumpto.start(stage);
    }



}
