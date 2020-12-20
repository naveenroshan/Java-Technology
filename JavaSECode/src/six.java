package Loops;

import java.util.Scanner;

public class six
{
	public static void main(String[] args) 
	{
		//get input for finding prime number
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word to find unique char cocurrences");
		String s =sc.nextLine();
		s=s.toLowerCase();
		String u ="";
		
		//display
		for(int i=0; i<s.length(); i++)
		{
			char x =s.charAt(i);
			int c=0;
			for(int j=0; j<1; j++)
			{
				char y=s.charAt(j);
				if(x==y)
				{
					c=c+1;
				}
			}
			if(c==0)
			{
				u=u+x;
			}
		}
		for(int i=0; i<s.length();i++)
		{
			char x=s.charAt(i);
			int c=0;
			for(int j=0; j<1; j++)
			{
				char y=s.charAt(j);
				if(x==y)
				{
					c=c+1;
				}
			}
			if(c==0)
			{
				u=u+x;
			}
		}
		for(int i=0; i<u.length();i++)
		{
			int c=0;
			char x =u.charAt(i);
			for(int j=0; j<s.length(); j++)
			{
				char y=s.charAt(j);
				if(x==y)
				{
					c=c+1;
				}
			}
			System.err.println(x+" come "+c+" time :");
		}
	}
}
