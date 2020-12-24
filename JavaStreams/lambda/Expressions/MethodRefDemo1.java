package lambda.Expressions;
/**
*
* @author Naveen
*/

//Demonstrate a method reference for a static method

// this class is linked with the class MyStringOpsMethodReferences1 and interface StringFuncMethodReferences1
public class MethodRefDemo1 {

    // This method has a functional interface as the type of
    // its first parameter. Thus, it can be passed any instance
    // of that interface, including a method reference.
    static String stringOp(StringFuncMethodReferences1 sf, String s) {
        return sf.func(s);
    }

    public static void main(String[] args) {
        String inStr = "Lambdas add power to Java";
        String outStr;
        
        // Here, a method reference to strReverse is passed to stringOp().
        
        outStr = stringOp(MyStringOpsMethodReferences1::strReverse, inStr);
        
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}
