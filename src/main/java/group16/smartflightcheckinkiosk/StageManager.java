package group16.smartflightcheckinkiosk;

import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

// This class is used to control other stage.
public class StageManager {
    public static Map<String, Stage> STAGE=new HashMap<String, Stage>();
    public static Map<String, Object> CONTROLLER=new HashMap<String, Object>();
}