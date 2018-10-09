package SECode;
/**
*
* @author Naveen
*/

//This class defines an integer stack that can hold 10 values and this test class for this method is TestStackImplementation

public class StackImplementation {
	int stck[] = new int[10];
	int tos;

	// Initialize top-of-stack
	StackImplementation() {
		tos = -1;
	}

	// Push an item onto the stack
	void push(int item) {
		if (tos == 9)
			System.out.println("Stack is full.");
		else
			stck[++tos] = item;
	}

	// Pop an item from the stack
	int pop() {
		if (tos < 0) {
			System.out.println("Stack underflow.");
			return 0;
		} else
			return stck[tos--];
	}
}
