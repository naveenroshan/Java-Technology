package collection.Framework;

import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author Naveen
 */

// this example explain the use of lambda expression in tree set collection by using comparator in
// lambda expression
// This class is the part two of the MyCampDemo in this package.
public class ComparatorWithLambdaExpression {
    public static void main(String args[]) {

        // Use a lambda expression to implement Comparator<String>.
        //this below line give the custom Comparator for the treeSet collection.
        Comparator<String> mc = (aStr, bStr) -> aStr.compareTo(bStr);

        // Create a tree set.
        // Pass a reversed comparator to TreeSet() via a
        // lambda expression.
        TreeSet<String> ts = new TreeSet<String>(mc);

        // Add elements to the tree set.
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");

        // Display the elements.
        for (String element : ts)
            System.out.print(element + " ");
        System.out.println();
    }
}
