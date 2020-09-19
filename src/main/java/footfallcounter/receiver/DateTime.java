package footfallcounter.receiver;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateTime {
    LocalDate date;
    LocalTime time;
    public DateTime(LocalDate date,LocalTime time)
    {
        this.date = date;
        this.time = time;
    }
}
