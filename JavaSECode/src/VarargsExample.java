package SECode;

/**
 *
 * @author Naveen
 */

// this class explains the use of var char that help us to use more no of argument to a method.
public class VarargsExample {
	static void vaTest(int... v) {
		System.out.print("Number of args: " + v.length + " Contents: ");
		for (int x : v)
			System.out.print(x + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		// Notice how an array must be created to
		// hold the arguments.
		int n1[] = { 10 };
		int n2[] = { 1, 2, 3 };
		int n3[] = {};
		vaTest(n1); // 1 arg
		vaTest(n2); // 3 args
		vaTest(n3); // no args
	}
}
