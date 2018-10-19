package SECode;

/**
 *
 * @author Naveen
 */
// here we see the example of the bit wise ,ternary operator 
public class Operator {
    
    // bit wise operator example two :
    

    public static void main(String[] args) {

	// bit wise operator example:
	String binary[] = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
		"1011", "1100", "1101", "1110", "1111" };
	int a = 3; // 0 + 2 + 1 or 0011 in binary
	int b = 6; // 4 + 2 + 0 or 0110 in binary
	int c = a | b;
	int d = a & b;
	int e = a ^ b;
	int f = (~a & b) | (a & ~b);
	int g = ~a & 0x0f;
	System.out.println(" a = " + binary[a]);
	System.out.println(" b = " + binary[b]);
	System.out.println(" a|b = " + binary[c]);
	System.out.println(" a&b = " + binary[d]);
	System.out.println(" a^b = " + binary[e]);
	System.out.println("~a&b|a&~b = " + binary[f]);
	System.out.println(" ~a = " + binary[g]);
	

	// ternary operator type one
	int q = 1;
	int w = 2;
	int r = 3;
	if (q == 1 ? w != 1 : r == 1) {
	    System.out.println("worked");

	    // ternary operator type two
	    int i, k;
	    i = 10;
	    k = (i < 0) ? i : -i; // get absolute value of i
	    System.out.println("Absolute value of " + i + " is " + k);
	    
	    i = -10;
	    k = (i < 0) ? -i : i; // get absolute value of i
	    System.out.print("Absolute value of " + i + " is " + k);
	    
	
	    
	}
    }
}
