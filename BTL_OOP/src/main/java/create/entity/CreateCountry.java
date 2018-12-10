package create.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import model.Country;


public class CreateCountry extends RandomDate {
	public Country getRandomCountry(ArrayList<String> listCountryName, ArrayList<String> listCountryContinent, ArrayList<String> listCountryDescription)
	{
		Random rd = new Random();
		String name = listCountryName.get(rd.nextInt(listCountryName.size()));
		String description = listCountryDescription.get(rd.nextInt(listCountryDescription.size()));
		String continent = listCountryContinent.get(rd.nextInt(listCountryContinent.size()));
		String link = "http://shadow.org/linkCountry" + rd.nextInt(listCountryName.size());
		Date date = getDateRandom();
		Country country = new Country(name, description, continent, link, date);
		return country;
	}
}
