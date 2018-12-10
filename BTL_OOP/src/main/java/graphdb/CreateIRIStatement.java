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
	
	private static RepositoryConnection conn = Connection.getRepositoryConnection();
	Model model = new TreeModel();
	ValueFactory valueFactory = conn.getValueFactory();
	IRI subject, predicate, object;
	CreateRandomEntity cre = new CreateRandomEntity();
	
	private String LABEL = "/has_Label";
	private String DESCRIPTION = "/has_Description";
	private String DATE = "/has_Date";
	private String LINK = "/has_Link";
	private String JOB = "/has_Job";
	private String CONTINENT = "/has_Continent";
	private String HEADQUARTER = "/has_Headquarter";
	
	protected IRI PERSON;
	protected IRI COUNTRY;
	protected IRI EVENT;
	protected IRI TIME;
	protected IRI LOCATION;
	protected IRI ORGANIZATION;
	protected IRI RELATIONSHIP;
	
	final String NAMESPACE = "http://shadow.org/";
	
	int listRelationPersonPersonSize   	   = listRelationPersonPerson.size();
	int listRelationPersonLocationSize 	   = listRelationPersonLocation.size();
	int listRelationPersonOrganizationSize = listRelationPersonOrganization.size();
	int listRelationPersonTimeSize		   = listRelationPersonTime.size();
	int listRelationPersonCountrySize      = listRelationPersonCountry.size();
	int listRelationPersonEventSize        = listRelationPersonEvent.size();
	
	int listRelationCountryPersonSize       = listRelationCountryPerson.size();
	int listRelationCountryEventSize        = listRelationCountryEvent.size();
	int listRelationCountryLocationSize     = listRelationCountryLocation.size();
	int listRelationCountryOrganizationSize = listRelationCountryOrganization.size();
	int listRelationCountryCountrySize      = listRelationCountryCountry.size();
	int listRelationCountryTimeSize         = listRelationCountryTime.size();
	
	int listRelationOrganizationPersonSize   = listRelationOrganizationPerson.size();
	int listRelationOrganizationEventSize    = listRelationOrganizationEvent.size();
	int listRelationOrganizationLocationSize = listRelationOrganizationLocation.size();
	int listRelationOrganizationTimeSize	 = listRelationOrganizationTime.size();
	int listRelationOrganizationCountrySize  = listRelationOrganizationCountry.size();
	
	int listRelationLocationPersonSize       = listRelationLocationPerson.size();
	int listRelationLocationLocationSize     = listRelationLocationLocation.size();
	int listRelationLocationOrganizationSize = listRelationLocationOrganization.size();
	int listRelationLocationTimeSize		 = listRelationLocationTime.size();
	int listRelationLocationCountrySize      = listRelationLocationCountry.size();
	
	int listRelationEventPersonSize    	   = listRelationEventPerson.size();
	int listRelationEventEventSize         = listRelationEventEvent.size();
	int listRelationEventLocationSize      = listRelationEventLocation.size();
	int listRelationEventOrganizationSize  = listRelationEventOrganization.size();
	int listRelationEventTimeSize		   = listRelationEventTime.size();
	int listRelationEventCountrySize       = listRelationEventCountry.size();
	
	public CreateIRIStatement()
	{
		super();
		
		PERSON = valueFactory.createIRI(NAMESPACE, "person");
		COUNTRY = valueFactory.createIRI(NAMESPACE, "country");
		EVENT = valueFactory.createIRI(NAMESPACE, "event");
		TIME = valueFactory.createIRI(NAMESPACE, "time");
		LOCATION = valueFactory.createIRI(NAMESPACE, "location");
		ORGANIZATION = valueFactory.createIRI(NAMESPACE, "organization");
		RELATIONSHIP = valueFactory.createIRI(NAMESPACE, "relationship");
	}
	
	// Create IRI and upload Entity
	public void createIRIPerson(ArrayList<Person> listPerson)
	{
		try
		{
			Literal object;
			
			for(Person person : listPerson)
			{
				subject = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				
				// Add name
				predicate = valueFactory.createIRI(PERSON.toString(), LABEL);
				object = valueFactory.createLiteral(person.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(PERSON.toString(), DESCRIPTION);
				object = valueFactory.createLiteral(person.getDescription());
				model.add(subject, predicate, object);
				
				// Add link
				predicate = valueFactory.createIRI(PERSON.toString(), LINK);
				object = valueFactory.createLiteral(person.getLink());
				model.add(subject, predicate, object);
				
				// Add date
				predicate = valueFactory.createIRI(PERSON.toString(), DATE);
				object = valueFactory.createLiteral(person.getDate());
				model.add(subject, predicate, object);
				
				// Add job
				predicate = valueFactory.createIRI(PERSON.toString(), JOB);
				object = valueFactory.createLiteral(person.getJob());
				model.add(subject, predicate, object);
				
				if(model.size() == 100000)
				{
					conn.add(model);
					model.clear();
				}
			}
			
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
				subject = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				
				// Add name
				predicate = valueFactory.createIRI(COUNTRY.toString(), LABEL);
				object = valueFactory.createLiteral(country.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(COUNTRY.toString(), DESCRIPTION);
				object = valueFactory.createLiteral(country.getDescription());
				model.add(subject, predicate, object);
				
				// Add link
				predicate = valueFactory.createIRI(COUNTRY.toString(), LINK);
				object = valueFactory.createLiteral(country.getLink());
				model.add(subject, predicate, object);
				
				// Add date
				predicate = valueFactory.createIRI(COUNTRY.toString(), DATE);
				object = valueFactory.createLiteral(country.getDate());
				model.add(subject, predicate, object);
				
				// Add continent
				predicate = valueFactory.createIRI(COUNTRY.toString(), CONTINENT);
				object = valueFactory.createLiteral(country.getContinent());
				model.add(subject, predicate, object);
				
				if(model.size() == 100000)
				{
					conn.add(model);
					model.clear();
				}
			}
			
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
				subject = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				
				// Add name
				predicate = valueFactory.createIRI(EVENT.toString(), LABEL);
				object = valueFactory.createLiteral(event.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(EVENT.toString(), DESCRIPTION);
				object = valueFactory.createLiteral(event.getDescription());
				model.add(subject, predicate, object);
				
				// Add link
				predicate = valueFactory.createIRI(EVENT.toString(), LINK);
				object = valueFactory.createLiteral(event.getLink());
				model.add(subject, predicate, object);
				
				// Add date
				predicate = valueFactory.createIRI(EVENT.toString(), DATE);
				object = valueFactory.createLiteral(event.getDate());
				model.add(subject, predicate, object);
				
				if(model.size() == 100000)
				{
					conn.add(model);
					model.clear();
				}
			}
			
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
				subject = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
				
				// Add name
				predicate = valueFactory.createIRI(LOCATION.toString(), LABEL);
				object = valueFactory.createLiteral(location.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(LOCATION.toString(), DESCRIPTION);
				object = valueFactory.createLiteral(location.getDescription());
				model.add(subject, predicate, object);
				
				// Add link
				predicate = valueFactory.createIRI(LOCATION.toString(), LINK);
				object = valueFactory.createLiteral(location.getLink());
				model.add(subject, predicate, object);
				
				// Add date
				predicate = valueFactory.createIRI(LOCATION.toString(), DATE);
				object = valueFactory.createLiteral(location.getDate());
				model.add(subject, predicate, object);
				
				if(model.size() == 100000)
				{
					conn.add(model);
					model.clear();
				}
			}
			
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
				subject = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				
				// Add name
				predicate = valueFactory.createIRI(ORGANIZATION.toString(), LABEL);
				object = valueFactory.createLiteral(organization.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(ORGANIZATION.toString(), DESCRIPTION);
				object = valueFactory.createLiteral(organization.getDescription());
				model.add(subject, predicate, object);
				
				// Add link
				predicate = valueFactory.createIRI(ORGANIZATION.toString(), LINK);
				object = valueFactory.createLiteral(organization.getLink());
				model.add(subject, predicate, object);
				
				// Add date
				predicate = valueFactory.createIRI(ORGANIZATION.toString(), DATE);
				object = valueFactory.createLiteral(organization.getDate());
				model.add(subject, predicate, object);

				// Add headquarter
				predicate = valueFactory.createIRI(ORGANIZATION.toString(), HEADQUARTER);
				object = valueFactory.createLiteral(organization.getHeadquarter());
				model.add(subject, predicate, object);
				
				if(model.size() == 100000)
				{
					conn.add(model);
					model.clear();
				}
			}
			
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
				subject = valueFactory.createIRI(TIME.toString(), "/time" + time.getId()+"");
				
				// Add name
				predicate = valueFactory.createIRI(TIME.toString(), LABEL);
				object = valueFactory.createLiteral(time.getName());
				model.add(subject, predicate, object);

				// Add description
				predicate = valueFactory.createIRI(TIME.toString(), DESCRIPTION);
				object = valueFactory.createLiteral(time.getDescription());
				model.add(subject, predicate, object);
				
				// Add link
				predicate = valueFactory.createIRI(TIME.toString(), LINK);
				object = valueFactory.createLiteral(time.getLink());
				model.add(subject, predicate, object);
				
				// Add date
				predicate = valueFactory.createIRI(TIME.toString(), DATE);
				object = valueFactory.createLiteral(time.getDate());
				model.add(subject, predicate, object);
				
				if(model.size() == 100000)
				{
					conn.add(model);
					model.clear();
				}
			}
			
			conn.add(model);
			model.clear();
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}

	// Create IRI and upload Relation
	public void uploadRelationData(int numberOfRelationship, ArrayList<Person>listPerson,
									ArrayList<Country>listCountry, ArrayList<Event>listEvent,
									ArrayList<Location>listLocation, ArrayList<Organization>listOrganization, ArrayList<Time>listTime)
	{
		int listPersonSize  	 = listPerson.size();
		int listCountrySize 	 = listCountry.size();
		int listEventSize   	 = listEvent.size();
		int listLocationSize 	 = listLocation.size();
		int listOrganizationSize = listOrganization.size();
		int listTimeSize         = listTime.size();
		
		Random rd = new Random();
		int temp = 0;
		int count = 0;
		int maxRelation = numberOfRelationship / 100000;
		for (int i = 0; i < numberOfRelationship; i++)
		{
			temp = rd.nextInt(10);
			if(temp == 0)
			{
				Person person1  = listPerson.get(rd.nextInt(listPersonSize));
				Person person2  = listPerson.get(rd.nextInt(listPersonSize));
				String relation = listRelationPersonPerson.get(rd.nextInt(listRelationPersonPersonSize));
				
				subject   = valueFactory.createIRI(PERSON.toString(), "/person" + person1.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(PERSON.toString(), "/person" + person2.getId());
				model.add(subject, predicate, object);
			}
			else if(temp == 1)
			{
				Person person   = listPerson.get(rd.nextInt(listPersonSize));
				Event event     = listEvent.get(rd.nextInt(listEventSize));
				String relation = listRelationPersonEvent.get(rd.nextInt(listRelationPersonEventSize));
				
				subject   = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				model.add(subject, predicate, object);

				subject   = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				relation  = listRelationEventPerson.get(rd.nextInt(listRelationEventPersonSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				model.add(subject, predicate, object);

			}
			else if(temp == 2)
			{
				Person person     = listPerson.get(rd.nextInt(listPersonSize));
				Location location = listLocation.get(rd.nextInt(listLocationSize));
				String relation   = listRelationPersonLocation.get(rd.nextInt(listRelationPersonLocationSize));
				
				subject   = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
				model.add(subject, predicate, object);
				
				subject   = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
				relation  = listRelationLocationPerson.get(rd.nextInt(listRelationLocationPersonSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				model.add(subject, predicate, object);
				
			}
			else if(temp == 3)
			{
				Person person             = listPerson.get(rd.nextInt(listPersonSize));
				Organization organization = listOrganization.get(rd.nextInt(listOrganizationSize));
				String relation           = listRelationPersonOrganization.get(rd.nextInt(listRelationPersonOrganizationSize));
				
				subject   = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				model.add(subject, predicate, object);
				
				subject   = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				relation  = listRelationOrganizationPerson.get(rd.nextInt(listRelationOrganizationPersonSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				model.add(subject, predicate, object);

			}
			else if(temp == 4)
			{
				Person person   = listPerson.get(rd.nextInt(listPersonSize));
				Time time       = listTime.get(rd.nextInt(listTimeSize));
				String relation = listRelationPersonTime.get(rd.nextInt(listRelationPersonTimeSize));
						
				subject   = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(TIME.toString(), "/time" + time.getId());
				model.add(subject, predicate, object);
				
			}
			else if(temp == 5)
			{
				Person person   = listPerson.get(rd.nextInt(listPersonSize));
				Country country = listCountry.get(rd.nextInt(listCountrySize));
				String relation = listRelationPersonCountry.get(rd.nextInt(listRelationPersonCountrySize));
				
				subject   = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				model.add(subject, predicate, object);

				subject   = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				relation  = listRelationCountryPerson.get(rd.nextInt(listRelationCountryPersonSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
				model.add(subject, predicate, object);
				
			}
			else if(temp == 6)
			{
				Event event1    = listEvent.get(rd.nextInt(listEventSize));
				Event event2    = listEvent.get(rd.nextInt(listEventSize));
				String relation = listRelationEventEvent.get(rd.nextInt(listRelationEventEventSize));

				subject   = valueFactory.createIRI(EVENT.toString(), "/event" + event1.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(EVENT.toString(), "/event" + event2.getId());
				model.add(subject, predicate, object);
				
			}
			else if(temp == 7)
			{
				Event event       = listEvent.get(rd.nextInt(listEventSize));
				Location location = listLocation.get(rd.nextInt(listLocationSize));
				String relation   = listRelationEventLocation.get(rd.nextInt(listRelationEventLocationSize));
						
				subject   = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
				model.add(subject, predicate, object);
						
			}
			else if(temp == 8)
			{
				Event event               = listEvent.get(rd.nextInt(listEventSize));
				Organization organization = listOrganization.get(rd.nextInt(listOrganizationSize));
				String relation           = listRelationEventOrganization.get(rd.nextInt(listRelationEventOrganizationSize));
				
				subject   = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				model.add(subject, predicate, object);
				
				subject   = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				relation  = listRelationOrganizationEvent.get(rd.nextInt(listRelationOrganizationEventSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				model.add(subject, predicate, object);

			}
			else if(temp == 9)
			{
				Event event     = listEvent.get(rd.nextInt(listEventSize));
				Time time       = listTime.get(rd.nextInt(listTimeSize));
				String relation = listRelationEventTime.get(rd.nextInt(listRelationEventTimeSize));
				
				subject   = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(TIME.toString(), "/time" + time.getId());
				model.add(subject, predicate, object);

			}
			else if(temp == 10)
			{
				Event event     = listEvent.get(rd.nextInt(listEventSize));
				Country country = listCountry.get(rd.nextInt(listCountrySize));
				String relation = listRelationEventCountry.get(rd.nextInt(listRelationEventCountrySize));
				
				subject   = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				model.add(subject, predicate, object);
				
				subject   = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				relation  = listRelationCountryEvent.get(rd.nextInt(listRelationCountryEventSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
				model.add(subject, predicate, object);

			}
			else if(temp == 11)
			{
				Location location1 = listLocation.get(rd.nextInt(listLocationSize));
				Location location2 = listLocation.get(rd.nextInt(listLocationSize));
				String relation    = listRelationLocationLocation.get(rd.nextInt(listRelationLocationLocationSize));
				
				subject   = valueFactory.createIRI(LOCATION.toString(), "/location" + location1.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(LOCATION.toString(), "/location" + location2.getId());
				model.add(subject, predicate, object);

			}
			else if(temp == 12)
			{
				Location location         = listLocation.get(rd.nextInt(listLocationSize));
				Organization organization = listOrganization.get(rd.nextInt(listOrganizationSize));
				String relation           = listRelationLocationOrganization.get(rd.nextInt(listRelationLocationOrganizationSize));
				
				subject   = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				model.add(subject, predicate, object);
				
				subject   = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				relation  = listRelationOrganizationLocation.get(rd.nextInt(listRelationOrganizationLocationSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());				
				model.add(subject, predicate, object);

			}
			else if(temp == 13)
			{
				Location location = listLocation.get(rd.nextInt(listLocationSize));
				Time time         = listTime.get(rd.nextInt(listTimeSize));
				String relation   = listRelationLocationTime.get(rd.nextInt(listRelationLocationTimeSize));
				
				subject   = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(TIME.toString(), "/time" + time.getId());
				model.add(subject, predicate, object);

			}
			else if(temp == 14)
			{
				Location location = listLocation.get(rd.nextInt(listLocationSize));
				Country country   = listCountry.get(rd.nextInt(listCountrySize));
				String relation   = listRelationLocationCountry.get(rd.nextInt(listRelationLocationCountrySize));
				
				subject   = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				model.add(subject, predicate, object);
				
				subject   = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				relation  = listRelationCountryLocation.get(rd.nextInt(listRelationCountryLocationSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
				model.add(subject, predicate, object);
						
			}
			else if(temp == 15)
			{
				Organization organization = listOrganization.get(rd.nextInt(listOrganizationSize));
				Time time                 = listTime.get(rd.nextInt(listTimeSize));
				String relation           = listRelationOrganizationTime.get(rd.nextInt(listRelationOrganizationTimeSize));
				
				subject   = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(TIME.toString(), "/time" + time.getId());
				model.add(subject, predicate, object);						
						
			}
			else if(temp == 16)
			{
				Organization organization = listOrganization.get(rd.nextInt(listOrganizationSize));
				Country country           = listCountry.get(rd.nextInt(listCountrySize));
				String relation           = listRelationOrganizationCountry.get(rd.nextInt(listRelationOrganizationCountrySize));
				
				subject   = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				model.add(subject, predicate, object);
				
				subject   = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				relation  = listRelationCountryOrganization.get(rd.nextInt(listRelationCountryOrganizationSize));
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
				model.add(subject, predicate, object);
						
			}
			else if(temp == 17)
			{
				Country country1 = listCountry.get(rd.nextInt(listCountrySize)); 
				Country country2 = listCountry.get(rd.nextInt(listCountrySize));
				String relation  = listRelationCountryCountry.get(rd.nextInt(listRelationCountryCountrySize));
				
				subject   = valueFactory.createIRI(COUNTRY.toString(), "/country" + country1.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(COUNTRY.toString(), "/country" + country2.getId());
				model.add(subject, predicate, object);
						
			}
			else if(temp == 18)
			{
				Country country = listCountry.get(rd.nextInt(listCountrySize));
				Time time       = listTime.get(rd.nextInt(listTimeSize));
				String relation = listRelationCountryTime.get(rd.nextInt(listRelationCountryTimeSize));
				
				subject   = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
				predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
				object    = valueFactory.createIRI(TIME.toString(), "/time" + time.getId());
				model.add(subject, predicate, object);
						
			}
			if(model.size() == 100000)
			{
				conn.add(model);
				model.clear();
				count++;
				if(count == maxRelation)
				{
					break;
				}
			}
//			System.gc();
		}
		conn.add(model);
		model.clear();
	}
}
