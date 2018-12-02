package create.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import model.Location;

public class CreateLocation {
	public static Location getRandomLocation(ArrayList<String> listLocationName, ArrayList<String> listLocationDescription)
	{
		Random rd = new Random();
		String name = listLocationName.get(rd.nextInt(listLocationName.size()));
		String description = listLocationDescription.get(rd.nextInt(listLocationDescription.size()));
		Date date = RandomDate.getDateRandom();
		String link = "http://shadow.org/linkLocation" + rd.nextInt(listLocationName.size());
		Location location = new Location(name, description, link, date);
		return location;
	}
	
}	
