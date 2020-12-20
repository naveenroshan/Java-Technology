package Main.Libaries;

import java.util.Optional;

/**
 *
 * @author Naveen
 */

//Here is an example that demonstrates Optional class and it methodes :
public class OptionalDemo {
    public static void main(String args[]) {
        Optional<String> noVal = Optional.empty();
        Optional<String> hasVal = Optional.of("ABCDEFG");
        if(noVal.isPresent())
            System.out.println("This won't be displayed");
        else
            System.out.println("noVal has no value");
        if(hasVal.isPresent())
            System.out.println("The string in hasVal is: " + hasVal.get());
        String defStr = noVal.orElse("Default String-ABCDEFG");
        System.out.println(defStr);
    }
}
