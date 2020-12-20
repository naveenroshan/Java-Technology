package design.patterns.factor.method;
/**
*
* @author Naveen
*/

//this class use the lambda expression with design patterns factor method

// linked class Myclass2, ConstructorRefDemo3 and interface Myfunc
public class MyClass<T> {
    private T val;

    // A constructor that takes an argument.
    MyClass(T v) {
        val = v;
    }

    // The default constructor. This constructor
    // is NOT used by this program.
    MyClass() {
        val = null;
    }

    // returns the T type data type of val from the constructor
    T getVal() {
        return val;
    };
}
