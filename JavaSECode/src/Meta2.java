package SECode;
import java.lang.annotation.*;
import java.lang.reflect.*;
/**
 *
 * @author Naveen
 */


// creating the metedata by specifing the control policy has RUNTIME.
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
    String str();
    int val();
}
// creating the metedata by specifing the control policy has RUNTIME.
@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}
//assessing vallue to the metedata to the method "what" and "MyAnno".
@What(description = "An annotation test class")
@MyAnno(str = "Meta2", val = 99)

public class Meta2 {
    @What(description = "An annotation test method")
    @MyAnno(str = "Testing", val = 100)

    public static void myMeth() {
        Meta2 ob = new Meta2();
        try {
            // below step used to get class value has array
            Annotation annos[] = ob.getClass().getAnnotations();
// Display all annotations for Meta2.
            System.out.println("All annotations for Meta2:");
            //this step cycle through the array.
            for (Annotation a : annos)
                System.out.println(a);
            System.out.println();
// Display all annotations for myMeth.
            // below step used to get method value has array
            Method m = ob.getClass().getMethod("myMeth");
            annos = m.getAnnotations();
            System.out.println("All annotations for myMeth:");
            for (Annotation a : annos)
                System.out.println(a);
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
}
