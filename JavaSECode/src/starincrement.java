package SECode;

/**
 *
 * @author Naveen
 */
public class starincrement {
    public static void main(String[] args) {
        int j, k;

        for(j=0; j<5; j++)
        {
            for(k=0; k<j; k++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}