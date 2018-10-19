// Demo package packageOne.
package packageOne;
/**
*
* @author Naveen
*/
//banch of package and classes are used to understand access modifiers.
//Instantiate the various classes in p1.
public class Demo {
	public static void main(String args[]) {
	    Protection ob1 = new Protection();
	    Derived ob2 = new Derived();
	    SamePackage ob3 = new SamePackage();
	    System.out.println(ob1.n);
	    System.out.println(ob2.n);
	        }
    }

