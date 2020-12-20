package mindqsystems;

public class HAS_A_relationclass2
{
	//member of HAS_A_relation has object in HAS_A_relationclass2
	public HAS_A_relation obj1;
	
	public HAS_A_relationclass2()
	{
	obj1=new HAS_A_relation();
	}
	
	public void dispplay()
	{
		System.out.println(obj1.x);
	}
}
