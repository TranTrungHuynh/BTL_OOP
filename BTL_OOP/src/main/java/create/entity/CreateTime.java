package create.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

import model.Time;

public class CreateTime {
	public static Time getRandomTime(ArrayList<String> listTimmeName, ArrayList<String> listTimeDescription)
	{
		Random rd = new Random();
		String name = listTimmeName.get(rd.nextInt(listTimmeName.size()));
		String description = listTimeDescription.get(rd.nextInt(listTimeDescription.size()));
		String date = getDateRandom();
		String link = "http://shadow.org/linkTime" + rd.nextInt(listTimmeName.size());
		Time time = new Time(name, description, link, date);
		return time;
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
