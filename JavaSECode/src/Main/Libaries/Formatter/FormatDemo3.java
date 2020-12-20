package Main.Libaries.Formatter;
/**
*
* @author Naveen
*/
//Here is an example that demonstrates the %n and %% format specifiers:
//Demonstrate the %n and %% format specifiers.
import java.util.*;

public class FormatDemo3 {
    public static void main(String args[]) {
        Formatter fmt = new Formatter();
        fmt.format("Copying file%nTransfer is %d%% complete", 88);
        System.out.println(fmt);
        fmt.close();
        }
    }
