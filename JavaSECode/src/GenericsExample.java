package SECode;
/**
 *
 * @author Naveen
 */
// this program explains the Generic in java
// A simple generic class.
// Here, T is a type parameter that
// will be replaced by a real type
// when an object of type Gen is created.
public class GenericsExample <T> {
    T ob; // declare an object of type T

    // Pass the constructor a reference to
    // an object of type T.
    GenericsExample(T o) {
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }

    // Show type of T.
    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

