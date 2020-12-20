package mindqsystems;
import java.util.Scanner;

public class stringoperation 
{
	public static void main(String[] args) 
	{
		// get the input from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the sentance");
		String x =sc.nextLine();
		System.out.println("enter the word");
		String y =sc.nextLine();
		x=x.toLowerCase();
		y=y.toLowerCase();

		//split
		String z[] = x.split(" ");
		int count=0;
		for( int i=0; i<z.length; i++)
		{
			if(z[i].equals(y))
			{
				count = count+1;
			}
		}
System.out.println(count);
	}
}
