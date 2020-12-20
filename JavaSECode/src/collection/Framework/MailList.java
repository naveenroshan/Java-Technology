package collection.Framework;
/**
 *
 * @author Naveen
 */
import java.util.LinkedList;

// this class is linked with the Address
//this class explaining the Storing User-Defined Classes in Collections using LinkedList
public class MailList {
    public static void main(String args[]) {
        //created new LinkedList intance for String type which is the type of address.
        LinkedList<Address> ml = new LinkedList<Address>();

        // Add elements to the linked list.
        ml.add(new Address("J.W. West", "11 Oak Ave","Urbana", "IL", "61801"));
        ml.add(new Address("Ralph Baker", "1142 Maple Lane","Mahomet", "IL", "61853"));
        ml.add(new Address("Tom Carlton", "867 Elm St","Champaign", "IL", "61820"));

        // Display the mailing list.
        for(Address element : ml)
            System.out.println(element + "\n");
        System.out.println();
    }
}
