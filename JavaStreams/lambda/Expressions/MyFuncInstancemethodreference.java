package lambda.Expressions;
/**
*
* @author Naveen
*/

//Use an instance method reference with different objects.

//A functional interface that takes two reference arguments
//and returns a boolean result.

// the linked class are HighTempInstancemethodreference and InstanceMethWithObjectRefDemo.
public interface MyFuncInstancemethodreference<T> {
    boolean func(T v1, T v2);
}
