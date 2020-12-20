package lambda.Expressions;
/**
*
* @author Naveen
*/

//linked class are MyClassGenericConstructorReference and interface MyFuncGenericConstructorReference

//Demonstrate a Constructor reference by using Generic class
public class ConstructorRefDemoGeneric {
    public static void main(String args[]) {
      
        // Create a reference to the MyClass<T> constructor.
        MyFuncGenericConstructorReference<Integer> myClassCons = MyClassGenericConstructorReference <Integer> :: new;
       
        // Create an instance of MyClass<T> via that constructor reference.
        MyClassGenericConstructorReference <Integer> mc = myClassCons.func(100);
       
        // Use the instance of MyClass<T> just created.
        System.out.println("val in mc is " + mc.getVal());
    }
}
