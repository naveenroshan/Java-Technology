package SECode;

/**
 *
 * @author Naveen
 */

//construtor example
public class Construtor {

	private String firstName = null;
	private String lastName = null;
	private int birthYear = 0;

	// creating no parametaried construtor
	public Construtor() {

	}

	public Construtor(String firstName, String lastName, int birthYear) {

		firstName = firstName; // here the default value is comming
		lastName = lastName; // here the default vlue is coming
		this.birthYear = birthYear;// here we can give our value in object creation example "2".
	}

	public static void main(String[] args) {

		Construtor calll = new Construtor();// we are calling no argumented Construtor
		Construtor call = new Construtor("qw", "qw", 2); // out put of the birth day is 2 not has 0 beacuse we use the// this keyworld.
															
		System.out.println(calll.toString());
		System.out.println(call.firstName);
		System.out.println(call.birthYear);
		System.out.println(call.lastName);
	}

}
