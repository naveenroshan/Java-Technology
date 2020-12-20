package collection.Framework;

import java.util.TreeSet;

/**
 *
 * @author Naveen
 */
public class TreeSetDemo {
    public static void main(String args[]) {
// Create a tree set.
        TreeSet<String> ts = new TreeSet<String>();
// Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        // the out put are displayed by ascending order rathere than inserted order.
        System.out.println(ts);
        System.out.println(ts.subSet("C","E"));
    }
}
