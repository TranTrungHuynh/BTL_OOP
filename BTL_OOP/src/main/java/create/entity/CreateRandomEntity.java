package create.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import file.io.ReadFile;
import model.Entity;

public class CreateRandomEntity extends ReadFile {
	
	Entity entity;
	CreatePerson createPerson;
	CreateCountry createCountry;
	CreateEvent createEvent;
	CreateLocation createLocation;
	CreateOrganization createOrganization;
	CreateTime createTime;
	
	
	
	public CreateRandomEntity()
	{
		super();
		
		createPerson = new CreatePerson();
		createCountry = new CreateCountry();
		createEvent = new CreateEvent();
		createLocation = new CreateLocation();
		createOrganization = new CreateOrganization();
		createTime = new CreateTime();
	}
	
	public ArrayList<Entity> getListRandomEntity(int numberOfEntity)
	{
		ArrayList<Entity> listEntity = new ArrayList<Entity>();
		for(int i = 0; i < numberOfEntity; i++)
		{
			listEntity.add(randomEntity());
		}
		return listEntity;
	}
	
	private Entity randomEntity()
	{
		Random rd = new Random();
		int chooseEntity = rd.nextInt(6);
		switch(chooseEntity)
		{
			case 0:
					entity = createPerson.getRandomPerson(listPersonName, listPersonDescription, listPersonJob);
					break;
			case 1:
					entity = createCountry.getRandomCountry(listCountryName, listCountryContinent, listCountryDescription);
					break;
			case 2:
					entity = createEvent.getRandomEvent(listEventName, listEventDescription);
					break;
			case 3:
					entity = createLocation.getRandomLocation(listLocationName, listLocationDescription);
					break;
			case 4:
					entity = createOrganization.getRandomOrganization(listOrganizationName, listOrganizationHeadquarter, listOrganizationDescription);
					break;
			case 5:
					entity = createTime.getRandomTime(listTimmeName, listTimeDescription);
					break;
			default:
				entity = null;
				break;
		}
		return entity;
	}
}
