package mindqsystems;

public class Example7singletonclass
{
	//data members
	public int x;
	public int y;
	
	//private constructor
	private Example7singletonclass()
	{
		x=10;
		y=90;
	}
	
	//static method
	public static Example7singletonclass create()
	{
		Example7singletonclass obj = new Example7singletonclass();
		return(obj);
    }
	
	//non static method
	
	public void display()
	{
		System.out.println(x+" "+y);
	}

}
