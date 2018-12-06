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
import model.Country;
import model.Entity;
import model.Event;
import model.Location;
import model.Organization;
import model.Person;
import model.Time;

public class CreateIRIStatement extends IRIConstant {
	private static RepositoryConnection conn = Connection.getRepositoryConnection();
	Model model = new TreeModel();
	CreateRandomEntity cre = new CreateRandomEntity();
	
	private ArrayList<String> listRelationPersonCountry        = cre.getListRelationPersonCountry();
	private ArrayList<String> listRelationPersonTime           = cre.getListRelationPersonTime();
	private ArrayList<String> listRelationPersonPerson         = cre.getListRelationPersonPerson();
	private ArrayList<String> listRelationPersonOrganization   = cre.getListRelationPersonOrganization();
	private ArrayList<String> listRelationPersonLocation       = cre.getListRelationPersonLocation();
	private ArrayList<String> listRelationPersonEvent		   = cre.getListRelationPersonEvent();
	
	private ArrayList<String> listRelationEventCountry         = cre.getListRelationEventCountry();
	private ArrayList<String> listRelationEventEvent           = cre.getListRelationEventEvent();
	private ArrayList<String> listRelationEventLocation        = cre.getListRelationEventLocation();
	private ArrayList<String> listRelationEventOrganization    = cre.getListRelationEventOrganization();
	private ArrayList<String> listRelationEventPerson 		   = cre.getListRelationEventPerson();
	private ArrayList<String> listRelationEventTime            = cre.getListRelationEventTime();
	
	private ArrayList<String> listRelationLocationCountry      = cre.getListRelationLocationCountry();
	private ArrayList<String> listRelationLocationPerson       = cre.getListRelationLocationPerson();
	private ArrayList<String> listRelationLocationOrganization = cre.getListRelationLocationOrganization();
	private ArrayList<String> listRelationLocationLocation     = cre.getListRelationLocationLocation();
	private ArrayList<String> listRelationLocationTime         = cre.getListRelationLocationTime();
	
	private ArrayList<String> listRelationOrganizationCountry  = cre.getListRelationOrganizationCountry();
	private ArrayList<String> listRelationOrganizationTime     = cre.getListRelationOrganizationTime();
	private ArrayList<String> listRelationOrganizationLocation = cre.getListRelationOrganizationLocation();
	private ArrayList<String> listRelationOrganizationEvent    = cre.getListRelationOrganizationEvent();
	private ArrayList<String> listRelationOrganizationPerson   = cre.getListRelationOrganizationPerson();
	
	private ArrayList<String> listRelationCountryCountry       = cre.getListRelationCountryCountry();
	private ArrayList<String> listRelationCountryTime          = cre.getListRelationCountryTime();
	private ArrayList<String> listRelationCountryPerson        = cre.getListRelationCountryPerson();
	private ArrayList<String> listRelationCountryEvent         = cre.getListRelationCountryEvent();
	private ArrayList<String> listRelationCountryOrganization  = cre.getListRelationCountryOrganization();
	private ArrayList<String> listRelationCountryLocation      = cre.getListRelationCountryLocation();
	
	public CreateIRIStatement()
	{
		super();
	}
	
