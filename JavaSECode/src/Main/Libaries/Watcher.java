package Main.Libaries;
/**
 *
 * @author Naveen
 */
import java.util.*;
/* Demonstrate the Observable class and the
Observer interface.
*/
//linked class is BeingWatched and Observer.
// This is the observing class.
public class Watcher implements Observer {
    public void update(Observable obj, Object arg) {
        System.out.println("update() called, count is " + arg);
    }
}

