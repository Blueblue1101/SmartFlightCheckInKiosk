package group16.smartflightcheckinkiosk.Controller;
import group16.smartflightcheckinkiosk.Data.Passager.service.Order;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ziding Lin, Ruoqi Zhang
 * @version jdk15.0.2
 */
public class BoardingpassCheckController implements Initializable {
    @FXML
    private Text Surname;
    @FXML
    private Text idNumber;
    @FXML
    private Text BookingNumber;
    @FXML
    private Text FlightNumber;
    @FXML
    private Text Timetable;
    @FXML
    private Text meal;
    @FXML
    private Text seat;

    @FXML
    private Button back;
    @FXML
    private Button next;
    private OrderInfo orderInfo;
    /**
     * junit test parameter
     */
    public int test=0;
    /**
     * name of passenger
     */
    public String name;

    /**
     * next button event
     * @throws Exception
     */
    @FXML
    void onNextClick() throws Exception {

        System.out.println("next button pressed");
        Jumpto jumpto = new Jumpto();
        jumpto.set("Boardingpass.fxml", "boaringpass-notification");
        Stage stage = new Stage();
        jumpto.start(stage);
        Stage stage_old = (Stage)next.getScene().getWindow();
        stage_old.close();
        jumpto.start(stage);
    }

    /**
     * initialize the information
     * @param arg0 URL
     * @param arg1 ResourceBundle
     */
     public void initialize(URL arg0, ResourceBundle arg1){
        //transport the parameter
        OrderInfo orderInfo = (OrderInfo) StageManager.CONTROLLER.get("myLoginUserInfo");
        if (orderInfo == null) {
            System.out.println("非法登录!!!");
            return;
        }
        this.orderInfo = orderInfo;
        //user information
        Order order = orderInfo.orders.get(orderInfo.orderIndex);

        String name = orderInfo.orders.get(orderInfo.orderIndex).getSurname();
        //read passenger csv
        String csvFile = "csv/data.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] passenger= new String[16];
        //match the information
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                passenger = line.split(cvsSplitBy);
                // check the name
                if (passenger[2].equals(name)) {
                    break;
                }
            }
            if(passenger[2].equals(name)){
                Surname.setText(name);
                seat.setText(passenger[6]);
                meal.setText(passenger[3]);
                idNumber.setText(passenger[1]);
                BookingNumber.setText(passenger[0]);
                FlightNumber.setText(passenger[11]);
                Timetable.setText(passenger[14]+" to "+passenger[15]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    //check if choose the seat
        System.out.println(order.getSeat()+", your seat");
        if(order.getSeat().equals("-")){
            next.setDisable(true);
            seat.setText("please shoose seat first");
            System.out.println(order.getSeat()+", choose seat first");
        }
        double total_pay1=order.getMealFee() + order.getSeatFee();
         String pay_str = String.format("%.2f", total_pay1);
         double total_pay = Double.parseDouble(pay_str);
//        BigDecimal b=new BigDecimal(total_pay1);
//        double total_pay=b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(total_pay);
        if((order.getPayed() != 1)&&total_pay!=0){
            next.setDisable(true);next.setPrefWidth(150);
            next.setText("please pay first");
            System.out.println("pay first");
        }
    }


    /**
     * prev button event
     * @throws Exception click no response
     */
    @FXML
    public void onPrevClick() throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("MainMenu.fxml", "MainMenu");
        Stage stage = new Stage();
        Stage stage_old = (Stage) back.getScene().getWindow();
        stage_old.close();
        jumpto.start(stage);
    }
}