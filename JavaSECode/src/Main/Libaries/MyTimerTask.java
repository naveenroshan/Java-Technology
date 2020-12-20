package Main.Libaries;

import java.util.TimerTask;

/**
 *
 * @author Naveen
 */

// Demonstrate Timer and TimerTask.
    //linked class is TimeTestDemo
public class MyTimerTask extends TimerTask {
    public void run() {
        System.out.println("Timer task executed.");
    }
}