package different.Ways.To.Create.Object;
/**
*
* @author Naveen
*/

//here we learn differenr ways to create an object.
//code explained here --> URL : https://dzone.com/articles/what-are-all-the-different-ways-to-create-an-objec

public class Student {
    
    private String name = "Ramesh";
    private String college = "ABC";
   
    public Student() {
        super();
    }
    
    public Student(String name, String college) {
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
   
    public static void main(String[] args) throws Throwable {        
        Student student = new Student("Ramesh", "BVB");
        Student student2 = new Student("Prakash", "GEC");
        Student student3 = new Student("Pramod", "IIT");
        System.out.println(student.getName());
        System.out.println(student2.getName());
        System.out.println(student3.getName());
        System.out.println(student.getCollege());
        System.out.println(student2.getCollege());
        System.out.println(student3.getCollege());
    }
}
