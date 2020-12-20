package lambda.Expressions;
/**
*
* @author Naveen
*/

//this class implements the functional interface NumberTest
public class LambdaDemo2 {

    public static void main(String[] args) {
     // A lambda expression that tests if a number is even.
        NumericTest isEven;
        
        isEven = (int n) -> (n % 2) == 0; // lambda expression one,  here we are using the reference to execute the lambda expression 
       
        if (isEven.test(10))
            System.out.println("10 is even");
        
        if (!isEven.test(9))
            System.out.println("9 is not even");

        // Now, use a lambda expression that tests if a number is non-negative.
        NumericTest isNonNeg;
        
        isNonNeg = (int n) -> n >= 0; // lambda expression two, here we are using the reference to execute the lambda expression
        
        if (isNonNeg.test(1))
            System.out.println("1 is non-negative");
        
        if (!isNonNeg.test(-1))
            System.out.println("-1 is negative");

    }

}
