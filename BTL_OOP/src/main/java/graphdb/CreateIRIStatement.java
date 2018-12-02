package graphdb;

import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import model.Country;
import model.Entity;
import model.Event;
import model.Location;
import model.Organization;
import model.Person;
import model.Time;

public class CreateIRIStatement extends IRIConstant {
	private static RepositoryConnection conn = Connection.getRepositoryConnection();
	
	public CreateIRIStatement()
	{
		super();
	}
	
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

	public void createIRIRelationship(Entity entity1, Entity entity2, String listRelationship)
	{
		try
		{
			ValueFactory valueFactory = conn.getValueFactory();
			
			IRI subject, predicate, object;
			
			subject = checkEntity(entity1);
			
			predicate = valueFactory.createIRI(RELATIONSHIP.toString(), "_" + listRelationship);
			
			object = checkEntity(entity2);
			
			conn.add(subject, predicate, object);
			
		}
		catch (Exception Ex)
		{
			Ex.printStackTrace();
		}
	}
	
	public IRI checkEntity(Entity entity)
	{
		ValueFactory valueFactory = conn.getValueFactory();
		IRI subject;
		
		IRI result = null;
		
		if(entity instanceof Person)
		{
			Person person = (Person) entity;
			result = valueFactory.createIRI(PERSON.toString(), "/person" + person.getId()+"");
		}
		else if(entity instanceof Country)
		{
			Country country = (Country) entity;
			result = valueFactory.createIRI(COUNTRY.toString(), "/country" + country.getId()+"");
		}
		else if(entity instanceof Event)
		{
			Event event = (Event) entity;
			result = valueFactory.createIRI(EVENT.toString(), "/event" + event.getId()+"");
		}
		else if(entity instanceof Location)
		{
			Location location = (Location) entity;
			result = valueFactory.createIRI(LOCATION.toString(), "/location" + location.getId()+"");
		}
		else if(entity instanceof Organization)
		{
			Organization organization = (Organization) entity;
			result = valueFactory.createIRI(ORGANIZATION.toString(), "/organization" + organization.getId()+"");
		}
		else if(entity instanceof Time)
		{
			Time time = (Time) entity;
			result = valueFactory.createIRI(TIME.toString(), "/time" + time.getId()+"");
		}
		
		return result;
	}
}
