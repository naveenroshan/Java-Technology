package Main.Libaries;

import java.util.Random;

/**
 *
 * @author Naveen
 */

//Here is an example that demonstrates the sequence produced by nextGaussian( ). It
//obtains 100 random Gaussian values and averages these values. The program also counts the
//number of values that fall within two standard deviations, plus or minus, using increments of
//0.5 for each category. The result is graphically displayed sideways on the screen.
public class RandDemo {
    public static void main(String args[]) {
        Random r = new Random();
        double val;
        double sum = 0;
        int bell[] = new int[10];
        for(int i=0; i<100; i++) {
            val = r.nextGaussian();
            sum += val;
            double t = -2;
            for(int x=0; x<10; x++, t += 0.5)
                if(val < t) {
                    bell[x]++;
                    break;
                }
        }
        System.out.println("Average of values: " + (sum/100));

        // display bell curve, sideways
        for(int i=0; i<10; i++) {
            for(int x=bell[i]; x>0; x--)
                System.out.print("*");
            System.out.println();
        }
    }
}
