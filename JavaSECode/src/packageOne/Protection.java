package packageOne; 
/**
*
* @author Naveen
*/

// banch of package and classes are used to understand access modifiers.
public class Protection {
    int n = 1;                                // default access modifier
    private int n_pri = 2;                   // private access modifier
    protected int n_pro = 3;                // protected access modifier
    public int n_pub = 4;                  // public modifier

    public Protection() {
	System.out.println("base constructor");
	System.out.println("n = " + n);
	System.out.println("n_pri = " + n_pri);
	System.out.println("n_pro = " + n_pro);
	System.out.println("n_pub = " + n_pub);
    }
}                     
                                         //below table explain the access level for the class member


                                     //                                     | private|default|protected|public|
                                     //                                    ------------------------------------
                                    /* Same class                           |  Yes      Yes      Yes      Yes |
                                       Same package subclass                |  No       Yes      Yes      Yes |
                                       Same package non-subclass            |  No       Yes      Yes      Yes |
                                       Different package subclass           |  No       No       Yes      Yes |
                                       Different package non-subclass       |  No       No       No       Yes |  */