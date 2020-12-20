package SECode;

/**
 *
 * @author Naveen
 */
// this program explains the concept of inner classes
public class OuterClass {
    public interface Command {
        public void execute(Object data);
    }

    // this is the inner class
    public class InnerClass implements Command {
        public void execute(Object data) {
            System.out.println(data.toString());
        }
    }

    public static void callCommand(Command command, Object data) {
        command.execute(data);
    }

    public static void main(String... args) {
        // we have to create outer class instance to accesses the inner class members,this is the
        // part of inner classes.
        OuterClass obj = new OuterClass();
        OuterClass.InnerClass innerobj = obj.new InnerClass();// here we are creating the instance of inner classs.
        callCommand(innerobj, "hello world");
    }
}
