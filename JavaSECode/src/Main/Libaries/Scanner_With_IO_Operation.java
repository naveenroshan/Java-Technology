package Main.Libaries;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
*
* @author Naveen
*/

// This class explains the concept of Scanner with io file read and write operation to fine average of given number.
public class Scanner_With_IO_Operation {

	public static void main(String[] args) throws IOException {
		int count = 0;
		double sum = 0.0;
		// Write output to a file.
		FileWriter fout = new FileWriter("C://Users//Naveen.s2//Desktop//files//testFile.txt");
		// Now, store values in comma-separated list.
		fout.write("2, 3.4,    5,6, 7.4, 9.1, 10.5, done");
		fout.close();
		FileReader fin = new FileReader("C://Users//Naveen.s2//Desktop//files//testFile.txt");
		Scanner src = new Scanner(fin);
		// Set delimiters to space and comma.
		src.useDelimiter(", *");
		// Read and sum numbers.
		while (src.hasNext()) {
			if (src.hasNextDouble()) {
				sum += src.nextDouble();
				count++;
			} else {
				String str = src.next();
				if (str.equals("done"))
					break;
				else {
					System.out.println("File format error.");
					return;
				}
			}
		}
		src.close();
		System.out.println("Average is " + sum / count);
	}
}
