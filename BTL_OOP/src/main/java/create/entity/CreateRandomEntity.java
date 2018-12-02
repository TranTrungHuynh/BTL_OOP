package create.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Entity;

public class CreateRandomEntity extends FileNameConstant {
	private static ArrayList<String> listPersonName;
	private static ArrayList<String> listPersonJob;
	private static ArrayList<String> listPersonDescription;
	
	private static ArrayList<String> listCountryContinent;
	private static ArrayList<String> listCountryDescription;
	private static ArrayList<String> listCountryName;
	
	private static ArrayList<String> listRelationshipDescription;
	
	private static ArrayList<String> listEventDescription;
	private static ArrayList<String> listEventName;
	
	private static ArrayList<String> listLocationName;
	private static ArrayList<String> listLocationDescription;
	
	private static ArrayList<String> listOrganizationName;
	private static ArrayList<String> listOrganizationHeadquarter;
	private static ArrayList<String> listOrganizationDescription;
	
	private static ArrayList<String> listTimeDescription;
	private static ArrayList<String> listTimmeName;
	
	Scanner sc;
	String line="";
	
	public CreateRandomEntity()
	{
		super();
		
		listPersonName = new ArrayList<String>();
		listPersonJob = new ArrayList<String>();
		listPersonDescription = new ArrayList<String>();
				
		listCountryContinent = new ArrayList<String>();
		listCountryDescription = new ArrayList<String>();
		listCountryName = new ArrayList<String>();
		
		listRelationshipDescription = new ArrayList<String>();
		
		listEventDescription = new ArrayList<String>();
		listEventName = new ArrayList<String>();
						
		listLocationName = new ArrayList<String>();
		listLocationDescription = new ArrayList<String>();
		
		listOrganizationName = new ArrayList<String>();
		listOrganizationDescription = new ArrayList<String>();
		listOrganizationHeadquarter = new ArrayList<String>();
		
		listTimeDescription = new ArrayList<String>();
		listTimmeName = new ArrayList<String>();
		
		readFilePerson();
		readFileCountry();
		readFileRelationship();
		readFileEvent();
		readFileLocation();
		readFileOrganization();
		readFileTime();
	}
	
	private void readFileTime() {
		try
		{
			sc = new Scanner(new File(fileTimmeName));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listTimmeName.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(fileTimeDescription));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listTimeDescription.add(line);
			}
			sc.close();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	private void readFileOrganization() {
		try
		{
			sc = new Scanner(new File(fileOrganizationName));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listOrganizationName.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(fileOrganizationHeadquarter));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listOrganizationHeadquarter.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(fileOrganizationDescription));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listOrganizationDescription.add(line);
			}
			sc.close();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	private void readFileLocation() {
		try
		{
			sc = new Scanner(new File(fileLocationName));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listLocationName.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(fileLocationDescription));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listLocationDescription.add(line);
			}
			sc.close();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	private void readFileEvent() {
		try
		{
			sc = new Scanner(new File(fileEventName));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listEventName.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(fileEventDescription));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listEventDescription.add(line);
			}
			sc.close();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	private void readFileCountry() {
		try
		{
			sc = new Scanner(new File(fileCountryName));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listCountryName.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(fileCountryDescription));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listCountryDescription.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(fileCountryContinent));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listCountryContinent.add(line);
			}
			sc.close();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	private void readFilePerson() {
		try
		{
			sc = new Scanner(new File(filePersonName));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listPersonName.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(filePersonDescription));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listPersonDescription.add(line);
			}
			sc.close();
			
			sc = new Scanner(new File(filePersonJob));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listPersonJob.add(line);
			}
			sc.close();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	private void readFileRelationship()
	{
		try
		{
			sc = new Scanner(new File(fileRelationshipDescription));
			while(sc.hasNextLine())
			{
				line = sc.nextLine();
				listRelationshipDescription.add(line);
			}
			sc.close();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	
	public ArrayList<String> getListRelationshipDescription(int numberOfRelationship)
	{
		ArrayList<String> listRelationship = new ArrayList<String>();
		
		Random rd = new Random();
		for(int i = 0; i < numberOfRelationship; i++)
		{
			String relation = listRelationshipDescription.get(rd.nextInt(listRelationshipDescription.size()));
			listRelationship.add(relation);
		}
		
		return listRelationship;
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
		
		Random rd = new Random();
		int chooseEntity = rd.nextInt(6);
		switch(chooseEntity)
		{
			case 0:
					entity = CreatePerson.getRandomPerson(listPersonName, listPersonDescription, listPersonJob);
					break;
			case 1:
					entity = CreateCountry.getRandomCountry(listCountryName, listCountryContinent, listCountryDescription);
					break;
			case 2:
					entity = CreateEvent.getRandomEvent(listEventName, listEventDescription);
					break;
			case 3:
					entity = CreateLocation.getRandomLocation(listLocationName, listLocationDescription);
					break;
			case 4:
					entity = CreateOrganization.getRandomOrganization(listOrganizationName, listOrganizationHeadquarter, listOrganizationDescription);
					break;
			case 5:
					entity = CreateTime.getRandomTime(listTimmeName, listTimeDescription);
					break;
			default:
				entity = null;
				break;
		}
		return entity;
	}
	
	
}
