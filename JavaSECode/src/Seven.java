package Loops;

import java.util.Scanner;

public class Seven
{
	public static void main(String[] args) 
	{
		//get input for finding prime number
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the word to low,hig,digit,special");
		String s =sc.nextLine();
		int uc=0;
		int lc=0;
		int dc=0;
		int scc=0;
		
		//display
		for(int i=0; i<s.length();i++)
		{
			char x=s.charAt(i);
			if(x>=65 && x<=90)
			{
				uc =uc+1;
			}
			else if(x>=97 && x<=122)
			{
				lc=lc+1;
			}
			else if(x>=48 && x<=57)
			{
				dc =dc+1;
			}
			else
			{
				scc=scc+1;
			}
		}
		System.out.println("upper case: "+uc);
		System.out.println("lower case: "+lc);
		System.out.println("digits: "+dc);
		System.out.println("special char: "+scc);
		}
}
