package SECode;
/**
 *
 * @author Naveen
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextEditorApp {
    public static void main(String[] args) throws IOException {
        // create a BufferedReader using System.in
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str[] = new String[100];
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'stop' to quit.");
        //this for loop is used to store the value in array form the console.
        for (int i = 0; i < 100; i++) {
            str[i] = br.readLine();
            // this if loop stop the reading string from user by getting "stop" string
            if (str[i].equals("stop")) break;
        }
        System.out.println("\nHere is your file:");
        // display the lines
        for (int i = 0; i < 100; i++) {
            //this if loop helps to print only the user typed strings
            if (str[i].equals("stop")) break;
            System.out.println(str[i]);
        }
    }
}
