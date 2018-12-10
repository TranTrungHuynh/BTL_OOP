package create.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Entity;
import readfile.io.ReadFile;

public class CreateRandomEntity extends ReadFile {
	
	public CreateRandomEntity()
	{
		super();
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
		Entity entity;
		CreatePerson createPerson = new CreatePerson();
		CreateCountry createCountry = new CreateCountry();
		CreateEvent createEvent = new CreateEvent();
		CreateLocation createLocation = new CreateLocation();
		CreateOrganization createOrganization = new CreateOrganization();
		CreateTime createTime = new CreateTime();
		
		
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
