import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        WeeklyCalendar wc = new WeeklyCalendar();
        wc.addEntry("Friday","sleep");
        wc.addEntry("Sunday","sleepfef");
        wc.addEntry("Saturday","sleepfefefwefwef");
        wc.addEntry("Monday","sport");
        Iterable<WeeklyEntry> schedule = wc.getWeeklySchedule();
        for (WeeklyEntry weeklyEntry : schedule) {
            System.out.println(weeklyEntry);
        }






    }
}
