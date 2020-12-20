package SECode;
/**
*
* @author Naveen
*/

// test class for the class StackImplementation
public class TestStackImplementation {

	public static void main(String[] args) {
		StackImplementation mystack1 = new StackImplementation();
		StackImplementation mystack2 = new StackImplementation();

		// push some numbers onto the stack
		for (int i = 0; i < 10; i++) // 0 1 2 3 4 5 6 7 8 9
			mystack1.push(i);
		for (int i = 10; i < 20; i++) // 10 11 12 13 14 15 16 17 18 19
			mystack2.push(i);

		// pop those numbers off the stack
		System.out.println("Stack in mystack1:");
		for (int i = 0; i < 10; i++)
			System.out.println(mystack1.pop());
		System.out.println("Stack in mystack2:");
		for (int i = 0; i < 10; i++)
			System.out.println(mystack2.pop());
	}
}
