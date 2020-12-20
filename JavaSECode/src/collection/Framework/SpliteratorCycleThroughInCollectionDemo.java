package collection.Framework;

import java.util.ArrayList;
import java.util.Spliterator;

/**
 *
 * @author Naveen
 */


// this program explain the use of Spliterator interface for cycle through the collection.
public class SpliteratorCycleThroughInCollectionDemo {
    public static void main(String args[]) {

        // Create an array list for doubles.
        ArrayList<Double> vals = new ArrayList<>();

        // Add values to the array list.
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);

        // Use tryAdvance() to display contents of vals.
        System.out.print("Contents of vals:\n");
        // creating Spliterator instance.
        Spliterator<Double> spltitr = vals.spliterator();
        while(spltitr.tryAdvance((n) -> System.out.println(n)));
        System.out.println();

        // Create new list that contains square roots.
        spltitr = vals.spliterator();
        //creating new array list for square root
        ArrayList<Double> sqrs = new ArrayList<>();
        while(spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));

        // Use forEachRemaining() to display contents of sqrs.
        System.out.print("Contents of sqrs:\n");
        spltitr = sqrs.spliterator();
        spltitr.forEachRemaining((n) -> System.out.println(n));
        System.out.println();
    }
}
