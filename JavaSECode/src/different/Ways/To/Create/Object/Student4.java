package different.Ways.To.Create.Object;
/**
*
* @author Naveen
*/
//here we learn differenr ways to create an object.
//code explained here --> URL : https://dzone.com/articles/what-are-all-the-different-ways-to-create-an-objec

//linked class student4Demo

import java.io.Serializable;

public class Student4 implements Serializable {
    private String name;
    private String college;

    public Student4() {
     super();
    }

    public Student4(String name, String college) {
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
}
