package main;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import create.entity.CreateRandomEntity;
import graphdb.Connection;
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

		int numberOfEntity = 500000;
		int numberOfRelationship = 1000000;
		
		// Get list Entity
		CreateRandomEntity cre = new CreateRandomEntity();
		ArrayList<Entity> listEntity = cre.getListRandomEntity(numberOfEntity);
		
		ArrayList<Person>listPerson = new ArrayList<Person>();
		ArrayList<Country>listCountry = new ArrayList<Country>();
		ArrayList<Event>listEvent = new ArrayList<Event>();
		ArrayList<Location>listLocation = new ArrayList<Location>();
		ArrayList<Organization>listOrganization = new ArrayList<Organization>();
		ArrayList<Time>listTime = new ArrayList<Time>();
		
		// Define object upload relation and entity
		CreateIRIStatement createIRIStatement = new CreateIRIStatement();
		
//		/*============== Filter Data Entity ===================*/
		for (Entity entity : listEntity)
		{
			if(entity instanceof Person)
			{
				Person person = (Person) entity;
				listPerson.add(person);
			}
			else if(entity instanceof Country)
			{
				Country country = (Country) entity;
				listCountry.add(country);
			}
			else if(entity instanceof Event)
			{
				Event event = (Event) entity;
				listEvent.add(event);
			}
			else if(entity instanceof Location)
			{
				Location location = (Location) entity;
				listLocation.add(location);
			}
			else if(entity instanceof Organization)
			{
				Organization organization = (Organization) entity;
				listOrganization.add(organization);
			}
			else if(entity instanceof Time)
			{
				Time time = (Time) entity;
				listTime.add(time);
			}
			else
			{
				System.out.println("Wrong !");
			}
		}
		
		long start = System.currentTimeMillis();
		
		/*==============Upload Entity data to server=========*/
		createIRIStatement.createIRIPerson(listPerson);
		createIRIStatement.createIRICountry(listCountry);
		createIRIStatement.createIRIEvent(listEvent);
		createIRIStatement.createIRILocation(listLocation);
		createIRIStatement.createIRIOrganization(listOrganization);
		createIRIStatement.createIRITime(listTime);
		System.gc();
		
		// Show number of each Entity
		System.out.println(listPerson.size());
		System.out.println(listCountry.size());
		System.out.println(listEvent.size());
		System.out.println(listLocation.size());
		System.out.println(listOrganization.size());
		System.out.println(listTime.size());
		System.out.println();
		
//		long start = System.currentTimeMillis();
		
		/*============== Upload Relationship ===================*/
		createIRIStatement.uploadRelationData(numberOfRelationship, listPerson,
				listCountry, listEvent, listLocation, listOrganization, listTime);
		
		long end = System.currentTimeMillis();
		
		
		/*============== Query Data ===================*/
//		Query.queryBasic();
//		Query.queryAdvance();
		
		
		System.out.println("\nTime Add = " + (end-start));

		System.exit(0);
	}  
}


