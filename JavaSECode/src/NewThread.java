package SECode;
/**
*
* @author Naveen
*/
//this class is used to explain the concept of multithreading programming
public class NewThread implements Runnable {
	Thread t;// creating the thread class reference

	NewThread(String name) {
	// Create a new, second thread
	t = new Thread(this, "Demo Thread");
	System.out.println("Child thread: " + t);
	t.start(); // Start the thread
	}

	// This is the entry point for the second thread.
	public void run() {
		try {
			for (int i = 3; i > 0; i--) {
				System.out.println("Child Thread: " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrupted.");
		}
		System.out.println("Exiting child thread.");
	}
}

