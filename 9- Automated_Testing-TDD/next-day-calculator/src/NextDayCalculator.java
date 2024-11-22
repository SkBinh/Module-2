import java.util.Calendar;

public class NextDayCalculator {
    public static String getNextDay(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        int nextDay = calendar.get(Calendar.DAY_OF_MONTH);
        int nextMonth = calendar.get(Calendar.MONTH) + 1;
        int nextYear = calendar.get(Calendar.YEAR);

        return nextDay + "/" + nextMonth + "/" + nextYear;
    }
}
