package corejavaone;

public class A_function_to_reverse_a_number 
{
	public long doInvert(long number) 
	{
		long invert = 0;
		while (number != 0)
		{
			invert = (invert * 10) + (number % 10);
			System.out.println((invert));
			number = number / 10;
			System.out.println(number);
     	}
		return invert;
	}
	public static void main(String args[]) 
	{
		long lnum = 654321;
		A_function_to_reverse_a_number input = new A_function_to_reverse_a_number();
		System.out.println("Input value : " + lnum);
		long i =input.doInvert(lnum);
		System.out.println("Inverted value : " + i);
	}
}

