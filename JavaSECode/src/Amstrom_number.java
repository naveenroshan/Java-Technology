package core_java_pack;

public class Amstrong_number
{
	public static void main (String [] args)
	{
		int c = 0;
		int a;
		int temp;
		int n =153;
		temp =n;
		while(n>0)
		{
			a=n%10;
			//System.out.println(a);
			c=c+(a*a*a);
			//c=0+(3*3*3*)=27 ,c=27+(5*5*5)=152 ,c=152+(1*1*1)=1,c=153
			//System.out.println(c);
			n=n/10;
			//System.out.println(n);
		}
		if(temp==c)
{
			System.out.println("amstrong");

}
		else
		{
						System.out.println("not amstrong");
		}
	}
}
