package lambda.Expressions;
/**
*
* @author Naveen
*/

//linked class are MyClassConstructorReferences and ConstructorReferencesDemo

//Demonstrate a Constructor reference.
//MyFunc is a functional interface whose method returns
//a MyClass reference.
public interface MyFuncConstructorReferences {
    
    MyClassConstructorReferences func(int n);
}
