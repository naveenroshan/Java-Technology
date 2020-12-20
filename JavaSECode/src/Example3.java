package mindqsystems;

public class Example3
{
	//data members
    public int x;
	public float y;
	public char z;
	public boolean w;
	public String s;
	
	//constructor methods
	public Example3()
	{
		x=10;
		s="mindq";
	}
public Example3(int a,String b)
{
	x=a;
	s=b;
}
//operational methods
		public void methods3()
		{
			System.out.println(x+" "+y+" "+z+" "+w+" "+s);
		}
}