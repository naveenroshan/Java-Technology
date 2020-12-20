package corejavaone;

import java.util.Scanner;

public class PrimeNumber
{
	public static void main(String args[])
	{
		 int i,m=0,flag=0;
		 Scanner sc=new Scanner(System.in); 
		 System.out.println("entern the number");
		 
		 int n=sc.nextInt();    //it is the number to be checked  
		 m=n/2;
		 //System.out.println(m);
		  for(i=2; i<=m; i++)
		  {
			  System.out.println(n%i);
			  if(n%i==0)
			  {
				   System.out.println("Number is not prime");    
				   flag=1;    
				   break;    
			   }    
		  }    
			  if(flag==0)    
			       System.out.println("Number is prime");    
	}  
} 