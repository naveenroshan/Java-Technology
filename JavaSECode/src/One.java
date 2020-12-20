package Loops;

import java.util.Scanner;

public class One
{
	public static void main(String[] args) 
	{
	    //get input for finding prime number
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to find prime");
		int x = sc.nextInt();
			
		//display number
		for(int n=1; n<=x; n++)
		{
			int flag =0;
			for(int i=2; i<n; i++)
			{
				if(n%i==0)
				{
					flag=1;
				}
			}
			if(flag==0)
			{
				System.out.println(n+" ");
			}
		}
    }
}
