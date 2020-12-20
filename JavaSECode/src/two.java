package Loops;

import java.util.Scanner;

public class two
{
	public static void main(String[] args) 
	{
		//get input for finding prime number
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the number to form shape");
				int x = sc.nextInt();
				
		//display shape
				for(int i=1; i<=x; i++)
				{
					for(int j=1; j<=i; j++)
					{
						System.out.print(i+ " ");
					}
					System.out.println();
				}
					}
}