/*package mindqsystems;
import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Addingexcelcolumns
{
	public static void main(String[] args) throws Exception 
	{
		// open excel file for reading data
		
		File f = new File("addingexcelcolumnss.xls");
		Workbook rwb = Workbook.getWorkbook(f);
		Sheet rsh = rwb.getSheet(0);
		int nour = rsh.getRows();
		int nouc = rsh.getColumns();
		
		//open excel file for result writting
		
		WritableWorkbook wwb = jxl.Workbook.createWorkbook(f,rwb);
		WritableSheet wsh = wwb.getSheet(1);
		
		//perform addtion
		//first row(index is 0) have name for columns
		
		for(int i=1; i<nour; i++)
		{
			int x= Integer.parseInt(rsh.getCell(0,i).getContents());
			int y= Integer.parseInt(rsh.getCell(1,i).getContents());
			int z= x+y;
			Number n = new Number(0,i,z);
			wsh.addCell(n);
		}
		//save and close
		wwb.write();
		wwb.close();
		rwb.close();
	}
}*/