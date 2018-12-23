package graphdb;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import create.entity.CreateRandomEntity;
import file.io.ReadFile;
import model.Entity;
import model.Event;
import model.Location;
import model.Organization;
import model.Person;
import model.Time;
import model.Country;

public class uploadData extends CreateIRI {

	private Connection connection;
	private RepositoryConnection conn;
	private Model model;
	private ValueFactory valueFactory;
	private IRI subject, predicate, object;

	private ArrayList<Person>listPerson;
	private ArrayList<Country>listCountry;
	private ArrayList<Event>listEvent;
	private ArrayList<Location>listLocation;
	private ArrayList<Organization>listOrganization;
	private ArrayList<Time>listTime;

	private ArrayList<IRI> listIRIPerson;
	private ArrayList<IRI> listIRICountry;
	private ArrayList<IRI> listIRIOrganization;
	private ArrayList<IRI> listIRIEvent;
	private ArrayList<IRI> listIRITime;
	private ArrayList<IRI> listIRILocation;

	public uploadData()
	{
		super();

		connection = new Connection();
		openConnectionCreIRIStatement();
		valueFactory = conn.getValueFactory();
		model = new TreeModel();

		listPerson = new ArrayList<Person>();
		listCountry = new ArrayList<Country>();
		listEvent = new ArrayList<Event>();
		listLocation = new ArrayList<Location>();
		listOrganization = new ArrayList<Organization>();
		listTime = new ArrayList<Time>();

		listIRIPerson       = new ArrayList<IRI>();
		listIRICountry      = new ArrayList<IRI>();
		listIRIEvent        = new ArrayList<IRI>();
		listIRITime         = new ArrayList<IRI>();
		listIRILocation     = new ArrayList<IRI>();
		listIRIOrganization = new ArrayList<IRI>();

	}

	// upload Data Entity
	public void upLoadEntity(int numberOfEntity)
	{
		// Get list Entity
		CreateRandomEntity cre = new CreateRandomEntity();
		ArrayList<Entity> listEntity = cre.getListRandomEntity(numberOfEntity);

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

		createIRIPerson();
		createIRICountry();
		createIRIEvent();
		createIRILocation();
		createIRIOrganization();
		createIRITime();
		listEntity.clear();
	}

