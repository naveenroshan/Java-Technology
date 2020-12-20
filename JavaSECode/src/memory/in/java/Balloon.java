package memory.in.java;
/**
*
* @author Naveen
*/

// linked class is TestBallon
//code explained here https://www.journaldev.com/3884/java-is-pass-by-value-and-not-pass-by-reference
public class Balloon {
    private String color;
   
    public Balloon(String c){
        this.color=c;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
