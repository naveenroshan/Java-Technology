package collection.Framework;
/**
 *
 * @author Naveen
 */
import java.util.HashSet;

//this is the Example for the hashset in collection frame work.
public class HashSetDemo {
    public static void main(String args[]) {
        // Create a hash set.
        HashSet<String> hs = new HashSet<String>();
       // Add elements to the hash set.
        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");
        //element string are not displayed in order has they were inserted
        // to over come this we have to use LinkedHashSet
        System.out.println(hs);
    }
}
