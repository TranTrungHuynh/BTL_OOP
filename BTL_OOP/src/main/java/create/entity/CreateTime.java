package create.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import model.Time;

public class CreateTime extends RandomDate {
	public Time getRandomTime(ArrayList<String> listTimmeName, ArrayList<String> listTimeDescription)
	{
		Random rd = new Random();
		String name = listTimmeName.get(rd.nextInt(listTimmeName.size()));
		String description = listTimeDescription.get(rd.nextInt(listTimeDescription.size()));
		Date date = getDateRandom();
		String link = "http://shadow.org/linkTime" + rd.nextInt(listTimmeName.size());
		Time time = new Time(name, description, link, date);
		return time;
	}
}
	
