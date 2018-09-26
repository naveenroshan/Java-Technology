package SECode;
/**
*
* @author Naveen
*/

/*here we use the static key word for the variables to become class member so no need for creating objects.
so we can call it directly from any were in the this class level.*/

public class learnthecode {
	
	//String g = "string out put";
	
	static 	String g = "string out put";

	public static void main(String[] args) {
		//learnthecode call = new learnthecode();
		//String m = call.g;
		String m = g;
		System.out.println(m);
	}
}
