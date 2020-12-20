package Main.Libaries;
/**
 *
 * @author Naveen
 */

//the linked class is BeingWatched and Watcher
public class ObserverDemo {
    public static void main(String args[]) {
        BeingWatched observed = new BeingWatched();
        Watcher observing = new Watcher();

        // Add the observing to the list of observers for observed object.
        observed.addObserver(observing);
        observed.counter(10);
    }
}
