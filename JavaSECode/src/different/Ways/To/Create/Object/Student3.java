package different.Ways.To.Create.Object;
/**
*
* @author Naveen
*/
//here we learn differenr ways to create an object.
//code explained here --> URL : https://dzone.com/articles/what-are-all-the-different-ways-to-create-an-objec

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Student3 {
    private String name = "Ramesh";
    private String college = "ABC";
    public Student3() {
        super();
    }
    public Student3(String name, String college) {
        super();
        this.name = name;
        this.college = college;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public static void main(String args[]) throws Throwable {
        Constructor < Student3 > constructor;
        try {
            constructor = Student3.class.getConstructor();
            Student3 student = constructor.newInstance();
            System.out.println(student.getName());
            System.out.println(student.getCollege());
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException |
            NoSuchMethodException | SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
