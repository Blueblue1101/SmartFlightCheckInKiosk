package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Ziding Lin, Liya Zhong
 * @version jdk15.0.2
 */
public class FlightListController implements Initializable {

    @FXML
    private VBox FlightList;
    @FXML
    private Button b7;
    @FXML
    private Text Namefield1, Namefield2, Namefield3, Namefield4;
    @FXML
    private Text IDnumber1, IDnumber2, IDnumber3, IDnumber4;
    @FXML
    private Text Seatfield1, Seatfield2, Seatfield3, Seatfield4;
    @FXML
    private Text Statusfield1, Statusfield2, Statusfield3, Statusfield4;
    @FXML
    private Text UncheckNum;
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
    void gotoCheckFlight() throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("CheckFlight.fxml", "Back-end System");
        Stage stage = new Stage();
        Stage stage_old = (Stage) FlightList.getScene().getWindow();
        stage_old.close();
        jumpto.start(stage);
    }


    @FXML
    public void initialize(URL arg0, ResourceBundle arg1) {
        flightNum = EnterFlightController.flight_num;
        ArrayList<Text> namelist = new ArrayList<>();
        namelist.add(Namefield1);
        namelist.add(Namefield2);
        namelist.add(Namefield3);
        namelist.add(Namefield4);
        ArrayList<Text> IDnumberlist = new ArrayList<>();
        IDnumberlist.add(IDnumber1);
        IDnumberlist.add(IDnumber2);
        IDnumberlist.add(IDnumber3);
        IDnumberlist.add(IDnumber4);
        ArrayList<Text> seatlist = new ArrayList<>();
        seatlist.add(Seatfield1);
        seatlist.add(Seatfield2);
        seatlist.add(Seatfield3);
        seatlist.add(Seatfield4);
        ArrayList<Text> statuslist = new ArrayList<>();
        statuslist.add(Statusfield1);
        statuslist.add(Statusfield2);
        statuslist.add(Statusfield3);
        statuslist.add(Statusfield4);


        //read passenger csv
        String csvFile = "csv/data.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] passenger = new String[16];
        int i = 0;
        int uncheck=0;

        //match the information
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                passenger = line.split(cvsSplitBy);
                // check the name
                if (passenger[11].equals(flightNum)) {
                    namelist.get(i).setText(passenger[2]);
                    seatlist.get(i).setText(passenger[6]);
                    IDnumberlist.get(i).setText(passenger[1]);
                    if (passenger[3] != null && passenger[6] != null && passenger[8].equals("1")) {
                        statuslist.get(i).setText("yes");
                    } else {
                        uncheck++;
                        statuslist.get(i).setText("no");
                    }
                    i++;
                    test = 1;
                }
            }
            System.out.println("over");
            UncheckNum.setText(String.valueOf(uncheck));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}