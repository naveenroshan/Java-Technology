package different.Ways.To.Create.Object;
/**
*
* @author Naveen
*/

//here we learn differenr ways to create an object.
//code explained here --> URL : https://dzone.com/articles/what-are-all-the-different-ways-to-create-an-objec

public class student2 {
    private String name = "Ramesh";
    private String college = "ABC";
    public student2() {
        super();
    }
    public student2(String name, String college) {
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
    public static void main(String[] args) {
        try {
            String className = "packageOne.student2";
            Class clasz = Class.forName(className);
            student2 student = (student2) clasz.newInstance();
            System.out.println(student.getName());
            System.out.println(student.getCollege());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
