package Main.Libaries;
/**
 *
 * @author Naveen
 */
import java.util.*;

//linked class is Watcher and ObserverDemo
public class BeingWatched extends Observable {

    void counter(int period) {
        for( ; period >=0; period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                System.out.println("Sleep interrupted");
            }
        }
    }
}
