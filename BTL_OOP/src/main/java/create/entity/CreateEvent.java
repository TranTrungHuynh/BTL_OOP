package create.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

import model.Event;

public class CreateEvent {
	public static Event getRandomEvent(ArrayList<String> listEventName, ArrayList<String> listEventDescription)
	{
		Random rd = new Random();
		String name = listEventName.get(rd.nextInt(listEventName.size()));
		String description = listEventDescription.get(rd.nextInt(listEventDescription.size()));
		String date = getDateRandom();
		String link = "http://shadow.org/linkEvent" + rd.nextInt(listEventName.size());
		Event event = new Event(name, description, link, date);
		return event;
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
