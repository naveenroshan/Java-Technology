package lambda.Expressions;
/**
*
* @author Naveen
*/

//linked interface is MyFuncConstructorReferences and class MyClassConstructorReferences

//Demonstrate a Constructor reference.
public class ConstructorReferencesDemo {
    public static void main(String args[]) {
        
        // Create a reference to the MyClass constructor.
        // Because func() in MyFunc takes an argument, 
        // new refers to the parameterized constructor in MyClass,
        // not the default constructor.
        MyFuncConstructorReferences myClassCons = MyClassConstructorReferences :: new; //the expression MyClassConstructorReferences::new creates a constructor reference to a MyClassConstructorReferences constructor
        
        // Create an instance of MyClass via that constructor reference.
        MyClassConstructorReferences mc = myClassCons.func(100);
       
        // Use the instance of MyClass just created.
        System.out.println("val in mc is " + mc.getVal());
    }
}
