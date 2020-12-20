package design.patterns.factor.method;
/**
*
* @author Naveen
*/

//this class use the lambda expression with design patterns factor method

// linked class Myclas ,ConstructorRefDemo3 and  interface Myfunc
public class MyClass2 {
    String str;

    // A constructor that takes an argument.
    MyClass2(String s) {
        str = s;
    }

    // The default constructor. This
    // constructor is NOT used by this program.
    MyClass2() {
        str = "";
    }

    // this is return type of the str from the construtor.
    String getVal() {
        return str;
    };
}
