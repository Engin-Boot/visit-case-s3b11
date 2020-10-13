package footfallcounter.sender;

import java.util.List;

public class FootfallTimestampsConsoleWriter {
    public static void writeFootfallTimestampsToConsole (List<DateTime> footfall) throws Exception
    {
        for(DateTime instance : footfall)
        {
            System.out.println(instance.Date + " " + instance.Time);
        }
    }
}
