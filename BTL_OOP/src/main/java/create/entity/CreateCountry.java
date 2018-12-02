package create.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

import model.Country;
import model.Person;

public class CreateCountry {
	public static Country getRandomCountry(ArrayList<String> listCountryName, ArrayList<String> listCountryContinent, ArrayList<String> listCountryDescription)
	{
		Random rd = new Random();
		String name = listCountryName.get(rd.nextInt(listCountryName.size()));
		String description = listCountryDescription.get(rd.nextInt(listCountryDescription.size()));
		String continent = listCountryContinent.get(rd.nextInt(listCountryContinent.size()));
		String link = "http://shadow.org/linkCountry" + rd.nextInt(listCountryName.size());
		String date = getDateRandom();
		Country country = new Country(name, description, continent, link, date);
		return country;
	}
	
	private static String getDateRandom()
	{
		GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1900, 2018);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        String dateRandom = gc.get(gc.DAY_OF_MONTH) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.YEAR);
        
        return dateRandom;
	}
	
	private static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
