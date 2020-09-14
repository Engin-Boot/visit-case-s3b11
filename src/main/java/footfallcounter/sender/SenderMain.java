package footfallcounter.sender;

import java.util.*;

public class SenderMain {
    public static void main(String args []){
        String csvFilePath = "Database/Dataset.csv";
        try {
            List<DateTime> footfall = FootfallTimestampsCSVReader.readFootfallTimestampsFromCSV(csvFilePath);
            for (int i=0; i<footfall.size(); i++)
            {
                System.out.println("Date " + footfall.get(i).Date + "Time " + footfall.get(i).Time);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
