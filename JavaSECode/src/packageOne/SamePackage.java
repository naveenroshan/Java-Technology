package packageOne;
/**
*
* @author Naveen
*/
//banch of package and classes are used to understand access modifiers.
public class SamePackage {
    // this class can access the all the Protection except n_pri variable
    
    SamePackage() {
	Protection p = new Protection();
	System.out.println("same package constructor");
	System.out.println("n = " + p.n);
	// class only
	// System.out.println("n_pri = " + p.n_pri);
	System.out.println("n_pro = " + p.n_pro);
	System.out.println("n_pub = " + p.n_pub);
    }
}
