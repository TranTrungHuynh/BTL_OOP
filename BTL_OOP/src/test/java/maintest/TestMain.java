package maintest;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import io.ReadFile;
import model.test.Country;

public class TestMain {

	public static void test()
	{
		RandomEntity randomEntity = new RandomEntity();
		ArrayList<Country> listCountry = new ArrayList<Country>();

		listCountry = randomEntity.RandomEntity();
		
		for (Country country : listCountry) {
			System.out.println(country.getName());
		}
	}

	public static void main(String[] args) {
		test();
		
	}
}
