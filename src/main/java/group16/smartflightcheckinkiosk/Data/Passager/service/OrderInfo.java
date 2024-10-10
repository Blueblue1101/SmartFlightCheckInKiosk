package group16.smartflightcheckinkiosk.Data.Passager.service;

import group16.smartflightcheckinkiosk.Data.Passager.util.PlaneUtil;
import group16.smartflightcheckinkiosk.Data.Passager.util.VarUtil;

import java.util.List;
import java.util.Scanner;

public class OrderInfo {



    public int orderIndex = -1;

    public List<Order> orders;

    public OrderInfo(){
        orders = this.getCSV(VarUtil.DATAPATH, VarUtil.CHARSET);
    }

    //业务方法
    public void startService(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Please choose your login way(1 booking number, 2 Surname和ID, 3 ID document): ");
        String choose = scanner.nextLine();
        //调用选择登陆模式的方法
        while(!chooseWays(choose, scanner)){
            System.out.println("\nYou log in failed(1/2/3)，or input\"exit\"to exit: ");
            choose = scanner.nextLine();
            if("exit".equals(choose)){
                System.exit(0);
            }
        }
        while(true){
            menu();
            choose = scanner.nextLine();
            switch (choose){
                case "1":{
                    this.setSeat(scanner);
                    break;
                }
                case "2":{
                    this.setMeal(scanner);
                    break;
                }
                case "3":{
                    this.payment(scanner);
                    break;
                }
                case "4":{
                    this.writeDisk(scanner);
                    break;
                }
                case "5":{
                    showInfo();
                    break;
                }
                case "6":{
                    System.out.println("bye bye ");
                    System.exit(0);
                    break;
                }
                default:
                    System.out.println("Your input is wrong");
                    break;
            }
        }
    }

    //总菜单显示
    void menu(){
        System.out.println("** Please choose your service number(1-6): ");
        System.out.println("*** 1 choose seat");
        System.out.println("*** 2 choose meal");
        System.out.println("*** 3 check budget");
        System.out.println("*** 4 store");
        System.out.println("*** 5 check information");
        System.out.println("*** 6 exit");
    }

    //修改座位样式
    void setSeat(Scanner scanner){
        PlaneUtil.setSeat(orders.get(orderIndex), scanner);
    }

    //修改飞机餐种类
    void setMeal(Scanner scanner){
        PlaneUtil.setMeal(orders.get(orderIndex), scanner);
    }

    //结算价格
    void payment(Scanner scanner){
        PlaneUtil.payment(orders.get(orderIndex), scanner);
    }

    //读取到文件
    void writeDisk(Scanner scanner){
        //写入到文件SAVEPATH
        PlaneUtil.writeDisk(orders, VarUtil.SAVEPATH, VarUtil.CHARSET, scanner);
    }

    //从CSV里面读取数据
    private List<Order> getCSV(String PATH, String  CHARSET){
        //调用工具类里面的方法
        return PlaneUtil.getOrdersFromCsv(PATH, CHARSET);
    }

    //选择登陆方式
    private boolean chooseWays(String choose, Scanner scanner){
        switch (choose){
            //根据飞机号查找
            case "1":
                System.out.println("请输入booking number:");
                String bookingNum = scanner.nextLine();
                orderIndex = checkBookingNumber(bookingNum);
                return orderIndex > -1;
            //根据用户名和ID查找
            case "2":
                System.out.println("Please enter your surname:");
                String username = scanner.nextLine();
                System.out.println("Please enter your ID number:");
                String id = scanner.nextLine();
                orderIndex = checkUsernameAndID(username, id);
                return orderIndex > -1;
            //到文件里面查找
            case "3":
                orderIndex = checkWithFile();
                return orderIndex > -1;
            //不合法的输入
            default:
                System.out.println("invalid input");
                return false;
        }
    }

    //用户文件登录
    public int checkWithFile(){
        List<Order> list = PlaneUtil.getOrdersFromLoginCsv(VarUtil.LOGINPATH, VarUtil.CHARSET);
        if(list.size() < 1) return -1;
        Order userInfo = list.get(0);
        System.out.println(userInfo);
        for (int i = 0; i < orders.size(); i++) {
            //遍历加判断
            if(orders.get(i).getSurname().equals(userInfo.getSurname())
                    && orders.get(i).getIDNumber().equals(userInfo.getIDNumber())
                    && orders.get(i).getBookingNumber().equals(userInfo.getBookingNumber())){
                //登陆成功友好提示
                loginSuccessMsg(userInfo.getSurname());
                return i;
            }
        }
        //没找到则返回-1
        System.out.println("surname or password is wrong");
        return -1;
    }

    //验证用户名和密码
    public int checkUsernameAndID(String username, String id){
        for (int i = 0; i < orders.size(); i++) {
            //遍历加判断
            if(orders.get(i).getSurname().equals(username) && orders.get(i).getIDNumber().equals(id)){
                //登陆成功友好提示
                loginSuccessMsg(username);
                return i;
            }
        }
        //没找到则返回-1
        System.out.println("Sorry, surname or password does not exit");
        return -1;
    }

    //验证booking number是否存在
    public int checkBookingNumber(String bookingNum){
        for (int i = 0; i < orders.size(); i++) {
            //遍历加判断
            if(orders.get(i).getBookingNumber().equals(bookingNum)){
                //登陆成功友好提示
                loginSuccessMsg(orders.get(i).getSurname());
                return i;
            }
        }
        //没找到则返回-1
        System.out.println("Sorry, booking number is not found");
        return -1;
    }

    //查看当前用户信息
    void showInfo(){
        if(orderIndex > -1){
            System.out.println(orders.get(orderIndex));
        }
    }

    //登陆成功欢迎提升
    private void loginSuccessMsg(String username){
        System.out.println("Log in successfully! Dear "+username+" , welcome to the flight system");
    }
}
