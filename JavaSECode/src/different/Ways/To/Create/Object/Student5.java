package different.Ways.To.Create.Object;
/**
*
* @author Naveen
*/
//here we learn differenr ways to create an object.
//code explained here --> URL : https://dzone.com/articles/what-are-all-the-different-ways-to-create-an-objec

public class Student5 implements Cloneable {
    private String name;
    private String college;
    public Student5() {
        super();
    }
    public Student5(String name, String college) {
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
    public static void main(String args[]) {
        Student5 student1 = new Student5("Ramesh", "ABC");
        try {
            Student5 student2 = (Student5) student1.clone();
            System.out.println(student2.getName());
            System.out.println(student2.getCollege());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
