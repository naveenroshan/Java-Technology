package generic.Class.Hierarchies;
/**
*
* @author Naveen
*/

//Runner class for the Gen and Gen2 classes.
public class Main {

    public static void main(String[] args) {
       // Create a Gen object for String.
        Gen2<String> w = new Gen2<String>("Hello", 47);
        System.out.print(w.getob() + " ");
        System.out.println(w.getnum());

    }

}
