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
 * staff login
 * @author Ziding Lin, Liya Zhong
 * @version jdk-17
 */
public class StaffLoginController {

    @FXML
    private VBox StaffLogin;
    @FXML
    private TextField staffnumField;
    @FXML
    private TextField passwordfield;
    /**
     * staff number
     */
    public String staff_num;
    /**
     * junit test parameter
     */
    public int test=0;

    /**
     * back button event
     * @throws Exception click no response
     */
    @FXML
    void gotoChooseLogin() throws Exception{
        Jumpto jumpto = new Jumpto();
        jumpto.set("ChooseLogin.fxml", "Login");
        Stage stage = new Stage();
        Stage stage_old = (Stage) StaffLogin.getScene().getWindow();
        stage_old.close();
        jumpto.start(stage);
    }

    /**
     * next button event
     * @throws Exception click no response
     */
    @FXML
    public void gotoEnterFlight() throws Exception {
        staff_num = staffnumField.getText();
        String password = passwordfield.getText();
        //read the csv
        String csvFile = "csv/Staff.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] staff = new String[2];
        //match the information
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                staff = line.split(cvsSplitBy);
                // check the StaffNumber and Password
                if (staff[0].equals(staff_num)&&staff[1].equals(password)) {
                    break;
                }
            }
            //input right information
            if (staff[0].equals(staff_num) && staff[1].equals(password)) {
                Jumpto jumpto = new Jumpto();
                jumpto.set("EnterFlight.fxml", "Back-end System");
                Stage stage = new Stage();
                Stage stage_old = (Stage) StaffLogin.getScene().getWindow();
                stage_old.close();
                jumpto.start(stage);
                System.out.println("Check in");
                test=1;
            }
                //input wrong information
                else {
                    System.out.println("Input is wrong");
                    staffnumField.setText("");
                    passwordfield.setText("");
                    Jumpto jumpto = new Jumpto();
                    jumpto.set("Warning.fxml", "WARNING");
                    Stage stage = new Stage();
                    jumpto.start(stage);
                }
            }
        catch(IOException e){
                e.printStackTrace();
            }

    }

}
