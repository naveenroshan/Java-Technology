package Main.Libaries.Formatter;
/**
*
* @author Naveen
*/
import java.util.Calendar;
import java.util.Formatter;

//The argument corresponding to the %t specifier must be of type Calendar, Date, Long, or long.
//Here is a program that demonstrates several of the formats:
public class FormateTimeDateFormatDemo {
    public static void main(String args[]) {
        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        
        // Display standard 12-hour time format.
        fmt.format("12-hour time format :%tr", cal);
        System.out.println(fmt);
        fmt.close();
        
        // Display complete time and date information.
        fmt = new Formatter();
        fmt.format("time and date information :%tc", cal);
        System.out.println(fmt);
        fmt.close();
        
        // Display just hour and minute.
        fmt = new Formatter();
        fmt.format("hour and minute :%tl:%tM", cal, cal);
        System.out.println(fmt);
        fmt.close();
        
        // Display month by name and number.
        fmt = new Formatter();
        fmt.format("month by name and number :%tB %tb %tm", cal, cal, cal);
        System.out.println(fmt);
        fmt.close();
    }
}
