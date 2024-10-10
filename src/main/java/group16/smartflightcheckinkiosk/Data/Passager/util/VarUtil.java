package group16.smartflightcheckinkiosk.Data.Passager.util;

import java.util.ResourceBundle;

//存放静态变量的类
public class VarUtil {
    //csv文件路径，和编码
    public static final String DATAPATH = "csv/data.csv";
    public static final String LOGINPATH = "csv/login.csv";
    public static final String SAVEPATH = "csv/data.csv";
    public static final String CHARSET = "UTF-8";

    //各种座位和食物类型的价格
    public static final double MEAL_A = Double.parseDouble(ResourceBundle.getBundle("price").getString("meal_A"));
    public static final double MEAL_B = Double.parseDouble(ResourceBundle.getBundle("price").getString("meal_B"));
    public static final double MEAL_C = Double.parseDouble(ResourceBundle.getBundle("price").getString("meal_C"));
    public static final double MEAL_D = Double.parseDouble(ResourceBundle.getBundle("price").getString("meal_D"));
    public static final double SEAT_A = Double.parseDouble(ResourceBundle.getBundle("price").getString("seat_A"));
    public static final double SEAT_B = Double.parseDouble(ResourceBundle.getBundle("price").getString("seat_B"));
    public static final double SEAT_C = Double.parseDouble(ResourceBundle.getBundle("price").getString("seat_C"));
    public static final double SEAT_D = Double.parseDouble(ResourceBundle.getBundle("price").getString("seat_D"));
}
