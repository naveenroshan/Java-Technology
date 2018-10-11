package SECode;
/**
*
* @author Naveen
*/

// this class is used to explain the recursion .
public class RecTest {
	int values[];

	// we are here make a construtor to create a space in array.
	RecTest(int i) {
		values = new int[i];
	}

	// display array -- recursively
	void printArray(int i) {
		if (i == 0)
			return;
		else
			printArray(i - 1);
		System.out.println("[" + (i - 1) + "] " + values[i - 1]);
	}

	public static void main(String[] args) {
		RecTest ob = new RecTest(10);
		int i;
		// here we use for loop to change the value to array.
		for (i = 0; i < 10; i++) // 0,1,2,3,4,5,6,7,8,9.
			ob.values[i] = i;
		
		// here we are calling the print method. by passing the no of item to be printed by giving a argument to method
		ob.printArray(10);
	}
}
