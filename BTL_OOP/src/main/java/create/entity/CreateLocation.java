package create.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

import model.Location;

public class CreateLocation {
	public static Location getRandomLocation(ArrayList<String> listLocationName, ArrayList<String> listLocationDescription)
	{
		Random rd = new Random();
		String name = listLocationName.get(rd.nextInt(listLocationName.size()));
		String description = listLocationDescription.get(rd.nextInt(listLocationDescription.size()));
		String date = getDateRandom();
		String link = "http://shadow.org/linkLocation" + rd.nextInt(listLocationName.size());
		Location location = new Location(name, description, link, date);
		return location;
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
