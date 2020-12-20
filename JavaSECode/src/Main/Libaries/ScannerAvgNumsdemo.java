package Main.Libaries;

import java.util.Scanner;

/**
*
* @author Naveen
*/


// Scanner makes what could be a tedious task into an easy one. To understand why, let’s
// look at some examples. The following program averages a list of numbers entered at the
// keyboard:
// Use Scanner to compute an average of the values.
public class ScannerAvgNumsdemo {
    public static void main(String args[]) {
        Scanner conin = new Scanner(System.in);
        int count = 0;
        double sum = 0.0;
        System.out.println("Enter numbers to average.");
        // Read and sum numbers.
        while (conin.hasNext()) {
            if (conin.hasNextDouble()) {
                sum += conin.nextDouble();
                count++;
            } else {
                String str = conin.next();
                if (str.equals("done"))
                    break;
                else {
                    System.out.println("Data format error.");
                    return;
                }
            }
        }
        conin.close();
        System.out.println("Average is " + sum / count);
    }
}
