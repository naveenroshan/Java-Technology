package lambda.Expressions;
/**
*
* @author Naveen
*/

//Demonstrate a method reference for a static method

//this class is linked with the interface StringFuncMethodReferences1 and class MethodRefDemo1
public class MyStringOpsMethodReferences1 {
    
    // A static method that reverses a string.
    static String strReverse(String str) {
        String result = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }
}