	// Create IRI and upload Entity
	public void createIRIPerson()
	{
		try
		{
			Literal object;

			for(Person person : listPerson)
			{
				subject = valueFactory.createIRI(PERSON, "/person" + person.getId());
				listIRIPerson.add(subject);

				// Add instance of class
				model.add(subject, RDF.TYPE, iriPERSON);

				// Add name
				predicate = valueFactory.createIRI(PERSON, LABEL);
				object = valueFactory.createLiteral(person.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(PERSON, DESCRIPTION);
				object = valueFactory.createLiteral(person.getDescription());
				model.add(subject, predicate, object);

				// Add link
				predicate = valueFactory.createIRI(PERSON, LINK);
				object = valueFactory.createLiteral(person.getLink());
				model.add(subject, predicate, object);

				// Add date
				predicate = valueFactory.createIRI(PERSON, DATE);
				object = valueFactory.createLiteral(person.getDate());
				model.add(subject, predicate, object);

				// Add job
				predicate = valueFactory.createIRI(PERSON, JOB);
				object = valueFactory.createLiteral(person.getJob());
				model.add(subject, predicate, object);

				if(model.size() >= 200000)
				{
					conn.add(model);
					model.clear();
				}
			}
			listPerson.clear();
			conn.add(model);
			model.clear();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRICountry()
	{
		try
		{
			Literal object;

			for (Country country : listCountry)
			{
				subject = valueFactory.createIRI(COUNTRY, "/country" + country.getId());
				listIRICountry.add(subject);

				// Add instance of class
				model.add(subject, RDF.TYPE, iriCOUNTRY);

				// Add name
				predicate = valueFactory.createIRI(COUNTRY, LABEL);
				object = valueFactory.createLiteral(country.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(COUNTRY, DESCRIPTION);
				object = valueFactory.createLiteral(country.getDescription());
				model.add(subject, predicate, object);

				// Add link
				predicate = valueFactory.createIRI(COUNTRY, LINK);
				object = valueFactory.createLiteral(country.getLink());
				model.add(subject, predicate, object);

				// Add date
				predicate = valueFactory.createIRI(COUNTRY, DATE);
				object = valueFactory.createLiteral(country.getDate());
				model.add(subject, predicate, object);

				// Add continent
				predicate = valueFactory.createIRI(COUNTRY, CONTINENT);
				object = valueFactory.createLiteral(country.getContinent());
				model.add(subject, predicate, object);

				if(model.size() >= 200000)
				{
					conn.add(model);
					model.clear();
				}
			}
			listCountry.clear();
			conn.add(model);
			model.clear();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRIEvent()
	{
		try
		{
			Literal object;

			for(Event event : listEvent)
			{
				subject = valueFactory.createIRI(EVENT, "/event" + event.getId());
				listIRIEvent.add(subject);

				// Add instance of class
				model.add(subject, RDF.TYPE, iriEVENT);

				// Add name
				predicate = valueFactory.createIRI(EVENT, LABEL);
				object = valueFactory.createLiteral(event.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(EVENT, DESCRIPTION);
				object = valueFactory.createLiteral(event.getDescription());
				model.add(subject, predicate, object);

				// Add link
				predicate = valueFactory.createIRI(EVENT, LINK);
				object = valueFactory.createLiteral(event.getLink());
				model.add(subject, predicate, object);

				// Add date
				predicate = valueFactory.createIRI(EVENT, DATE);
				object = valueFactory.createLiteral(event.getDate());
				model.add(subject, predicate, object);

				if(model.size() >= 200000)
				{
					conn.add(model);
					model.clear();
				}
			}
			listEvent.clear();
			conn.add(model);
			model.clear();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRILocation()
	{
		try
		{
			Literal object;

			for(Location location : listLocation)
			{
				subject = valueFactory.createIRI(LOCATION, "/location" + location.getId());
				listIRILocation.add(subject);

				// Add instance of class
				model.add(subject, RDF.TYPE, iriLOCATION);

				// Add name
				predicate = valueFactory.createIRI(LOCATION, LABEL);
				object = valueFactory.createLiteral(location.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(LOCATION, DESCRIPTION);
				object = valueFactory.createLiteral(location.getDescription());
				model.add(subject, predicate, object);

				// Add link
				predicate = valueFactory.createIRI(LOCATION, LINK);
				object = valueFactory.createLiteral(location.getLink());
				model.add(subject, predicate, object);

				// Add date
				predicate = valueFactory.createIRI(LOCATION, DATE);
				object = valueFactory.createLiteral(location.getDate());
				model.add(subject, predicate, object);

				if(model.size() >= 200000)
				{
					conn.add(model);
					model.clear();
				}
			}
			listLocation.clear();
			conn.add(model);
			model.clear();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRIOrganization()
	{
		try
		{
			Literal object;

			for(Organization organization : listOrganization)
			{
				subject = valueFactory.createIRI(ORGANIZATION, "/organization" + organization.getId());
				listIRIOrganization.add(subject);

				// Add instance of class
				model.add(subject, RDF.TYPE, iriORGANIZATION);

				// Add name
				predicate = valueFactory.createIRI(ORGANIZATION, LABEL);
				object = valueFactory.createLiteral(organization.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(ORGANIZATION, DESCRIPTION);
				object = valueFactory.createLiteral(organization.getDescription());
				model.add(subject, predicate, object);

				// Add link
				predicate = valueFactory.createIRI(ORGANIZATION, LINK);
				object = valueFactory.createLiteral(organization.getLink());
				model.add(subject, predicate, object);

				// Add date
				predicate = valueFactory.createIRI(ORGANIZATION, DATE);
				object = valueFactory.createLiteral(organization.getDate());
				model.add(subject, predicate, object);

				// Add headquarter
				predicate = valueFactory.createIRI(ORGANIZATION, HEADQUARTER);
				object = valueFactory.createLiteral(organization.getHeadquarter());
				model.add(subject, predicate, object);

				if(model.size() >= 200000)
				{
					conn.add(model);
					model.clear();
				}
			}
			listOrganization.clear();
			conn.add(model);
			model.clear();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRITime()
	{
		try
		{
			Literal object;

			for(Time time : listTime)
			{
				subject = valueFactory.createIRI(TIME, "/time" + time.getId());
				listIRITime.add(subject);

				// Add instance of class
				model.add(subject, RDF.TYPE, iriTIME);

				// Add name
				predicate = valueFactory.createIRI(TIME, LABEL);
				object = valueFactory.createLiteral(time.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(TIME, DESCRIPTION);
				object = valueFactory.createLiteral(time.getDescription());
				model.add(subject, predicate, object);

				// Add link
				predicate = valueFactory.createIRI(TIME, LINK);
				object = valueFactory.createLiteral(time.getLink());
				model.add(subject, predicate, object);

				// Add date
				predicate = valueFactory.createIRI(TIME, DATE);
				object = valueFactory.createLiteral(time.getDate());
				model.add(subject, predicate, object);

				if(model.size() >= 200000)
				{
					conn.add(model);
					model.clear();
				}
			}
			listTime.clear();
			conn.add(model);
			model.clear();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	// Create IRI and upload Relation
	public void uploadRelationData(int numberOfRelationship)
	{
		Random rd = new Random();

		int randomRelation;
		int count = 0;
		int maxRelation = numberOfRelationship / 1000000;

		for (int i = 0; i < numberOfRelationship; i++)
		{
			randomRelation = rd.nextInt(19);
			if(randomRelation == 0)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listIRIRelationPersonPerson.get(rd.nextInt(listIRIRelationPersonPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 1)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listIRIRelationPersonEvent.get(rd.nextInt(listIRIRelationPersonEvent.size()));
				object    = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				model.add(subject, predicate, object);

				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listIRIRelationEventPerson.get(rd.nextInt(listIRIRelationEventPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 2)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listIRIRelationPersonLocation.get(rd.nextInt(listIRIRelationPersonLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				model.add(subject, predicate, object);

				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listIRIRelationLocationPerson.get(rd.nextInt(listIRIRelationLocationPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 3)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listIRIRelationPersonOrganization.get(rd.nextInt(listIRIRelationPersonOrganization.size()));
				object    = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				model.add(subject, predicate, object);

				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listIRIRelationOrganizationPerson.get(rd.nextInt(listIRIRelationOrganizationPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 4)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listIRIRelationPersonTime.get(rd.nextInt(listIRIRelationPersonTime.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 5)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listIRIRelationPersonCountry.get(rd.nextInt(listIRIRelationPersonCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);

				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listIRIRelationCountryPerson.get(rd.nextInt(listIRIRelationCountryPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size())); 
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 6)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listIRIRelationEventEvent.get(rd.nextInt(listIRIRelationEventEvent.size()));
				object    = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 7)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listIRIRelationEventLocation.get(rd.nextInt(listIRIRelationEventLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 8)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listIRIRelationEventOrganization.get(rd.nextInt(listIRIRelationEventOrganization.size()));
				object    = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				model.add(subject, predicate, object);

				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listIRIRelationOrganizationEvent.get(rd.nextInt(listIRIRelationOrganizationEvent.size()));
				object    = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 9)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				predicate = listIRIRelationEventTime.get(rd.nextInt(listIRIRelationEventTime.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 10)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listIRIRelationEventCountry.get(rd.nextInt(listIRIRelationEventCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);

				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listIRIRelationCountryEvent.get(rd.nextInt(listIRIRelationCountryEvent.size()));
				object    = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 11)
			{
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listIRIRelationLocationLocation.get(rd.nextInt(listIRIRelationLocationLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				model.add(subject, predicate, object);

			}
			else if(randomRelation == 12)
			{
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listIRIRelationLocationOrganization.get(rd.nextInt(listIRIRelationLocationOrganization.size()));
				object    = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				model.add(subject, predicate, object);

				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listIRIRelationOrganizationLocation.get(rd.nextInt(listIRIRelationOrganizationLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));				
				model.add(subject, predicate, object);

			}
			else if(randomRelation == 13)
			{
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listIRIRelationLocationTime.get(rd.nextInt(listIRIRelationLocationTime.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				model.add(subject, predicate, object);

			}
			else if(randomRelation == 14)
			{
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listIRIRelationLocationCountry.get(rd.nextInt(listIRIRelationLocationCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);

				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listIRIRelationCountryLocation.get(rd.nextInt(listIRIRelationCountryLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				model.add(subject, predicate, object);

			}
			else if(randomRelation == 15)
			{
				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listIRIRelationOrganizationTime.get(rd.nextInt(listIRIRelationOrganizationTime.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				model.add(subject, predicate, object);						

			}
			else if(randomRelation == 16)
			{
				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listIRIRelationOrganizationCountry.get(rd.nextInt(listIRIRelationOrganizationCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);

				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listIRIRelationCountryOrganization.get(rd.nextInt(listIRIRelationCountryOrganization.size()));
				object    = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 17)
			{
				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size())); 
				predicate = listIRIRelationCountryCountry.get(rd.nextInt(listIRIRelationCountryCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);

			}
			else if(randomRelation == 18)
			{
				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listIRIRelationCountryTime.get(rd.nextInt(listIRIRelationCountryTime.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				model.add(subject, predicate, object);

			}
			if(model.size() >= 1000000)
			{
				conn.add(model);
				model.clear();
				count++;
				System.out.println("count = " + count);
				if(count == maxRelation)
				{
					break;
				}
			}
		}
		conn.add(model);
		model.clear();
	}

	public void openConnectionCreIRIStatement()
	{
		conn = connection.getRepositoryConnection();
	}

	public void closeConnectionCreIRIStatement()
	{
		conn.close();
	}
}
