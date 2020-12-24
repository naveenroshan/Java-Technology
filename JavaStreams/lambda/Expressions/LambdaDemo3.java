package lambda.Expressions;
/**
*
* @author Naveen
*/

//this class implements the functional interface NumberTest2
public class LambdaDemo3 {

    public static void main(String[] args) {
     // This lambda expression determines if one number is a factor of another.
        NumericTest2 isFactor;
       
        isFactor = (n, d) -> (n % d) == 0; // here we are using the reference to execute the lambda expression
        
        if(isFactor.test(10, 2))
        System.out.println("2 is a factor of 10");
        
        if(!isFactor.test(10, 3))
        System.out.println("3 is not a factor of 10");
    }
}
