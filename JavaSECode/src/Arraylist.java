package mindqsystems;
import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist
{
	public static void main(String[] args) 
	{
		//get data from keyboard
		Scanner sc = new Scanner(System.in);	    
	    ArrayList<Integer> a = new ArrayList<Integer>();
	    int x =sc.nextInt();
		for(int i=0; i<x; i++)
	    {
	    	System.out.println("enter the number");
	    	a.add(sc.nextInt());
	    }
		
		//sorting
		for(int i=0; i<x; i++)
		{
			for(int j=0; j<x-1; j++)
			{
				if(a.get(j)>a.get(j+1))
				{
					int temp =a.get(j);
					a.set(j,a.get(j+1));
					a.set(j+1,temp);
				}
			}
		}
		
		//display
		for(int i=0; i<x; i++)
		{
			System.out.print(a.get(i)+" ");
		}
		System.out.println("min value: "+a.get(0));
		System.out.println("max value: "+a.get(x-1));
		}
}
