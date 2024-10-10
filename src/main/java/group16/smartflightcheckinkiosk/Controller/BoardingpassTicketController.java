package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ziding Lin, Ruoqi Zhang
 * @version jdk15.0.2
 */

public class BoardingpassTicketController implements Initializable {
    @FXML
    private Text Surname;
    @FXML
    private Text FlightNumber;
    @FXML
    private Text Tag;
    @FXML
    private Text CounterNumber;
    /**
     * name of passenger
     */
    public String name;
    /**
     * junit test parameter
     */
    public int test=0;

    /**
     * initialize the information
     * @param arg0 URL
     * @param arg1 ResourceBundle
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        //transport the parameter
        OrderInfo orderInfo = (OrderInfo) StageManager.CONTROLLER.get("myLoginUserInfo");
        name = orderInfo.orders.get(orderInfo.orderIndex).getSurname();
        //String name= SurnameController.global_name;
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
                FlightNumber.setText(passenger[11]);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //read flight csv
        String csvFile1 = "csv/luggage.csv";
        String[] luggage= new String[8];
        //match the flight
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile1))) {
            System.out.println(name);

            while ((line = br.readLine()) != null) {

                // use comma as separator
                luggage = line.split(cvsSplitBy);
                // check the name
                if (luggage[0].equals(name)&&Integer.parseInt(luggage[5])==BoardingpassController.ticket_index) {
                    break;
                }
            }
            if (luggage[0].equals(name)&&Integer.parseInt(luggage[5])==BoardingpassController.ticket_index) {
                Tag.setText(luggage[3]);
                CounterNumber.setText(luggage[4]);
                test=1;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}