package create.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

import model.Organization;

public class CreateOrganization {
	public static Organization getRandomOrganization(ArrayList<String> listOrganizationName,
			ArrayList<String> listOrganizationHeadquarter, ArrayList<String> listOrganizationDescription)
	{
		Random rd = new Random();
		String name = listOrganizationName.get(rd.nextInt(listOrganizationName.size()));
		String headquarter = listOrganizationHeadquarter.get(rd.nextInt(listOrganizationHeadquarter.size()));
		String description = listOrganizationDescription.get(rd.nextInt(listOrganizationDescription.size()));
		String date = getDateRandom();
		String link = "http://shadow.org/linkOrganization" + rd.nextInt(listOrganizationName.size());
		Organization organization = new Organization(name, description, link, date, headquarter);
		return organization;
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