	// Create IRI and upload Entity
	public void createIRIPerson(ArrayList<Person> listPerson)
	{
		Model model = new TreeModel();
		try
		{
			ValueFactory valueFactory = conn.getValueFactory();
			IRI subject, predicate;
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
			
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRICountry(ArrayList<Country> listCountry)
	{
		Model model = new TreeModel();
		try
		{
			ValueFactory valueFactory = conn.getValueFactory();
			IRI subject, predicate;
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
			
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRIEvent(ArrayList<Event> listEvent)
	{
		Model model = new TreeModel();
		try
		{
			ValueFactory valueFactory = conn.getValueFactory();
			IRI subject, predicate;
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
			
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRILocation(ArrayList<Location> listLocation)
	{
		Model model = new TreeModel();
		try
		{
			ValueFactory valueFactory = conn.getValueFactory();
			IRI subject, predicate;
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
			
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRIOrganization(ArrayList<Organization> listOrganization)
	{
		Model model = new TreeModel();
		try
		{
			ValueFactory valueFactory = conn.getValueFactory();
			IRI subject, predicate;
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

		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	public void createIRITime(ArrayList<Time> listTime)
	{
		Model model = new TreeModel();
		try
		{
			ValueFactory valueFactory = conn.getValueFactory();
			IRI subject, predicate;
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
		Random rd = new Random();
		int temp = 0;
		int listPersonSize  	 = listPerson.size();
		int listCountrySize 	 = listCountry.size();
		int listEventSize   	 = listEvent.size();
		int listLocationSize 	 = listLocation.size();
		int listOrganizationSize = listOrganization.size();
		int listTimeSize         = listTime.size();
		
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
		
		for (int i = 0; i < numberOfRelationship; i++)
		{
			temp = rd.nextInt(19);
			if(temp == 0)
			{
				createIRIRelationPersonPerson(
						listPerson.get(rd.nextInt(listPersonSize)),
						listPerson.get(rd.nextInt(listPersonSize)),
						listRelationPersonPerson.get(rd.nextInt(listRelationPersonPersonSize)));
			}
			else if(temp == 1)
			{
				createIRIRelationPersonEvent(
						listPerson.get(rd.nextInt(listPersonSize)), 
						listEvent.get(rd.nextInt(listEventSize)),
						listRelationPersonEvent.get(rd.nextInt(listRelationPersonEventSize)));
				createIRIRelationEventPerson(
						listEvent.get(rd.nextInt(listEventSize)),
						listPerson.get(rd.nextInt(listPersonSize)),
						listRelationEventPerson.get(rd.nextInt(listRelationEventPersonSize)));
			}
			else if(temp == 2)
			{
				createIRIRelationPersonLocation(
						listPerson.get(rd.nextInt(listPersonSize)),
						listLocation.get(rd.nextInt(listLocationSize)),
						listRelationPersonLocation.get(rd.nextInt(listRelationPersonLocationSize)));
				createIRIRelationLocationPerson(
						listLocation.get(rd.nextInt(listLocationSize)),
						listPerson.get(rd.nextInt(listPersonSize)),
						listRelationLocationPerson.get(rd.nextInt(listRelationLocationPersonSize)));
			}
			else if(temp == 3)
			{
				createIRIRelationPersonOrganization(
						listPerson.get(rd.nextInt(listPersonSize)),
						listOrganization.get(rd.nextInt(listOrganizationSize)),
						listRelationPersonOrganization.get(rd.nextInt(listRelationPersonOrganizationSize)));
				createIRIRelationOrganizationPerson(
						listOrganization.get(rd.nextInt(listOrganizationSize)),
						listPerson.get(rd.nextInt(listPersonSize)),
						listRelationOrganizationPerson.get(rd.nextInt(listRelationOrganizationPersonSize)));
			}
			else if(temp == 4)
			{
				createIRIRelationPersonTime(
						listPerson.get(rd.nextInt(listPersonSize)),
						listTime.get(rd.nextInt(listTimeSize)),
						listRelationPersonTime.get(rd.nextInt(listRelationPersonTimeSize)));
				
			}
			else if(temp == 5)
			{
				createIRIRelationPersonCountry(
						listPerson.get(rd.nextInt(listPersonSize)),
						listCountry.get(rd.nextInt(listCountrySize)),
						listRelationPersonCountry.get(rd.nextInt(listRelationPersonCountrySize)));
				createIRIRelationCountryPerson(
						listCountry.get(rd.nextInt(listCountrySize)),
						listPerson.get(rd.nextInt(listPersonSize)),
						listRelationCountryPerson.get(rd.nextInt(listRelationCountryPersonSize)));
				
			}
			else if(temp == 6)
			{
				createIRIRelationEventEvent(
						listEvent.get(rd.nextInt(listEventSize)),
						listEvent.get(rd.nextInt(listEventSize)),
						listRelationEventEvent.get(rd.nextInt(listRelationEventEventSize)));
				
			}
			else if(temp == 7)
			{
				createIRIRelationEventLocation(
						listEvent.get(rd.nextInt(listEventSize)), 
						listLocation.get(rd.nextInt(listLocationSize)), 
						listRelationEventLocation.get(rd.nextInt(listRelationEventLocationSize)));
			}
			else if(temp == 8)
			{
				createIRIRelationEventOrganization(
						listEvent.get(rd.nextInt(listEvent.size())), 
						listOrganization.get(rd.nextInt(listOrganizationSize)), 
						listRelationEventOrganization.get(rd.nextInt(listRelationEventOrganizationSize)));
				createIRIRelationOrganizationEvent(
						listOrganization.get(rd.nextInt(listOrganizationSize)), 
						listEvent.get(rd.nextInt(listEvent.size())), 
						listRelationOrganizationEvent.get(rd.nextInt(listRelationOrganizationEventSize)));
			}
			else if(temp == 9)
			{
				createIRIRelationEventTime(
						listEvent.get(rd.nextInt(listEventSize)), 
						listTime.get(rd.nextInt(listTimeSize)), 
						listRelationEventTime.get(rd.nextInt(listRelationEventTimeSize)));
			}
			else if(temp == 10)
			{
				createIRIRelationEventCountry(
						listEvent.get(rd.nextInt(listEventSize)), 
						listCountry.get(rd.nextInt(listCountrySize)), 
						listRelationEventCountry.get(rd.nextInt(listRelationEventCountrySize)));
				createIRIRelationCountryEvent(
						listCountry.get(rd.nextInt(listCountrySize)), 
						listEvent.get(rd.nextInt(listEventSize)), 
						listRelationCountryEvent.get(rd.nextInt(listRelationCountryEventSize)));
			}
			else if(temp == 11)
			{
				createIRIRelationLocationLocation(
						listLocation.get(rd.nextInt(listLocationSize)), 
						listLocation.get(rd.nextInt(listLocationSize)), 
						listRelationLocationLocation.get(rd.nextInt(listRelationLocationLocationSize)));
			}
			else if(temp == 12)
			{
				createIRIRelationLocationOrganization(
						listLocation.get(rd.nextInt(listLocationSize)), 
						listOrganization.get(rd.nextInt(listOrganizationSize)),
						listRelationLocationOrganization.get(rd.nextInt(listRelationLocationOrganizationSize)));
				createIRIRelationOrganizationLocation(
						listOrganization.get(rd.nextInt(listOrganizationSize)), 
						listLocation.get(rd.nextInt(listLocationSize)), 
						listRelationOrganizationLocation.get(rd.nextInt(listRelationOrganizationLocationSize)));
			}
			else if(temp == 13)
			{
				createIRIRelationLocationTime(
						listLocation.get(rd.nextInt(listLocationSize)), 
						listTime.get(rd.nextInt(listTimeSize)), 
						listRelationLocationTime.get(rd.nextInt(listRelationLocationTimeSize)));
			}
			else if(temp == 14)
			{
				createIRIRelationLocationCountry(
						listLocation.get(rd.nextInt(listLocationSize)), 
						listCountry.get(rd.nextInt(listCountrySize)), 
						listRelationLocationCountry.get(rd.nextInt(listRelationLocationCountrySize)));
				createIRIRelationCountryLocation(
						listCountry.get(rd.nextInt(listCountrySize)), 
						listLocation.get(rd.nextInt(listLocationSize)), 
						listRelationCountryLocation.get(rd.nextInt(listRelationCountryLocationSize)));
			}
			else if(temp == 15)
			{
				createIRIRelationOrganizationTime(
						listOrganization.get(rd.nextInt(listOrganizationSize)), 
						listTime.get(rd.nextInt(listTimeSize)), 
						listRelationOrganizationTime.get(rd.nextInt(listRelationOrganizationTimeSize)));
			}
			else if(temp == 16)
			{
				createIRIRelationOrganizationCountry(
						listOrganization.get(rd.nextInt(listOrganizationSize)), 
						listCountry.get(rd.nextInt(listCountrySize)), 
						listRelationOrganizationCountry.get(rd.nextInt(listRelationOrganizationCountrySize)));
				createIRIRelationCountryOrganization(
						listCountry.get(rd.nextInt(listCountrySize)), 
						listOrganization.get(rd.nextInt(listOrganizationSize)), 
						listRelationCountryOrganization.get(rd.nextInt(listRelationCountryOrganizationSize)));
			}
			else if(temp == 17)
			{
				createIRIRelationCountryCountry(
						listCountry.get(rd.nextInt(listCountrySize)), 
						listCountry.get(rd.nextInt(listCountrySize)), 
						listRelationCountryCountry.get(rd.nextInt(listRelationCountryCountrySize)));
			}
			else if(temp == 18)
			{
				createIRIRelationCountryTime(
						listCountry.get(rd.nextInt(listCountrySize)),
						listTime.get(rd.nextInt(listTimeSize)),
						listRelationCountryTime.get(rd.nextInt(listRelationCountryTimeSize)));
			}
			if(model.size() == 100000)
			{
				conn.add(model);
				model.clear();
			}
		}
		conn.add(model);
	}
	
	
	public void createIRIRelationPersonOrganization(Person person, Organization organization, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriPerson(person, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriOrganization(organization, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationPersonCountry(Person person, Country country, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriPerson(person, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriCountry(country, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationPersonEvent(Person person, Event event, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriPerson(person, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriEvent(event, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationPersonLocation(Person person, Location location, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriPerson(person, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriLocation(location, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationPersonPerson(Person person1, Person person2, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriPerson(person1, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriPerson(person2, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationPersonTime(Person person, Time time, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriPerson(person, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriTime(time, valueFactory);
		
		model.add(subject, predicate, object);
	}
	
	public void createIRIRelationCountryCountry(Country country1, Country country2, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriCountry(country1, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriCountry(country2, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationCountryOrganization(Country country, Organization organization, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriCountry(country, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriOrganization(organization, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationCountryTime(Country country, Time time, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriCountry(country, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriTime(time, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationCountryPerson(Country country, Person person, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriCountry(country, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriPerson(person, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationCountryLocation(Country country, Location location, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriCountry(country, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriLocation(location, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationCountryEvent(Country country, Event event, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriCountry(country, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriEvent(event, valueFactory);
		
		model.add(subject, predicate, object);
	}
	
	public void createIRIRelationEventPerson(Event event, Person person, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriEvent(event, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriPerson(person, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationEventCountry(Event event, Country country, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriEvent(event, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriCountry(country, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationEventEvent(Event event1, Event event2, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriEvent(event1, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriEvent(event2, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationEventOrganization(Event event, Organization organization, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriEvent(event, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriOrganization(organization, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationEventTime(Event event, Time time, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriEvent(event, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriTime(time, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationEventLocation(Event event, Location location, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriEvent(event, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriLocation(location, valueFactory);
		
		model.add(subject, predicate, object);
	}
	
	public void createIRIRelationLocationPerson(Location location, Person person, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriLocation(location, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriPerson(person, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationLocationCountry(Location location, Country country, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriLocation(location, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriCountry(country, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationLocationOrganization(Location location, Organization organization, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriLocation(location, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriOrganization(organization, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationLocationTime(Location location, Time time, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriLocation(location, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriTime(time, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationLocationLocation(Location location1, Location location2, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriLocation(location1, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriLocation(location2, valueFactory);
		
		model.add(subject, predicate, object);
	}
	
	public void createIRIRelationOrganizationPerson(Organization organization, Person person, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriOrganization(organization, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriPerson(person, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationOrganizationLocation(Organization organization, Location location, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriOrganization(organization, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriLocation(location, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationOrganizationEvent(Organization organization, Event event, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriOrganization(organization, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriEvent(event, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationOrganizationCountry(Organization organization, Country country, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriOrganization(organization, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriCountry(country, valueFactory);
		
		model.add(subject, predicate, object);
	}
	public void createIRIRelationOrganizationTime(Organization organization, Time time, String relation)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject, predicate, object;
		
		subject   = iriOrganization(organization, valueFactory);
		predicate = iriRelation(relation, valueFactory);
		object    = iriTime(time, valueFactory);
		
		model.add(subject, predicate, object);
	}

	
	private IRI iriPerson(Person person, ValueFactory valueFactory)
	{
		return valueFactory.createIRI(PERSON.toString(), "/person" + person.getId());
	}
	private IRI iriCountry(Country country, ValueFactory valueFactory)
	{
		return valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId());
	}
	private IRI iriEvent(Event event, ValueFactory valueFactory)
	{
		return valueFactory.createIRI(EVENT.toString(), "/event" + event.getId());
	}
	private IRI iriLocation(Location location, ValueFactory valueFactory)
	{
		return valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId());
	}
	private IRI iriOrganization(Organization organization, ValueFactory valueFactory)
	{
		return valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId());
	}
	private IRI iriTime(Time time, ValueFactory valueFactory)
	{
		return valueFactory.createIRI(TIME.toString(), "/time" + time.getId());
	}
	private IRI iriRelation(String relation, ValueFactory valueFactory)
	{
		return valueFactory.createIRI(RELATIONSHIP.toString(), "/" + relation);
	}
}
