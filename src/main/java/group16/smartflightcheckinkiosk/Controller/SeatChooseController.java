package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Data.Passager.util.PlaneUtil;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * choose seat
 * @author  Xiaoyi Liang, Zhishang Yu
 * @version jdk15.0.2
 */
public class SeatChooseController implements Initializable {
    /**
     * user information
     */
    public static String[] userInfo;
    @FXML
    private Button A1;
    @FXML
    private Button A2;
    @FXML
    private Button A3;
    @FXML
    private Button A4;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B3;
    @FXML
    private Button B4;
    @FXML
    private Button C1;
    @FXML
    private Button C2;
    @FXML
    private Button C3;
    @FXML
    private Button C4;
    @FXML
    private Button D1;
    @FXML
    private Button D2;
    @FXML
    private Button D3;
    @FXML
    private Button D4;
    /**
     * button
     */
    static  final Map<String, Button> buttonMap = new HashMap<>();


    /**
     * choose seat
     * @param event click button
     */
    public void SeatChooseController(ActionEvent event) {
        // TODO Auto-generated constructor stub
        Button button = (Button) event.getSource();
        String type = (String) button.getId();

        String seat = getText(type).getText();
        if (seat == null) System.out.println("no seat here");

        //user information
        OrderInfo orderInfo = (OrderInfo) StageManager.CONTROLLER.get("myLoginUserInfo");
        if (orderInfo == null) System.out.println("invaid!!!");

        //choose seat
        String seatName = seat.substring(0, seat.indexOf("$"));
        Double seatPrice = Double.parseDouble(seat.substring(seat.indexOf("$") + 1, seat.length()));
        orderInfo.orders.get(orderInfo.orderIndex).setSeat(seatName);
        orderInfo.orders.get(orderInfo.orderIndex).setSeatFee(seatPrice);
        //set right path
        PlaneUtil.setOrdersToCsv(orderInfo.orders, "csv/data.csv", "UTF-8");
        System.out.println("got it!");
    }

    /**
     * initialize the information
     * @param arg0 URL
     * @param arg1 ResourceBundle
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
//         TODO Auto-generated method stub

        buttonMap.put("A1", A1);
        buttonMap.put("A2", A2);
        buttonMap.put("A3", A3);
        buttonMap.put("B1", B1);
        buttonMap.put("B2", B2);
        buttonMap.put("B3", B3);
        buttonMap.put("C1", C1);
        buttonMap.put("C2", C2);
        buttonMap.put("C3", C3);
        buttonMap.put("D1", D1);
        buttonMap.put("D2", D2);
        buttonMap.put("D3", D3);
        buttonMap.put("A4", A4);
        buttonMap.put("B4", B4);
        buttonMap.put("C4", C4);
        buttonMap.put("D4", D4);

        setSeat("A1",  10.12);
        setSeat("A2",  102.2);
        setSeat("A3",  10234.224);
        setSeat("B1",  5023.666);
        setSeat("B2",  120.2);
        setSeat("B3",  23.1);
        setSeat("C1",  1340.12);
        setSeat("C2",  102.22);
        setSeat("C3",  10234.324);
        setSeat("D1",  50223.666);
        setSeat("D2",  120.223);
        setSeat("D3",  2243.2431);
        setSeat("A4",  0);
        setSeat("B4",  0);
        setSeat("C4",  0);
        setSeat("D4",  0);

    }

    /**
     * set seat
     * @param type type of seat
     * @param price price of seat
     */
    public void setSeat(String type, double price){
        buttonMap.get(type).setText(type + "$" + String.valueOf(price) );
    }

    Button getText(String type){
        return buttonMap.get(type);
    }

    /**
     * button click
     * @param event click on
     */
    @FXML
public void ButtonClicked(ActionEvent event) throws Exception {
        System.out.println("213213");
    SeatChooseController(event);
        gotoSuccess(event);
}
    @FXML
    public void gotoSuccess(ActionEvent event) throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("Success.fxml", "Success!");
        Stage stage = new Stage();
        jumpto.start(stage);
    }






}