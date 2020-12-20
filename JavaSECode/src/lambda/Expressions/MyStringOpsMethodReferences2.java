package lambda.Expressions;
/**
*
* @author Naveen
*/

//Demonstrate a method reference for a instance method

//Now, this class defines an instance method called strReverse().

//this class is linked with the interface StringFuncMethodReferences2 and class MethodRefDemo2
class MyStringOpsMethodReferences2 {

    // A static method that reverses a string.
    String strReverse(String str) {
        String result = "";
        int i;
        for (i = str.length() - 1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }
}