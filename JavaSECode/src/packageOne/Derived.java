package packageOne;
/**
*
* @author Naveen
*/
//banch of package and classes are used to understand access modifiers.
public class Derived extends Protection {
 // this class can access the all the Protection except n_pri variable
    Derived() {
	System.out.println("derived constructor");
	System.out.println("n = " + n);
	// class only
	// System.out.println("n_pri = "4 + n_pri);
	System.out.println("n_pro = " + n_pro);
	System.out.println("n_pub = " + n_pub);
    }
}
