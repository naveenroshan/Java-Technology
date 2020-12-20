package mindqsystems;

public class Runnerclasssingleton
{
	public static void main(String[] args) 
	{
		Example7singletonclass obj1 = Example7singletonclass.create();
		obj1.display();
		
		//or
		
		Example7singletonclass.create().display();

	}

}
