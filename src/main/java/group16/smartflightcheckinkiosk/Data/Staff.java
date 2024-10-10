package group16.smartflightcheckinkiosk.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.util.Scanner;

public class Staff {
    String StaffNumber;
    String Password;
    String FlightNumber;
    String Destination;
    String Airport;
    String Time;

    public Staff(String StaffNumber,String Password){
        this.StaffNumber=StaffNumber;
        this.Password=Password;
    }

    void CheckStaff(){
        String csvFile = "csv/Staff.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] staff= new String[2];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                staff = line.split(cvsSplitBy);
                // check the StaffNumber and Password
                if (staff[0].equals(StaffNumber)&&staff[1].equals(Password)) {
                    break;
                }
            }
            if(staff[0].equals(StaffNumber)&&staff[1].equals(Password)){
                System.out.println("Check in");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    void FindFlight(){
        Scanner input=new Scanner(System.in);
        System.out.println("please print the flight");
        FlightNumber=input.next();

        String csvFile = " src/main/resources/group16.smartflightcheckinkiosk/Flight.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] flight= new String[4];

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                flight = line.split(cvsSplitBy);
                // check the FlghtNumber
                if (flight[0].equals(FlightNumber)) {
                    break;
                }
            }
            if(flight[0].equals(FlightNumber)){
                Destination=flight[1];
                Airport=flight[2];
                Time=flight[3];
                System.out.println(Destination+" "+Airport+" "+Time);
                System.out.println("find");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
