package corejavaone;

public class Find_out_the_first_two_max_values_from_an_array 
{
	public static void GetTwoMaxValues(int[] nums) 
	{
		int maxOne = 0;
		int maxTwo = 0;
		for (int n : nums)
		{
			//System.out.println(n);
			if (maxOne < n)
			{
				maxTwo = maxOne; //maxtwo=15, maxtwo=24, maxtwo=48, maxtwo=79
				maxOne = n;     //maxone=15, maxone=24, maxone=48, maxone=79 , maxone=93
			} 
			else if (maxTwo < n)
			{
				maxTwo = n; //maxtwo=43
			}
		}
		System.out.println("Maxone - " + maxOne);
		System.out.println("Maxtwo - " + maxTwo);
	}
	public static void main(String[] args) 
	{
		int list[] = { 15, 24, 48, 21, 43, 11, 79, 93 };
		GetTwoMaxValues(list);
	}
}
