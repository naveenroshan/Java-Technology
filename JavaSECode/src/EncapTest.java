package SECode;
/**
*
* @author Naveen
*/
/*
we are implementing the encapsulation here in this class just getter and setter methods.
we are using getter adn setter for accessing and modiefing the private variable of this class by EncapTest_RunEncap_class
this are that variables private String name; private String idNum; private int age;

*/
public class EncapTest {
	private String name;
	private String idNum;
	private int age;

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setAge(int newAge) {
		age = newAge;
	}

	public void setName(String newName) {
		name = newName;
	}

	public void setIdNum(String newId) {
		idNum = newId;
	}
}
