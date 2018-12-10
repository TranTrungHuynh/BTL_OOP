package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile extends FileNameConstant {
	
	protected static ArrayList<String> listNameCountry;
	
	public ReadFile()
	{
		listNameCountry = new ArrayList<String>();
		readFileCountryName();
	}
	
	public void readFileCountryName() {
		try
		{
			Scanner sc = new Scanner(new File(fileNameCountry));
			String line = "";
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listNameCountry.add(line);
			}
			sc.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getFileCountry()
	{
		return listNameCountry;
	}
}
