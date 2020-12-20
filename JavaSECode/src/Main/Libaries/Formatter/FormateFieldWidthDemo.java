package Main.Libaries.Formatter;
/**
*
* @author Naveen
*/

//For example, the next program produces a table of squares and cubes for the
//numbers between 1 and 10:
// Create a table of squares and cubes.
import java.util.*;
public class FormateFieldWidthDemo {
    public static void main(String args[]) {
        Formatter fmt;
        for(int i=1; i <= 10; i++) {
        fmt = new Formatter();
        fmt.format("%4d %4d %4d", i, i*i, i*i*i);
        System.out.println(fmt);
        fmt.close();
        }
  }
}
