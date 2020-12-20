package Main.Libaries;

import java.util.Currency;
import java.util.Locale;

/**
 *
 * @author Naveen
 */


// Demonstrate Currency.
public class CurrrencyDemo {
    public static void main(String args[]) {
        Currency c;
        c = Currency.getInstance(Locale.UK);
        System.out.println("Symbol: " + c.getSymbol());
        System.out.println("Default fractional digits: " + c.getDefaultFractionDigits());
    }
}
