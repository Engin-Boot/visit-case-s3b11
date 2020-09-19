package footfallcounter.receiver;


import java.util.List;
import java.util.TreeMap;

public class ReceiverMain {
    public static void main(String args [])
    {
        List<TreeMap<String, String>> consolidatedAggregates = FootfallTimestampsConsoleReader.readFootfallTimestampsFromConsole();
        FootfallAggregatesCSVWriter.writeAggregatesToCSV("Result.csv", consolidatedAggregates);
    }
}
