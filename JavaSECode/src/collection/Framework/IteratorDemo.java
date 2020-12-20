package collection.Framework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Naveen
 */


// this program explain the use of iterator and ListIterator interfaces for cycle through the collection.
public class IteratorDemo {
    public static void main(String args[]) {

        // Create an array list.
        ArrayList<String> al = new ArrayList<String>();

        // Add elements to the array list.
        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        // Use iterator to display contents of al.
        System.out.print("Original contents of al: ");
        Iterator<String> itr = al.iterator();
        //Set up a loop that makes a call to hasNext( ). Have the loop iterate forword  as long as
        //hasNext( ) returns true.
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Modify objects being iterated.
        ListIterator<String> litr = al.listIterator();
        //Set up a loop that makes a call to hasNext( ). Have the loop iterate forword as long as
        //hasNext( ) returns true.
        while (litr.hasNext()) {
            String element = litr.next();
            litr.set(element + "+");
        }
        System.out.print("Modified contents of al: ");
        itr = al.iterator();
        while (itr.hasNext()) {
            String element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        // Now, display the list backwards.
        System.out.print("Modified list backwards: ");
        //Set up a loop that makes a call to hasPrevious( ). Have the loop iterate in backword as long as
        //hasPrevious( ) returns true.
        while (litr.hasPrevious()) {
            String element = litr.previous();
            System.out.print(element + " ");
        }
        System.out.println();
    }
}