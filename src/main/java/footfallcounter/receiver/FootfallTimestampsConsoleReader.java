package footfallcounter.receiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FootfallTimestampsConsoleReader {
    public static List<TreeMap<String, String>> readFootfallTimestampsFromConsole(){
        String line = "";
        List<DateTime> footfallTimestamps = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
			while((line = br.readLine())!=null) {
			    DateTime obj = StringToDateTimeObjectCreator.convertStringToDateTime(line);
			    footfallTimestamps.add(obj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		TreeMap<String, String> averageFootfallsPerHourOverDay = AggregatesCalculator.calculateAverageFootfallsPerHourOverDay(footfallTimestamps);
		TreeMap<String, String> peakDailyFootfallInTheLastMonth = AggregatesCalculator.calculatePeakDailyFootfallInTheLastMonth(footfallTimestamps);
		TreeMap<String, String> avgDailyFootfallsInAWeek = AggregatesCalculator.calculateAverageDailyFootfallsInAWeek(footfallTimestamps);
		List<TreeMap<String, String>> consolidatedAggregates = new ArrayList<>();
		consolidatedAggregates.add(averageFootfallsPerHourOverDay);
		consolidatedAggregates.add(avgDailyFootfallsInAWeek);
		consolidatedAggregates.add(peakDailyFootfallInTheLastMonth);
		System.out.println(averageFootfallsPerHourOverDay);
		System.out.println(avgDailyFootfallsInAWeek);
		System.out.println(peakDailyFootfallInTheLastMonth);
		return consolidatedAggregates;
    }
}
