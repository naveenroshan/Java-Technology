package collection.Framework;
/**
*
* @author Naveen
*/
//Use a custom comparator.
import java.util.Comparator;

//The following is an example that demonstrates the power of a custom comparator. It
//implements the compare( ) method for strings that operates in reverse of normal. Thus,
//it causes a tree set to be sorted in reverse order.
public class MyComp implements Comparator<String> {
    
    public int compare(String aStr, String bStr) {
        // Reverse the comparison.
        return aStr.compareTo(bStr);
    }
    // No need to override equals or the default methods.
}
