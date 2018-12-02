package create.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import model.Event;

public class CreateEvent {
	public static Event getRandomEvent(ArrayList<String> listEventName, ArrayList<String> listEventDescription)
	{
		Random rd = new Random();
		String name = listEventName.get(rd.nextInt(listEventName.size()));
		String description = listEventDescription.get(rd.nextInt(listEventDescription.size()));
		Date date = RandomDate.getDateRandom();
		String link = "http://shadow.org/linkEvent" + rd.nextInt(listEventName.size());
		Event event = new Event(name, description, link, date);
		return event;
	}
	
}
