package footfallcounter.receiver;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StringToDateTimeObjectCreator {
    public static LocalDate convertDateStringToLocaleDate(String date)
    {
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate dateLocale = LocalDate.parse(date, formatDate);
        return dateLocale;
    }
    public static LocalTime convertTimeStringToLocaleTime(String time)
    {
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime timeLocale = LocalTime.parse(time, formatTime);
        return timeLocale;
    }
    public static DateTime convertStringToDateTime(String dateTimeString){
        String [] temp = dateTimeString.split(" ");
        String dateString = temp[0];
        String timeString = temp[1];
        DateTime object = new DateTime(convertDateStringToLocaleDate(dateString), convertTimeStringToLocaleTime(timeString));
        return object;
    }
}
