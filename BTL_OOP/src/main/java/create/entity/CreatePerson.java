package create.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import model.Person;

public class CreatePerson {

	public static Person getRandomPerson(ArrayList<String> listPersonName, ArrayList<String> listPersonDescription, ArrayList<String> listPersonJob)
	{
		Random rd = new Random();
		String name = listPersonName.get(rd.nextInt(listPersonName.size()));
		String description = listPersonDescription.get(rd.nextInt(listPersonDescription.size()));
		String job = listPersonJob.get(rd.nextInt(listPersonJob.size()));
		String link = "http://shadow.org/linkPerson" + rd.nextInt(listPersonName.size());
		String date = getDateRandom();
		Person person = new Person(name, description, link, date, job);
		return person;
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
