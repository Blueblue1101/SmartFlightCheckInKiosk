package group16.smartflightcheckinkiosk.Controller;
import group16.smartflightcheckinkiosk.Jumpto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * check flight
 * @author Ziding Lin, Liya Zhong
 * @version jdk15.0.2
 */

public class CheckFlightController implements Initializable {

    @FXML
    private VBox CheckFlight;
    @FXML
    private Text FlightNum;
    @FXML
    private Text Time;
    @FXML
    private Text Startpoint;
    @FXML
    private Text Destination;
    /**
     * flight number
     */
    public String flightNum;
    /**
     * junit test parameter
     */
    public int test=0;

    /**
     * back button event
     * @throws Exception click no response
     */
    @FXML
    void gotoEnterFlight()throws Exception{
        Jumpto jumpto = new Jumpto();
        jumpto.set("EnterFlight.fxml", "Back-end System");
        Stage stage = new Stage();
        Stage stage_old = (Stage) CheckFlight.getScene().getWindow();
        stage_old.close();
        jumpto.start(stage);
    }

    /**
     * initialize the information
     * @param arg0 URL
     * @param arg1 ResourceBundle
     */
    public void initialize(URL arg0, ResourceBundle arg1) {
        flightNum = EnterFlightController.flight_num;

        //read passenger csv
        String csvFile = "csv/data.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] passenger = new String[16];
        //match the information
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                passenger = line.split(cvsSplitBy);
                // check the name
                if (passenger[11].equals(flightNum)) {
                    break;
                }
            }
            if (passenger[11].equals(flightNum)) {
                FlightNum.setText(flightNum);
                Time.setText(passenger[14] + " to " + passenger[15]);
                Startpoint.setText(passenger[12]);
                Destination.setText(passenger[13]);
                test = 1;
            } else {
                System.out.println("not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * next button event
     * @throws Exception click no response
     */
    @FXML
    void gotoFlightList() throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("FlightList.fxml", "Back-end System");
        Stage stage = new Stage();
        Stage stage_old = (Stage) CheckFlight.getScene().getWindow();
        stage_old.close();
        jumpto.start(stage);
    }

}