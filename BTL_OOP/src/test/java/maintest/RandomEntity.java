package maintest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import io.ReadFile;
import model.test.Country;

public class RandomEntity extends ReadFile {
	public ArrayList<Country> RandomEntity()
	{
		ArrayList<Country> listCountry = new ArrayList<Country>();
		Random rd = new Random();
		
		for (int i = 0; i < 1000; i++) {
			listCountry.add(new Country(listNameCountry.get(rd.nextInt(listNameCountry.size()))));
		}
		
		return listCountry;
	}
	
}
