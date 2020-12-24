package lambda.Expressions;
/**
*
* @author Naveen
*/

//Use a generic functional interface with lambda expressions

//this class implements the Generic functional interface used by lambda expression .
public interface SomeFunc<T> {
    T func(T t);
}
