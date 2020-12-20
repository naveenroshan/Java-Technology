package Loops;

import java.util.Scanner;

public class Four 
{
	public static void main(String[] args)
	{
		//get input for finding prime number
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the number to form shape");
				int x = sc.nextInt();
				
          int d=1,c=97;
          for(int i=1; i<=x; i++)
          {
        	  for(int j=1; j<=i; j++)
        	  {
        		  System.out.print(d+" ");
        	  }
        	  d=d+1;
        	  System.out.println();
        	  for(int k=1; k<=i; k++)
        	  {
        		  System.out.print((char)c+ " ");
        	  }
        	  c=c+1;
        	  System.out.println();
         }
	}
}
