package collection.Framework;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
*
* @author Naveen
*/

/*For a more practical example that uses a custom comparator, the following program is an
updated version of the TreeMap program shown earlier that stores account balances. In the
previous version, the accounts were sorted by name, but the sorting began with the first name.
The following program sorts the accounts by last name. To do so, it uses a comparator that
compares the last name of each account. This results in the map being sorted by last name.*/

//linked class is TreeMapTwo.

public class TreeMapDemoTwo {
    public static void main(String args[]) {
     
        // Create a tree map.
        TreeMap<String, Double> tm = new TreeMap<String, Double>(new TreeMapTwo());
        
        // Put elements to the map.
        tm.put("John Doe", new Double(3434.34));
        tm.put("Tom Smith", new Double(123.22));
        tm.put("Jane Baker", new Double(1378.00));
        tm.put("Tod Hall", new Double(99.22));
        tm.put("Ralph Smith", new Double(-19.08));
        
        // Get a set of the entries.
        Set<Map.Entry<String, Double>> set = tm.entrySet();
        
        // Display the elements.
        for(Map.Entry<String, Double> me : set) {
        System.out.print(me.getKey() + ": ");
        System.out.println(me.getValue());
        }
        System.out.println();
       
        // Deposit 1000 into John Doe's account.
        double balance = tm.get("John Doe");
        tm.put("John Doe", balance + 1000);
        System.out.println("John Doe's new balance: " +
        tm.get("John Doe"));
        }
}
