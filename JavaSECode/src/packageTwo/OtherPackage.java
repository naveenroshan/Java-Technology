package packageTwo;
/**
*
* @author Naveen
*/
//banch of package and classes are used to understand access modifiers.
public class OtherPackage {
    OtherPackage() {
	packageOne.Protection p = new packageOne.Protection();
	System.out.println("other package constructor");
	// class or package only
	// System.out.println("n = " + p.n); this will give error because it is default access member
	// class only
	// System.out.println("n_pri = " + p.n_pri); this will give error because it is private access member
	// class, subclass or package only
	// System.out.println("n_pro = " + p.n_pro); this will give error because it is protected access member
	System.out.println("n_pub = " + p.n_pub);
	}

}
