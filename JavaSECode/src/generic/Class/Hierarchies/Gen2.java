package generic.Class.Hierarchies;
/**
*
* @author Naveen
*/

//this is the generic type subclass of Gen class  
public class Gen2<T> extends Gen {
    T ob; // declare an object of type T

    // Pass the constructor a reference to an object of type T.

    Gen2(T o, int i) {
        super(i);
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }
}
