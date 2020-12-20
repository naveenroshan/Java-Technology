package Main.Libaries.Formatter;

import java.util.Calendar;
import java.util.Formatter;

/**
*
* @author Naveen
*/


//Relative indexes are especially useful when creating custom time and date formats.
//Consider the following example:
// Use relative indexes to simplify the
// creation of a custom time and date format.
public class FormateArgumentIndexDemo {
    public static void main(String args[]) {
        Formatter fmt = new Formatter();
        Calendar cal = Calendar.getInstance();
        fmt.format("Today is day %te of %<tB, %<tY", cal);
        System.out.println(fmt);
        fmt.close();
        }
}
