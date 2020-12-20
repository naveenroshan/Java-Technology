package SECode;

/**
 *
 * @author Naveen
 */

// this program explains the working java stack and heap memory allocation. with below para explain all.
public class HeapStackMemoryAllocation {

	public static void main(String[] args) {
		int i = 1; // Line 2
		Object obj = new Object(); // Line 3
		HeapStackMemoryAllocation mem = new HeapStackMemoryAllocation(); // Line 4
		mem.foo(obj); // Line 5
	} // Line 9

	private void foo(Object param) { // Line 6
		String str = param.toString(); //// Line 7
		System.out.println(str);
	} // Line 8
}
/*----------------------------------------------------------------------------------------------------------
Let’s go through the steps of execution of the program.

As soon as we run the program, it loads all the Runtime classes into the Heap space. When main() method is found at line 1, Java Runtime creates stack memory to be used by main() method thread.

We are creating primitive local variable at line 2, so it’s created and stored in the stack memory of main() method.

Since we are creating an Object in line 3, it’s created in Heap memory and stack memory contains the reference for it. Similar process occurs when we create Memory object in line 4.

Now when we call foo() method in line 5, a block in the top of the stack is created to be used by foo() method. Since Java is pass by value, a new reference to Object is created in the foo() stack block in line 6.

A string is created in line 7, it goes in the String Pool in the heap space and a reference is created in the foo() stack space for it.

foo() method is terminated in line 8, at this time memory block allocated for foo() in stack becomes free.

In line 9, main() method terminates and the stack memory created for main() method is destroyed. Also the program ends at this line, hence Java Runtime frees all the memory and end the execution of the program.*/

















