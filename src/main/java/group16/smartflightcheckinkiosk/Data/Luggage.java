package group16.smartflightcheckinkiosk.Data;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

public class Luggage {
    String IDNumber;
    int CarryOnBag;
    int CheckInBag;
    String Tag;

    public Luggage(String IDNumber)
    {
        this.IDNumber=IDNumber;
    }

    void FindLuggage(String IDNumber){
        String csvFile = " csv/Luggage.csv";
        String line = "";
        String cvsSplitBy = ",";
        String[] information= new String[4];

        //find the luggage from the csv
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                information = line.split(cvsSplitBy);
                if (information[0].equals(IDNumber)) {
                    break;
                }
            }
            if(information[0].equals(IDNumber)){
                CarryOnBag=Integer.parseInt(information[1]);
                CheckInBag=Integer.parseInt(information[2]);
                Tag=information[3];
                System.out.println(CarryOnBag+" "+CheckInBag+" "+Tag);
            }
        }
        catch (IOException e) {
            //TODO: replace with a robust exception processor
            e.printStackTrace();
        }
    }
}

