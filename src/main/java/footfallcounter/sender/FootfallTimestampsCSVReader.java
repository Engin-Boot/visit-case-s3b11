package footfallcounter.sender;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class DateTime{

    String Date;
    String Time;

    public DateTime(String date, String time)
    {
        this.Date = date;
        this.Time = time;
    }
}

public class FootfallTimestampsCSVReader {

    public static void main(String args []) {
        String csvFilePath = "Database/Dataset.csv";
        ArrayList<DateTime> footfall = new ArrayList<DateTime>();
        String csvSplitBy = " ";
        String row = "";

        try (BufferedReader csvReader = new BufferedReader(new FileReader(csvFilePath))) {

            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(csvSplitBy);
                DateTime temp = new DateTime(data[0], data[1]);
                footfall.add(temp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i=0; i<footfall.size(); i++)
        {
            System.out.println("Date " + footfall.get(i).Date + "Time " + footfall.get(i).Time);
        }

    }
}
