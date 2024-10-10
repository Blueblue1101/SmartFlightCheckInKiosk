package group16.smartflightcheckinkiosk.Controller;
import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.Data.Passager.service.OrderInfo;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Ziding Lin, Ruoqi Zhang
 * @version jdk15.0.2
 */
public class BoardingpassController {
    @FXML
    private Label Passenger;
    @FXML
    private Label Staff;
    @FXML
    private Button label_ok;
    @FXML
    private Button label_help;
    /**
     * calculate tickets number
     */
    public static int ticket_index=1;
    /**
     * calculate tags number
     */
    public static int tag_index=1;
    /**
     * junit test parameter
     */
    public int test=0;
    /**
     * name of passenger
     */
    public String name;
    /**
     * Help button event
     * @throws Exception Click no response
     */
    @FXML
    void onHelpClick() throws Exception {
        System.out.println("you choose prev");
        Jumpto jumpto = new Jumpto();
        jumpto.set("BoardingpassCheck.fxml", "MainMenu");
        Stage stage = new Stage();System.out.println("Stage stage = new Stage();");
        Stage stage_old = (Stage) label_help.getScene().getWindow();
        stage_old.close();
        jumpto.start(stage);
    }

    /**
     * OK button event
     * @throws Exception click no response
     */
    @FXML
    void onOKClick() throws Exception{
        Jumpto jumpto1 = new Jumpto();
        jumpto1.set("BoardingpassBoardingpass.fxml", "Boarding pass");
        Stage stage1 = new Stage();
        jumpto1.start(stage1);

        //transport the parameter
        OrderInfo orderInfo = (OrderInfo) StageManager.CONTROLLER.get("myLoginUserInfo");
        name = orderInfo.orders.get(orderInfo.orderIndex).getSurname();
        //read flight csv
        String csvFile = "csv/Luggage.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] luggage= new String[8];
        int total_tag_luggage=0;//carry-on luggage
        int total_ticket_luggage=0;//check-in luggage
        //match the flight
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                luggage = line.split(cvsSplitBy);
                // check the name
                if (luggage[0].equals(name)&&luggage[7].equals("1")) {
                    total_ticket_luggage++;
                }
                if (luggage[0].equals(name)&&luggage[7].equals("2")) {
                    total_tag_luggage++;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<total_tag_luggage;i++) {
            Jumpto jumpto2 = new Jumpto();
            jumpto2.set("BoardingpassTag.fxml", "Carry-on Luggage");
            Stage stage2 = new Stage();
            jumpto2.start(stage2);
            tag_index++;
        }
        for(int j=0;j<total_ticket_luggage;j++) {
            Jumpto jumpto3 = new Jumpto();
            jumpto3.set("BoardingpassTicket.fxml", "Check-in Luggage");
            Stage stage3 = new Stage();
            jumpto3.start(stage3);
            ticket_index++;
            test=1;
        }
        System.out.println("ci:"+ticket_index+total_ticket_luggage+"co:"+tag_index+total_tag_luggage);
        Stage stage4 = (Stage) label_ok.getScene().getWindow();
        stage4.close();
    }

}
