package Main.Libaries;
/**
 *
 * @author Naveen
 */
import java.util.Date;


//As the following program
//demonstrates, you can only obtain the date and time in terms of milliseconds, in its default
//string representation as returned by toString( ), or (beginning with JDK 8) as an Instant object.
//To obtain more-detailed information about the date and time, you will use the Calendar class.
public class DateDemo {
    public static void main(String args[]) {

        // Instantiate a Date object
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date);

        // Display number of milliseconds since midnight, January 1, 1970 GMT
        long msec = date.getTime();
        System.out.println("Milliseconds since Jan. 1, 1970 GMT = " + msec);
    }
}
