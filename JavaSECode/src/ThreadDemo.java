package SECode;
/**
*
* @author Naveen
*/
//this class is used to explain the concept of multithreading programming
public class ThreadDemo {

	public static void main(String [ ] args) {
		new NewThread("one"); // create a new thread
		new NewThread("two");
		new NewThread("three");
		try {
			for (int i = 3; i > 0; i--) {
				System.out.println("Main Thread: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted.");
		}
		System.out.println("Main thread exiting.");
	}
}
