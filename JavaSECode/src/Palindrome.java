package corejavaone;

import java.util.Scanner;

public class Palindrome
{
	public static void main(String []arg)
	{
		int r;
		int s = 0;
		int n;
		Scanner sc=new Scanner(System.in); 
		System.out.println("entern the number");
		n =sc.nextInt();
		int temp =n;
		 while(n>0)
		 {    
			   r=n%10;  //getting remainder  
			   System.out.println(r);
			   s=(s*10)+r;    
			   n=n/10;    
		 }
		 if(temp==s)    
			   System.out.println("palindrome number ");    
			  else    
			   System.out.println("not palindrome");  
	}
}
