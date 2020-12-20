package lambda.Expressions;
/**
 *
 * @author Naveen
 */

// Demonstrate a method reference for a instance method

// this class is linked with the class MyStringOpsMethodReferences2 and interface
// StringFuncMethodReferences2
public class MethodRefDemo2 {
    // This method has a functional interface as the type of
    // its first parameter. Thus, it can be passed any instance
    // of that interface, including method references.
    static String stringOp(StringFuncMethodReferences2 sf, String s) {
        return sf.func(s);
    }

    public static void main(String args[]) {
        String inStr = "Lambdas add power to Java";
        String outStr;
        
        // Create a MyStringOps object.
        MyStringOpsMethodReferences2 strOps = new  MyStringOpsMethodReferences2();
        
        // Now, a method reference to the instance method strReverse
        // is passed to stringOp().
        outStr = stringOp(  strOps::strReverse, inStr); 
        
        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);
    }
}
