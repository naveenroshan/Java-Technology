package SECode;

/**
 *
 * @author Naveen
 */
public class OnedimentionArray {
	public void itration() {
		int month_days[] = { 31, 28, 30, 31, 30, 31, 30, 31, 30, 31, 30, 31 };
		int i;
		for (i = 0; i < 5; i++) {
			double result = 0;
			result = result + month_days[i];
			System.out.println(result);
		}
	}

	public static void main(String[] args) {
		OnedimentionArray call = new OnedimentionArray();
		call.itration();
	}
}