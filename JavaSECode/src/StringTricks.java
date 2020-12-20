package SECode;
/**
*
* @author Naveen
*/

public class StringTricks {

	public static void main(String[] args) {

		String s1 = "Hello"; // Here, hello string will be stored at a location and and s1 will keep a reference to it.
		String s2 = "Hello"; // Here, hello string will be stored at a location and and s1 will keep a reference to it.
		String s3 = new String("Hello");  //will create a new object, will refer to that one and will be stored at a different location.
		String s4 = new String("Hello");  //will create a new object, will refer to that one and will be stored at a different location.
		System.out.println(s1 == s2);// true
		System.out.println(s3 == s4);//false---dought // here we pointing to reference 
		System.out.println(s1 == s3);//false---dought // here we pointing to reference 
		System.out.println(s1.equals(s2));//true // true because the value are checked here 
		System.out.println(s3.equals(s4));//true--dought // true because the value are checked here 
		System.out.println(s1.equals(s3));//true---dought // true because the value are checked here 
		System.out.println(s1.hashCode()); //hashcode calculation for a string "s[0]*31^(n - 1) + s[1]*31^(n - 2) + ... + s[n - 1]"
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		System.out.println("***********************");
		String a = "Aa";
		String b = "BB";
		System.out.println(a.hashCode());//2112
		System.out.println(b.hashCode());//2112
		System.out.println(a == b);//false
		System.out.println("***********************");
		String str1 = new String("abc");
		String str2 = "A";
		str1 = str2;
		str2 = "efg";
		System.out.println(str1);//A
	}
}
