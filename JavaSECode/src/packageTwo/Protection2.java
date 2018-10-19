package packageTwo;
/**
*
* @author Naveen
*/
//banch of package and classes are used to understand access modifiers.
public class Protection2 extends packageOne.Protection {
    Protection2() {
	System.out.println("derived other package constructor");
	// class or package only
	// System.out.println("n = " + n);  // this will give error because it is default access member
	// class only
	// System.out.println("n_pri = " + n_pri); // this will give error because it is private access member	
	System.out.println("n_pro = " + n_pro);
	System.out.println("n_pub = " + n_pub);
    }
}
