package different.Ways.To.Create.Object;
/**
*
* @author Naveen
*/
//here we learn differenr ways to create an object.
//code explained here --> URL : https://dzone.com/articles/what-are-all-the-different-ways-to-create-an-objec

//linked class student4
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Student4Demo {
    public static void main(String[] args) {
        
        // Path to store the Serialized object
        String filePath = "sample.txt";
        Student4 s1 = new Student4("Ramesh", "ABC");
        
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(s1);
            outputStream.flush();
            outputStream.close();
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            Student4 s2 = (Student4) inputStream.readObject();
            inputStream.close();
            System.out.println(s2.getName());
            System.out.println(s2.getCollege());
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }
}
