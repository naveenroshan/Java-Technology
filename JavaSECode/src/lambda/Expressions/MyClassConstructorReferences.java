package lambda.Expressions;
/**
*
* @author Naveen
*/

//linked interface is MyFuncConstructorReferences and class ConstructorReferencesDemo

//Demonstrate a Constructor reference.
public class MyClassConstructorReferences {
    private int val;

    // This constructor takes an argument.
    MyClassConstructorReferences(int v) {
        val = v;
    }

    // This is the default constructor.
    MyClassConstructorReferences() {
        val = 0;
    }

    // RETURNS THE val from the constructor.
    int getVal() {
        return val;
    };
}
