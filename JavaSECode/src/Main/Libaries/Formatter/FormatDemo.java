package Main.Libaries.Formatter;
/**
*
* @author Naveen
*/
import java.util.Formatter;

//A very simple example that uses Formatter.
public class FormatDemo {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();
        fmt.format("Formatting %s is easy %d %f", "with Java", 10, 98.6);
        System.out.println(fmt);
        fmt.close();
    }
}
