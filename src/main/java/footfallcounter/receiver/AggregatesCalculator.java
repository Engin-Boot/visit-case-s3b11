package footfallcounter.receiver;

import java.text.DecimalFormat;
import java.time.Month;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.lang.Math;

public class AggregatesCalculator {

    public static Integer getWeek (LocalDate date)
    {
        Integer week = ((date.getDayOfMonth()-1)/7)+1;
        return week;
    }

    public static Map<LocalDate, Integer> calculateDateToCountThatDay (List<DateTime> footfallTimestamps)
    {
        Map<LocalDate, Integer> dateToCountThatDayMap = new TreeMap<>();
        for (DateTime instance: footfallTimestamps)
        {
            if(dateToCountThatDayMap.containsKey(instance.date))
            {
                dateToCountThatDayMap.put(instance.date, dateToCountThatDayMap.get(instance.date)+1);
            }
            else
            {
                dateToCountThatDayMap.put(instance.date, 1);
            }
        }
        return dateToCountThatDayMap;
    }

    public static TreeMap<String, String> calculateAverageFootfallsPerHourOverDay(List<DateTime> footfallTimestamps){
        Map<LocalDate, Float> dateFootfallMap = new TreeMap<>();
        TreeMap<String, String> averageFootfallsPerHourOverDay = new TreeMap<>();
        for (DateTime instance: footfallTimestamps)
        {
            if(dateFootfallMap.containsKey(instance.date))
            {
                dateFootfallMap.put(instance.date, dateFootfallMap.get(instance.date)+1);
            }
            else
            {
                dateFootfallMap.put(instance.date, 1.0f);
            }
        }
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        for (Map.Entry<LocalDate,Float> entry : dateFootfallMap.entrySet())
        {
            averageFootfallsPerHourOverDay.put(entry.getKey().toString(), df.format(entry.getValue()/24.0f));
        }
        return averageFootfallsPerHourOverDay;
    }

    public static TreeMap<String, String> calculateAverageDailyFootfallsInAWeek(List<DateTime> footfallTimestamps){
        TreeMap<String, Float> averageDailyFootfallsInAWeek = new TreeMap<>();
        TreeMap<String, String> avgDailyFootfallsInAWeek = new TreeMap<>();
        Map<LocalDate, Integer> dateToCountThatDayMap = calculateDateToCountThatDay(footfallTimestamps);
        for(DateTime instance: footfallTimestamps)
        {
            LocalDate date = instance.date;
            String month = date.getMonth().toString();
            Integer week = getWeek(date);
            if(averageDailyFootfallsInAWeek.containsKey(month + " week" + Integer.toString(week)))
            {
                averageDailyFootfallsInAWeek.put(month + " week" + Integer.toString(week), averageDailyFootfallsInAWeek.get(month + " week" + Integer.toString(week))+1.0f);
            }
            else
            {
                averageDailyFootfallsInAWeek.put(month + " week" + Integer.toString(week), 1.0f);
            }
        }
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        for (Map.Entry<String,Float> entry : averageDailyFootfallsInAWeek.entrySet())
        {
            avgDailyFootfallsInAWeek.put(entry.getKey(), df.format(entry.getValue()/7.0f));
        }
        return avgDailyFootfallsInAWeek;
    }

    public static TreeMap<String, String> calculatePeakDailyFootfallInTheLastMonth(List<DateTime> footfallTimestamps){
        TreeMap<String, String> peakFootfallMap = new TreeMap<>();
        Map<LocalDate, Integer> dateToCountThatDayMap = calculateDateToCountThatDay(footfallTimestamps);
        for(DateTime instance: footfallTimestamps)
        {
            LocalDate date = instance.date;
            Month month = instance.date.getMonth();
            if(peakFootfallMap.containsKey(month.toString()))
            {
                peakFootfallMap.put(month.toString(), Integer.toString(Math.max(Integer.parseInt(peakFootfallMap.get(month.toString())),dateToCountThatDayMap.get(date))));
            }
            else
            {
                peakFootfallMap.put(month.toString(), "0");
            }
        }
        return peakFootfallMap;
    }
}