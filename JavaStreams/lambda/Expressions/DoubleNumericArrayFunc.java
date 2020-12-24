package lambda.Expressions;
/**
*
* @author Naveen
*/

//linked class is EmptyArrayException and the interface is LambdaExceptionDemo
//Throw an exception from a lambda expression.

public interface DoubleNumericArrayFunc {
    double func(double[] n) throws EmptyArrayException; // function interface with throws clause added.
}
