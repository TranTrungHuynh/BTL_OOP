package graphdb;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import create.entity.CreateRandomEntity;
import model.Entity;
import model.Event;
import model.Location;
import model.Organization;
import model.Person;
import model.Time;
import readfile.io.ReadFile;
import model.Country;

public class CreateIRIStatement extends ReadFile {
	
	private Connection connection;
	private RepositoryConnection conn;
	private Model model;
	private ValueFactory valueFactory;
	private IRI subject, predicate, object;
	
	// IRI
	private final String LABEL        = "/has_Label";
	private final String DESCRIPTION  = "/has_Description";
	private final String DATE         = "/has_Date";
	private final String LINK         = "/has_Link";
	private final String JOB          = "/has_Job";
	private final String CONTINENT    = "/has_Continent";
	private final String HEADQUARTER  = "/has_Headquarter";

	private final String PERSON       = "http://shadow.org/person";
	private final String COUNTRY      = "http://shadow.org/country";
	private final String EVENT        = "http://shadow.org/event";
	private final String TIME         = "http://shadow.org/time";
	private final String LOCATION     = "http://shadow.org/location"; 
	private final String ORGANIZATION = "http://shadow.org/organization";
	
	ArrayList<IRI> listIRIPerson;
	ArrayList<IRI> listIRICountry;
	ArrayList<IRI> listIRIOrganization;
	ArrayList<IRI> listIRIEvent;
	ArrayList<IRI> listIRITime;
	ArrayList<IRI> listIRILocation;
	
	public CreateIRIStatement()
	{
		super();
		
		connection = new Connection();
		openConnectionCreIRIStatement();
		valueFactory = conn.getValueFactory();
		model = new TreeModel();
		
		listIRIPerson       = new ArrayList<IRI>();
		listIRICountry      = new ArrayList<IRI>();
		listIRIEvent        = new ArrayList<IRI>();
		listIRITime         = new ArrayList<IRI>();
		listIRILocation     = new ArrayList<IRI>();
		listIRIOrganization = new ArrayList<IRI>();
	}
	
