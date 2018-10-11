package SECode;

/**
 *
 * @author Naveen
 */

//this is class enum to work with Level enum.
// this is the test run class
public class ClassEnum {

	public static void main(String[] args) {
		// refering the enum in the class
		Level level = Level.HIGH;

		// Enums in if Statements
		if (level == Level.HIGH) {
			System.out.println("hight");
		}

		// Enums in switch Statements
		switch (level) {
		case HIGH:
			System.out.println("high is printed");
			break;
		case MEDIUM:
			System.out.println("medium is printed");
			break;
		case LOW:
			System.out.println("low is printed");
			break;

			// Enum Iteration

			/*
			 * for(Level level :Level.values()) { System.out.println(level); }
			 */

			/*
			 * //Enum valueOf() Level level = Level.valueOf("HIGH");
			 */

			// calling the enum get value methode

		//	System.out.println(level.getlevelvalue());

		}

	}

}
