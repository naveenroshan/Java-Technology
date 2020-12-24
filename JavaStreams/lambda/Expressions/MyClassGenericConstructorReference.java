package lambda.Expressions;
/**
*
* @author Naveen
*/

//linked class ConstructorRefDemoGeneric and interface MyFuncGenericConstructorReference.

//Demonstrate a Constructor reference by using Generic class
public class MyClassGenericConstructorReference<T> {
    private T val;

    // A constructor that takes an argument.
    MyClassGenericConstructorReference(T v) {
        val = v;
    }

    // This is the default constructor.
    MyClassGenericConstructorReference() {
        val = null;
    }

    //return the val from the construtor
    T getVal() {
        return val;
    };
}
