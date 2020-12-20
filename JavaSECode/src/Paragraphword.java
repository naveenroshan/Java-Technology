/*package mindqsystems;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Paragraphword
{
	public static void main(String[] args) throws Exception 
	{
		// open existing file 
		File f = new File("paragraph.txt");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		
		//get a word from keyword
		Scanner sc = new Scanner(System.in);
		System.out.println("enter a word to search in text file");
		String x = sc.nextLine();
		int count =0;
		
		//search the word
		String l;
		While((l=br.readLine())!=null)
		{
			String p[] =l.split(" ");
			for(int i; i<p.length; i++)
			{
				if(x.equalsIgnoreCase(p[i]))
				{
					count = count+1;
				}
			}
		}
		System.out.println(x+" come "+count+" time ");
	}
}*/