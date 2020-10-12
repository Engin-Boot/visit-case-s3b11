package footfallcounter.receiver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FootfallAggregatesCSVWriter {
    public static void writeAggregatesToCSV(String filepath, List<TreeMap<String, String>> consolidatedAggregates)
    {
        TreeMap<String, String> averageFootfallsPerHourOverDay = consolidatedAggregates.get(0);
        TreeMap<String, String> avgDailyFootfallsInAWeek = consolidatedAggregates.get(1);
        TreeMap<String, String> peakDailyFootfallInTheLastMonth = consolidatedAggregates.get(2);
        try {
            FileWriter csvWriter = new FileWriter(new File (filepath));
            csvWriter.append("Average Hourly Footfalls Over a Day, \n");
            csvWriter.append("Date,Avg Footfalls\n");
            //String [] header3 = {"Peak daily footfall in the last month", ""};
            //String [] header3a = {"Month", "Peak Footfalls"};
            for (Map.Entry<String,String> entry : averageFootfallsPerHourOverDay.entrySet())
            {
                csvWriter.append(entry.getKey()+","+entry.getValue()+"\n");
            }
            csvWriter.append("Average daily footfalls in a week, \n");
            csvWriter.append("Weeks,Avg Footfalls\n");
            /*for (Map.Entry<String,String> entry : avgDailyFootfallsInAWeek.entrySet())
            {
                csvWriter.append(entry.getKey()+","+entry.getValue()+"\n");
            }
            csvWriter.append("Peak daily footfall in the last month, \n");
            csvWriter.append("Month,Peak Footfalls\n");
            for (Map.Entry<String,String> entry : peakDailyFootfallInTheLastMonth.entrySet())
            {
                csvWriter.append(entry.getKey()+","+entry.getValue()+"\n");
            }*/
            csvWriter.flush();
            csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
