package group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Jumpto;
import group16.smartflightcheckinkiosk.StageManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * choose staff or passenger
 * @author Ruoqi Zhang
 * @version jdk15.0.2
 */
public class ChooseLoginController {

    @FXML
    private Label confirm4;

    /**
     * choose passenger login
     * @throws Exception click no response
     */
    @FXML
    public void gotoPassengerLogin() throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("PassengerLogin.fxml", "login");
        Stage stage = new Stage();
        StageManager.STAGE.put("loginPage", stage);
        jumpto.start(stage);
        Stage stage_old = (Stage) confirm4.getScene().getWindow();
        stage_old.close();
    }

    /**
     * choose staff login
     * @throws Exception click no response
     */
    @FXML
    public void gotoStaffLogin() throws Exception {
        Jumpto jumpto = new Jumpto();
        jumpto.set("StaffLogin.fxml", "Staff Login");
        Stage stage = new Stage();
        StageManager.STAGE.put("loginPage", stage);
        jumpto.start(stage);
        Stage stage_old = (Stage) confirm4.getScene().getWindow();
        stage_old.close();
    }


}





