package footfallcounter.sender;

import java.util.*;

public class SenderMain {
    public static void main(String args []){
        String csvFilePath = "Database/Dataset.csv";
        try {
            List<DateTime> footfall = FootfallTimestampsCSVReader.readFootfallTimestampsFromCSV(csvFilePath);
            //FootfallTimestampsConsoleWriter.writeFootfallTimestampsToConsole(footfall);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
