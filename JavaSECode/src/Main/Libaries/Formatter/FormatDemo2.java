package Main.Libaries.Formatter;
/**
*
* @author Naveen
*/
import java.util.Formatter;

//The following program demonstrates the effect of the %f and %e format specifiers:
 // Demonstrate the %f and %e format specifiers.
public class FormatDemo2 {
    public static void main(String args[]) {
        Formatter fmt = new Formatter();
        for (double i = 1.23; i < 1.0e+6; i *= 100) {
            fmt.format("floating-point value :%f scientific notation: %e", i, i);
            System.out.println(fmt);
        }
        fmt.close();
    }
}
