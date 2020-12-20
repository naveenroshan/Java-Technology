package lambda.Expressions;
/**
*
* @author Naveen
*/

//we have to use functional interface type interface for lambda expression implementation otherwise we will get error.

/*A functional interface is an interface that contains only one abstract method. They can have only one functionality to exhibit. 
From Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface.*/

public interface MyNumber {
    double getValue();
}
