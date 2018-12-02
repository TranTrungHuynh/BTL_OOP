package create.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import model.Person;

public class CreatePerson {

	public static Person getRandomPerson(ArrayList<String> listPersonName, ArrayList<String> listPersonDescription, ArrayList<String> listPersonJob)
	{
		Random rd = new Random();
		String name = listPersonName.get(rd.nextInt(listPersonName.size()));
		String description = listPersonDescription.get(rd.nextInt(listPersonDescription.size()));
		String job = listPersonJob.get(rd.nextInt(listPersonJob.size()));
		String link = "http://shadow.org/linkPerson" + rd.nextInt(listPersonName.size());
		Date date = RandomDate.getDateRandom();
		Person person = new Person(name, description, link, date, job);
		return person;
	}
	
}
