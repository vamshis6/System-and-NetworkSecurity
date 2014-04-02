import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.PrintWriter;
import java.io.FileWriter;

public class FileReader {

	
	
	public int getCount()
	{
		int count=0;
		FileReader filereader=null;
		BufferedReader br=null;
		PrintWriter writer=null;
		try
		{
			File f=new File("number_of_visitorsCOunt");
			if(!f.exists())
			{
				f.createNewFile();
				writer = new PrintWriter(new FileWriter(f));
		        writer.println(0);
			}
			
			if(writer!=null)
			{
				writer.flush();
				writer.close();
			}
			
			br = new BufferedReader(new java.io.FileReader(f));
			String inital=br.readLine();
			count=Integer.parseInt(inital);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return count;
	}
	
	public void addCount(int count)
	{
		FileWriter fw=null;
		PrintWriter br=null;
		try
		{
			fw = new FileWriter("number_of_visitorsCOuntl");
		    br = new PrintWriter(fw);
		    br.println(count);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
