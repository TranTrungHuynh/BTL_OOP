package file.io;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class WriteFile {
	public boolean writeFileQuery(String path, ArrayList<String> listResultQuery)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			
			for (String string : listResultQuery)
			{
				bw.write(string);
				bw.newLine();
			}
			
			bw.close();
			osw.close();
			fos.close();
			
			return true;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
}
