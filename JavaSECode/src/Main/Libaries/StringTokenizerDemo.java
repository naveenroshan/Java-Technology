package Main.Libaries;
/**
*
* @author Naveen
*/
import java.util.StringTokenizer;

public class StringTokenizerDemo {
    static String in = "title=Java: The Complete Reference;" + "author=Schildt;" + "publisher=McGraw-Hill;" + "copyright=2014";

    public static void main(String args[]) {
        StringTokenizer st = new StringTokenizer(in, "=;");
        while (st.hasMoreTokens()) {
            String key = st.nextToken();
            String val = st.nextToken();
            System.out.println(key + "\t" + val);
        }
    }
}
