package SECode;
/**
*
* @author Naveen
*/

//this class is used to access the encapsulat variables of EncapTest class
public class EncapTest_RunEncap_class {

	public static void main(String[] args) {
		EncapTest encap = new EncapTest();
		
		// here we setting the values.
		encap.setName("James");
		encap.setAge(20);
		encap.setIdNum("12343ms");
		
		//here we are getting the setted values.by printing

		System.out.print("Name : " + encap.getName() + " Age : " + encap.getAge());
	}

}
