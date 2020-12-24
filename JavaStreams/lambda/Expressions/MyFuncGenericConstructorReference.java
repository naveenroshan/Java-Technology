package lambda.Expressions;
/**
*
* @author Naveen
*/

//linked class are MyClassConstructorReferences and ConstructorReferencesDemo

//MyFunc is now a generic functional interface
//Demonstrate a Constructor reference by using Generic class
public interface MyFuncGenericConstructorReference<T> {
    MyClassGenericConstructorReference<T> func(T n);
}
