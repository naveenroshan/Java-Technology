package SECode;
/**
*
* @author Naveen
*/

//here we are working on the enum examples.

public enum Level {

	HIGH(2), MEDIUM(5), LOW(8);
	
		
	//Enum Fields
	private int  levelvalue;
	
	
	// to access the enum contants value we need to use the constructor 
	// You cannot use public or protected constructors for a Java enum.
	private Level(int levelvalue)
	{
		this.levelvalue = levelvalue;
	}
	
	//Enum Methods
	// to access the enum value we need to write an method
	
	public int getlevelvalue()
	{
		return this.levelvalue;
	}
}
	
	
	