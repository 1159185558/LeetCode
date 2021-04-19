import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

public class Start {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR,0);
        calendar.set(Calendar.MINUTE,2);
        calendar.set(Calendar.SECOND, 3);
        Date date = calendar.getTime();
        DateFormat df = DateFormat.getTimeInstance();

        Integer integer = 1;

        System.out.println(integer.toString());
    }
}
