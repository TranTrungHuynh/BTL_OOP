package main;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import create.entity.CreateRandomEntity;
import graphdb.CreateIRIStatement;
import graphdb.Query;
import model.Country;
import model.Entity;
import model.Event;
import model.Location;
import model.Organization;
import model.Person;
import model.Time;

public class Main {
	public static void main(String[] args) {

		int numberOfEntity = 100;
		int numberOfRelationship = 200;
		
		CreateRandomEntity cre = new CreateRandomEntity();
//		long start1 = System.currentTimeMillis();
		ArrayList<Entity> listEntity = cre.getListRandomEntity(numberOfEntity);
		ArrayList<String> listRelationship = cre.getListRelationshipDescription(numberOfRelationship);
//		long end1 = System.currentTimeMillis();
//		System.out.println("End - start = " + (end1 - start1));
//		System.exit(1);
		
		ArrayList<Person>listPerson = new ArrayList<Person>();
		ArrayList<Country>listCountry = new ArrayList<Country>();
		ArrayList<Event>listEvent = new ArrayList<Event>();
		ArrayList<Location>listLocation = new ArrayList<Location>();
		ArrayList<Organization>listOrganization = new ArrayList<Organization>();
		ArrayList<Time>listTime = new ArrayList<Time>();
		
		CreateIRIStatement createIRIStatement = new CreateIRIStatement();
		
		
		long start = System.currentTimeMillis();
		
//		/*============== Filter Data Entity ===================*/
		for (Entity entity : listEntity)
		{
			if(entity instanceof Person)
			{
//				System.out.println("*******************************Class Person******************************");
				Person person = (Person) entity;
				listPerson.add(person);
			}
			else if(entity instanceof Country)
			{
//				System.out.println("*******************************Class Country******************************");
				Country country = (Country) entity;
				listCountry.add(country);
			}
			else if(entity instanceof Event)
			{
//				System.out.println("*******************************Class Event******************************");
				Event event = (Event) entity;
				listEvent.add(event);
			}
			else if(entity instanceof Location)
			{
//				System.out.println("*******************************Class Location******************************");
				Location location = (Location) entity;
				listLocation.add(location);
			}
			else if(entity instanceof Organization)
			{
//				System.out.println("*******************************Class Organization******************************");
				Organization organization = (Organization) entity;
				listOrganization.add(organization);
			}
			else if(entity instanceof Time)
			{
//				System.out.println("*******************************Class Time******************************");
				Time time = (Time) entity;
				listTime.add(time);
			}
			else
			{
				System.out.println("Wrong !");
			}
		}
		
		createIRIStatement.createIRIPerson(listPerson);
		createIRIStatement.createIRICountry(listCountry);
		createIRIStatement.createIRIEvent(listEvent);
		createIRIStatement.createIRILocation(listLocation);
		createIRIStatement.createIRIOrganization(listOrganization);
		createIRIStatement.createIRITime(listTime);
		
		// Show number of each Entity
//		System.out.println(listPerson.size());
//		System.out.println(listCountry.size());
//		System.out.println(listEvent.size());
//		System.out.println(listLocation.size());
//		System.out.println(listOrganization.size());
//		System.out.println(listTime.size());
//		System.out.println();
		
		long end = System.currentTimeMillis();
		System.out.println("End - start = " + (end - start));
//		System.exit(1);
//	
		/*============== Insert Data Relationship ===================*/
		Random rd = new Random();
		for (int i = 0; i < numberOfRelationship; i++)
		{
			Entity entity1 = listEntity.get(rd.nextInt(numberOfEntity));
			Entity entity2 = listEntity.get(rd.nextInt(numberOfEntity));
			String strRelationship = listRelationship.get(rd.nextInt(numberOfRelationship));
			createIRIStatement.createIRIRelationship(entity1, entity2, strRelationship);
		}
		end = System.currentTimeMillis();
		
		
		/*============== Query Data ===================*/
//		Query.queryBasic();
//		Query.queryAdvance();
		
		
		
//		for(int i = 0; i < 5000000; i++)
//		{
//			System.out.println(i);
//		}
		
//		System.out.println("\nList Entity = " + listEntity.size());
//		System.out.println("\nList Relationship = " + listRelationship.size());
//		System.out.println("\nTime Add = " + (end-start));

//		System.exit(0);
	}  
}


