package design.patterns.factor.method;
/**
*
* @author Naveen
*/

//this class use the lambda expression with design patterns factor method

// linked class Myclas , Myclass2, ConstructorRefDemo3

//this is the interface of generic type.
public interface MyFunc<R,T> {
    //this is the R type generic method used in the function interface for lambda exprestion.
    R func(T n);
}
