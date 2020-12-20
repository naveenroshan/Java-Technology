package Loops;

import java.util.Scanner;

public class three
{
	public static void main(String[] args) 
	{
		//get input for finding prime number
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to form shape");
		int x = sc.nextInt();
		
		//display char using AscII convertion
		for(int i=97; i<=x+97; i++)
		{
			for(int j=97; j<=i; j++)
			{
				System.out.print((char)i);
			}
			System.out.println();
		}
	}

}
