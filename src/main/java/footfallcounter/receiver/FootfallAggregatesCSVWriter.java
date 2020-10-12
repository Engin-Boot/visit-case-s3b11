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
            writeTreeMapToCSV(averageFootfallsPerHourOverDay, filepath);
            csvWriter.append("Average daily footfalls in a week, \n");
            csvWriter.append("Weeks,Avg Footfalls\n");
            writeTreeMapToCSV(avgDailyFootfallsInAWeek, filepath);
            csvWriter.append("Peak daily footfall in the last month, \n");
            csvWriter.append("Month,Peak Footfalls\n");
            writeTreeMapToCSV(peakDailyFootfallInTheLastMonth, filepath);
            //csvWriter.flush();
            //csvWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void writeTreeMapToCSV(TreeMap<String, String> map, String filepath)
    {
        try {
            FileWriter csvWriter = new FileWriter(new File(filepath), true);
            for (Map.Entry<String,String> entry : map.entrySet())
            {
                csvWriter.append(entry.getKey()+","+entry.getValue()+"\n");
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
