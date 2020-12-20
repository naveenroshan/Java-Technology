package memory.in.java;
/**
*
* @author Naveen
*/

// this program explains the heap and stack memory in java using the program and block diagram.
// the above example found in the blog."https://www.journaldev.com/4098/java-heap-space-vs-stack-memory".

public class Memory {
    public static void main(String[] args) { // Line 1
        int i = 1; // Line 2
        Object obj = new Object(); // Line 3
        Memory mem = new Memory(); // Line 4
        mem.foo(obj); // Line 5
    } // Line 9

    private void foo(Object param) { // Line 6
        String str = param.toString(); //// Line 7
        System.out.println(str);
    } // Line 8
}
