package corejavaone;

public class String_reverse_with_and_without_StringBuffer_class 
{
	public static String invertWithStringBuffer(String str) 
	{
		StringBuffer buffer = new StringBuffer(str);
		buffer.reverse();
		return buffer.toString();
	}

	public static String invertWithoutStringBuffer(String str) 
	{
		int length = str.length();
		//System.out.println(length);
		String original = str;
		String invert ="";
		for (int i = length - 1; i >= 0; i--) //(int i =3-1; i>=0; i--)
		{
			invert = invert + original.charAt(i);
		}
		return invert;
	}
	public static void main(String[] args) 
	{
		System.out.println("with StringBuffer class: "
				+ invertWithStringBuffer("ram"));

		System.out.println("");

		System.out.println("without StringBuffer class: "
				+ invertWithoutStringBuffer("ram"));
	}
}
