package pratieces;

public class VarArgs
{
/*	 static double average(int a, int b)
	    {
	        //Average Of two numbers
	 	        return (a + b)/2;
	    }
	 static double average(int a, int b, int c)
	    {
	        //Average of three numbers
	 	        return (a + b + c)/3;
	    }
	 static double average(int a, int b, int c, int d)
	    {
	        //Average of four numbers
	            return (a + b + c +d)/4;
	    }
	 public static void main(String[] args)
	    {
	        System.out.println(average(10, 20));   //prints average of two numbers
	        System.out.println(average(10, 20, 30));  //prints average of three numbers
	        System.out.println(average(10, 20, 30, 40));  //prints average of four numbers
	    }
--------------------------------------------------------------------------------------------------------
	*/
	 static double average(int... a)
	    {
	        //Average Of 'n' numbers
	        int n = a.length;
	        int sumOfNumbers = 0;
	        //Claculating sum of numbers
	        for(int i : a)
	        {
	            sumOfNumbers = sumOfNumbers + i;
	        }
	        return (sumOfNumbers/n);
	    }
	    public static void main(String[] args)
	    {
	        System.out.println(average(10, 20, 30, 40, 50));   //prints average of 5 numbers
	        System.out.println(average(10, 20, 30, 40, 50, 60, 70, 80));  //prints average of 8 numbers
	        System.out.println(average(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110));  //prints average of 11 numbers
	    }
}