package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * enter flight
 * @author Ziding Lin, Liya Zhong
 * @version jdk15.0.2
 */
public class EnterFlightController {
    @FXML
    private VBox EnterFlight;
    @FXML
    private TextField FlightnumField;
    /**
     * flight number
     */
    public  String flightNum;
    /**
     * junit test parameter
     */
    public  int test=0;
    /**
     * flight number use for transporting the parameter
     */
    public static String flight_num;
    /**
     * back button event
     * @throws Exception click no response
     */

    @FXML
    void gotoStaffLogin()throws Exception{
        Jumpto jumpto = new Jumpto();
        jumpto.set("StaffLogin.fxml", "Login");
        Stage stage = new Stage();
        Stage stage_old = (Stage) EnterFlight.getScene().getWindow();
       stage_old.close();
       jumpto.start(stage);
    }

    /**
     * next button event
     * @throws Exception click no response
     */
    @FXML
    void gotoCheckFlight() throws Exception {
        flightNum=FlightnumField.getText();
        flight_num=flightNum;
        //read passenger csv
        String csvFile = "csv/data.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] flight= new String[16];
        //match the information
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                flight = line.split(cvsSplitBy);
                // check the name
                if (flight[11].equals(flightNum)) {
                    break;
                }
            }
            //input valid flight number
            if(flight[11].equals(flightNum)){
                Jumpto jumpto = new Jumpto();
                jumpto.set("CheckFlight.fxml", "Check Flight");
                Stage stage = new Stage();
                Stage stage_old = (Stage) EnterFlight.getScene().getWindow();
                stage_old.close();
                jumpto.start(stage);
                test=1;
            }
            //input invalid flight number then show a warning window
            else{
                System.out.println("This query is invalid.");
                FlightnumField.setText("");
                Jumpto jumpto = new Jumpto();
                jumpto.set("Warning.fxml", "WARNING");
                Stage stage = new Stage();
                jumpto.start(stage);
                return;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}