package memory.in.java;
/**
*
* @author Naveen
*/
// linked class is Balloon.
public class TestBalloon {

    private static void foo(Balloon objectballoon) { // baloon=100
        objectballoon.setColor("Red"); // baloon=100

        objectballoon = new Balloon("Green"); // baloon=200//we are creating new object
        objectballoon.setColor("Blue"); // baloon = 200
    }

    // Generic swap method
    public static void swap(Object o1, Object o2) { //o1=50, o2=100
        Object temp = o1;// now temp is RED  //temp=50, o1=50, o2=100
        o1 = o2;//now o1 is BLUE  //temp=50, o1=100, o2=100
        o2 = temp;// noew o2 is RED  //temp=50, o1=100, o2=50
    }

    public static void main(String[] args) {

        Balloon red = new Balloon("Red"); // memory reference 50
        Balloon blue = new Balloon("Blue"); // memory reference 100

        swap(red, blue);
        System.out.println("red color=" + red.getColor());
        System.out.println("blue color=" + blue.getColor());

        System.out.println();
        
        foo(blue);
        System.out.println("blue color=" + blue.getColor());
    }
}
