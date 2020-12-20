package lambda.Expressions;
/**
 *
 * @author Naveen
 */

// Use an instance method reference with different objects

// A class that stores the temperature high for a day.

// the linked class InstanceMethWithObjectRefDemo and interface are MyFuncInstancemethodreference
public class HighTempInstancemethodreference {
    private int hTemp;

    HighTempInstancemethodreference(int ht) {
        hTemp = ht;
    }

    // Return true if the invoking HighTemp object has the same temperature as ht2.
    boolean sameTemp(HighTempInstancemethodreference ht2) {
        return hTemp == ht2.hTemp;
    }

    // Return true if the invoking HighTemp object has a temperature that is less than ht2.
    boolean lessThanTemp(HighTempInstancemethodreference ht2) {
        return hTemp < ht2.hTemp;
    }
}
