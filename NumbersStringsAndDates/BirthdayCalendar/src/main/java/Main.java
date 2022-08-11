import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        int day = 31;
        int month = 12;
        int year = 1990;

        System.out.println(collectBirthdays(year, month, day));

    }

    public static String collectBirthdays(int year, int month, int day) {

        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        Date currentDate = new Date();
        StringBuilder text = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - E", Locale.ENGLISH);
        Calendar bDate = new GregorianCalendar(year, month-1, day);
        Date date = bDate.getTime();
        int counter = 0;
        while (date.before(currentDate)){
            text.append(System.lineSeparator()).append(counter++).append(" - ").append(dateFormat.format(date));
            bDate.add(Calendar.YEAR, 1);
            date = bDate.getTime();
        }

        return String.valueOf(text);
    }
}
