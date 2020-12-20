package collection.Framework;

import java.util.ArrayDeque;

/**
 *
 * @author Naveen
 */

//this is the Example for the ArrayDequeDemo in collection frame work.
    // Array Deque works like stack concept, so it work like first in last out.
public class ArrayDequeDemo {
    public static void main(String args[]) {
        // Create an array deque.
        ArrayDeque<String> adq = new ArrayDeque<String>();
        // Use an ArrayDeque like a stack.
        adq.push("A");
        adq.push("B");
        adq.push("D");
        adq.push("E");
        adq.push("F");
        System.out.print("Popping the stack: ");
        while (adq.peek() != null)
            System.out.print(adq.pop() + " ");
        System.out.println();
    }
}