	// Create IRI and upload Entity
	public void createIRIPerson(ArrayList<Person> listPerson)
	{
		try
		{
			Literal object;
			
			for(Person person : listPerson)
			{
				subject = valueFactory.createIRI(PERSON, "/person" + person.getId());
				listIRIPerson.add(subject);
				
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
	public void createIRICountry(ArrayList<Country> listCountry)
	{
		try
		{
			Literal object;
			
			for (Country country : listCountry)
			{
				subject = valueFactory.createIRI(COUNTRY, "/country" + country.getId());
				listIRICountry.add(subject);
				
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
	public void createIRIEvent(ArrayList<Event> listEvent)
	{
		try
		{
			Literal object;
			
			for(Event event : listEvent)
			{
				subject = valueFactory.createIRI(EVENT, "/event" + event.getId());
				listIRIEvent.add(subject);
				
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
	public void createIRILocation(ArrayList<Location> listLocation)
	{
		try
		{
			Literal object;
			
			for(Location location : listLocation)
			{
				subject = valueFactory.createIRI(LOCATION, "/location" + location.getId());
				listIRILocation.add(subject);
				
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
	public void createIRIOrganization(ArrayList<Organization> listOrganization)
	{
		try
		{
			Literal object;
			
			for(Organization organization : listOrganization)
			{
				subject = valueFactory.createIRI(ORGANIZATION, "/organization" + organization.getId());
				listIRIOrganization.add(subject);
				
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
	public void createIRITime(ArrayList<Time> listTime)
	{
		try
		{
			Literal object;
			
			for(Time time : listTime)
			{
				subject = valueFactory.createIRI(TIME, "/time" + time.getId()+"");
				listIRITime.add(subject);
				
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
		int maxRelation = numberOfRelationship / 300000;
		
//		Model newModel = new TreeModel();
		
		for (int i = 0; i < numberOfRelationship; i++)
		{
			randomRelation = rd.nextInt(19);
			if(randomRelation == 0)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listRelationPersonPerson.get(rd.nextInt(listRelationPersonPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 1)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listRelationPersonEvent.get(rd.nextInt(listRelationPersonEvent.size()));
				object    = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				model.add(subject, predicate, object);

				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listRelationEventPerson.get(rd.nextInt(listRelationEventPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 2)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listRelationPersonLocation.get(rd.nextInt(listRelationPersonLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				model.add(subject, predicate, object);
				
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listRelationLocationPerson.get(rd.nextInt(listRelationLocationPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 3)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listRelationPersonOrganization.get(rd.nextInt(listRelationPersonOrganization.size()));
				object    = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				model.add(subject, predicate, object);
				
				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listRelationOrganizationPerson.get(rd.nextInt(listRelationOrganizationPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 4)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listRelationPersonTime.get(rd.nextInt(listRelationPersonTime.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 5)
			{
				subject   = listIRIPerson.get(rd.nextInt(listIRIPerson.size()));
				predicate = listRelationPersonCountry.get(rd.nextInt(listRelationPersonCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);

				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listRelationCountryPerson.get(rd.nextInt(listRelationCountryPerson.size()));
				object    = listIRIPerson.get(rd.nextInt(listIRIPerson.size())); 
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 6)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				object    = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listRelationEventEvent.get(rd.nextInt(listRelationEventEvent.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 7)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listRelationEventLocation.get(rd.nextInt(listRelationEventLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 8)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listRelationEventOrganization.get(rd.nextInt(listRelationEventOrganization.size()));
				object    = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				model.add(subject, predicate, object);
				
				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listRelationOrganizationEvent.get(rd.nextInt(listRelationOrganizationEvent.size()));
				object    = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 9)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				predicate = listRelationEventTime.get(rd.nextInt(listRelationEventTime.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 10)
			{
				subject   = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				predicate = listRelationEventCountry.get(rd.nextInt(listRelationEventCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);
				
				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listRelationCountryEvent.get(rd.nextInt(listRelationCountryEvent.size()));
				object    = listIRIEvent.get(rd.nextInt(listIRIEvent.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 11)
			{
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listRelationLocationLocation.get(rd.nextInt(listRelationLocationLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				model.add(subject, predicate, object);

			}
			else if(randomRelation == 12)
			{
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listRelationLocationOrganization.get(rd.nextInt(listRelationLocationOrganization.size()));
				object    = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				model.add(subject, predicate, object);
				
				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listRelationOrganizationLocation.get(rd.nextInt(listRelationOrganizationLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));				
				model.add(subject, predicate, object);

			}
			else if(randomRelation == 13)
			{
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listRelationLocationTime.get(rd.nextInt(listRelationLocationTime.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				model.add(subject, predicate, object);

			}
			else if(randomRelation == 14)
			{
				subject   = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				predicate = listRelationLocationCountry.get(rd.nextInt(listRelationLocationCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);
				
				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listRelationCountryLocation.get(rd.nextInt(listRelationCountryLocation.size()));
				object    = listIRILocation.get(rd.nextInt(listIRILocation.size()));
				model.add(subject, predicate, object);
						
			}
			else if(randomRelation == 15)
			{
				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listRelationOrganizationTime.get(rd.nextInt(listRelationOrganizationTime.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				model.add(subject, predicate, object);						
						
			}
			else if(randomRelation == 16)
			{
				subject   = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				predicate = listRelationOrganizationCountry.get(rd.nextInt(listRelationOrganizationCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);
				
				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listRelationCountryOrganization.get(rd.nextInt(listRelationCountryOrganization.size()));
				object    = listIRIOrganization.get(rd.nextInt(listIRIOrganization.size()));
				model.add(subject, predicate, object);
			}
			else if(randomRelation == 17)
			{
				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size())); 
				predicate = listRelationCountryCountry.get(rd.nextInt(listRelationCountryCountry.size()));
				object    = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				model.add(subject, predicate, object);
						
			}
			else if(randomRelation == 18)
			{
				subject   = listIRICountry.get(rd.nextInt(listIRICountry.size()));
				predicate = listRelationCountryTime.get(rd.nextInt(listRelationCountryTime.size()));
				object    = listIRITime.get(rd.nextInt(listIRITime.size()));
				model.add(subject, predicate, object);
						
			}
			if(model.size() >= 300000)
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
