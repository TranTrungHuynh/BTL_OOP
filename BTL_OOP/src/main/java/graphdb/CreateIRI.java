package graphdb;

import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import file.io.ReadFile;

public class CreateIRI extends ReadFile {
	private Connection connection = new Connection();
	private RepositoryConnection conn = connection.getRepositoryConnection();
	private ValueFactory valueFactory = conn.getValueFactory();

	private final String RELATIONSHIP = "http://shadow.org/relationship/";
	private IRI relationIRI;

	// IRI
	protected final String LABEL        = "/has_Label";
	protected final String DESCRIPTION  = "/has_Description";
	protected final String DATE         = "/has_Date";
	protected final String LINK         = "/has_Link";
	protected final String JOB          = "/has_Job";
	protected final String CONTINENT    = "/has_Continent";
	protected final String HEADQUARTER  = "/has_Headquarter";

	protected final String PERSON       = "http://shadow.org/person";
	protected final String COUNTRY      = "http://shadow.org/country";
	protected final String EVENT        = "http://shadow.org/event";
	protected final String TIME         = "http://shadow.org/time";
	protected final String LOCATION     = "http://shadow.org/location"; 
	protected final String ORGANIZATION = "http://shadow.org/organization";

	protected final IRI iriPERSON;
	protected final IRI iriCOUNTRY;
	protected final IRI iriEVENT;
	protected final IRI iriTIME;
	protected final IRI iriLOCATION;
	protected final IRI iriORGANIZATION;

	// Relation
	protected ArrayList<IRI> listIRIRelationPersonCountry;
	protected ArrayList<IRI> listIRIRelationPersonTime;
	protected ArrayList<IRI> listIRIRelationPersonPerson;
	protected ArrayList<IRI> listIRIRelationPersonOrganization;
	protected ArrayList<IRI> listIRIRelationPersonLocation;
	protected ArrayList<IRI> listIRIRelationPersonEvent;
                                 
	protected ArrayList<IRI> listIRIRelationEventCountry;
	protected ArrayList<IRI> listIRIRelationEventEvent;
	protected ArrayList<IRI> listIRIRelationEventLocation;
	protected ArrayList<IRI> listIRIRelationEventOrganization;
	protected ArrayList<IRI> listIRIRelationEventPerson;
	protected ArrayList<IRI> listIRIRelationEventTime;
                                 
	protected ArrayList<IRI> listIRIRelationLocationCountry;
	protected ArrayList<IRI> listIRIRelationLocationPerson;
	protected ArrayList<IRI> listIRIRelationLocationOrganization;
	protected ArrayList<IRI> listIRIRelationLocationLocation;
	protected ArrayList<IRI> listIRIRelationLocationTime;
                                 
	protected ArrayList<IRI> listIRIRelationOrganizationCountry;
	protected ArrayList<IRI> listIRIRelationOrganizationTime;
	protected ArrayList<IRI> listIRIRelationOrganizationLocation;
	protected ArrayList<IRI> listIRIRelationOrganizationEvent;
	protected ArrayList<IRI> listIRIRelationOrganizationPerson;
                                 
	protected ArrayList<IRI> listIRIRelationCountryCountry;
	protected ArrayList<IRI> listIRIRelationCountryTime;
	protected ArrayList<IRI> listIRIRelationCountryPerson;
	protected ArrayList<IRI> listIRIRelationCountryEvent;
	protected ArrayList<IRI> listIRIRelationCountryOrganization;
	protected ArrayList<IRI> listIRIRelationCountryLocation;

	public CreateIRI() {
		super();
		
		iriPERSON           = valueFactory.createIRI(PERSON);
		iriCOUNTRY			= valueFactory.createIRI(COUNTRY);    
		iriEVENT			= valueFactory.createIRI(EVENT);
		iriTIME				= valueFactory.createIRI(TIME);
		iriLOCATION			= valueFactory.createIRI(LOCATION);
		iriORGANIZATION		= valueFactory.createIRI(ORGANIZATION);

		// Relation
		listIRIRelationPersonCountry        = new ArrayList<IRI>();
		listIRIRelationPersonTime           = new ArrayList<IRI>();
		listIRIRelationPersonEvent          = new ArrayList<IRI>();
		listIRIRelationPersonLocation       = new ArrayList<IRI>();
		listIRIRelationPersonOrganization   = new ArrayList<IRI>();
		listIRIRelationPersonPerson         = new ArrayList<IRI>();
            
		listIRIRelationEventCountry         = new ArrayList<IRI>();
		listIRIRelationEventEvent           = new ArrayList<IRI>();
		listIRIRelationEventLocation        = new ArrayList<IRI>();
		listIRIRelationEventOrganization    = new ArrayList<IRI>();
		listIRIRelationEventPerson          = new ArrayList<IRI>();
		listIRIRelationEventTime            = new ArrayList<IRI>();
            
		listIRIRelationLocationCountry      = new ArrayList<IRI>();
		listIRIRelationLocationLocation     = new ArrayList<IRI>();
		listIRIRelationLocationOrganization = new ArrayList<IRI>();
		listIRIRelationLocationPerson       = new ArrayList<IRI>();
		listIRIRelationLocationTime         = new ArrayList<IRI>();
            
		listIRIRelationOrganizationCountry  = new ArrayList<IRI>();
		listIRIRelationOrganizationEvent    = new ArrayList<IRI>();
		listIRIRelationOrganizationLocation = new ArrayList<IRI>();
		listIRIRelationOrganizationPerson   = new ArrayList<IRI>();
		listIRIRelationOrganizationTime     = new ArrayList<IRI>();
            
		listIRIRelationCountryCountry       = new ArrayList<IRI>();
		listIRIRelationCountryEvent         = new ArrayList<IRI>();
		listIRIRelationCountryLocation      = new ArrayList<IRI>();
		listIRIRelationCountryOrganization  = new ArrayList<IRI>();
		listIRIRelationCountryPerson        = new ArrayList<IRI>();
		listIRIRelationCountryTime          = new ArrayList<IRI>();

		// File Relation
		createIRIRelationPersonCountry();
		createIRIRelationPersonTime();
		createIRIRelationPersonEvent();
		createIRIRelationPersonLocation();
		createIRIRelationPersonOrganization();
		createIRIRelationPersonPerson();
        
		createIRIRelationEventCountry();
		createIRIRelationEventEvent();
		createIRIRelationEventLocation();
		createIRIRelationEventOrganization();
		createIRIRelationEventPerson();
		createIRIRelationEventTime();
        
		createIRIRelationLocationCountry();
		createIRIRelationLocationLocation();
		createIRIRelationLocationOrganization();
		createIRIRelationLocationPerson();
		createIRIRelationLocationTime();
        
		createIRIRelationOrganizationCountry();
		createIRIRelationOrganizationEvent();
		createIRIRelationOrganizationLocation();
		createIRIRelationOrganizationPerson();
		createIRIRelationOrganizationTime();
        
		createIRIRelationCountryCountry();
		createIRIRelationCountryEvent();
		createIRIRelationCountryLocation();
		createIRIRelationCountryOrganization();
		createIRIRelationCountryPerson();
		createIRIRelationCountryTime();
	}

	// relation Country
	private void createIRIRelationCountryTime() {
		for (String string : listRelationCountryTime) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationCountryTime.add(relationIRI);
		}
	}
	private void createIRIRelationCountryPerson() {
		for (String string : listRelationCountryPerson) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationCountryPerson.add(relationIRI);
		}
	}
	private void createIRIRelationCountryOrganization() {
		for (String string : listRelationCountryOrganization) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationCountryOrganization.add(relationIRI);
		}
	}
	private void createIRIRelationCountryLocation() {
		for (String string : listRelationCountryLocation) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationCountryLocation.add(relationIRI);
		}
	}
	private void createIRIRelationCountryEvent() {
		for (String string : listRelationCountryEvent) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationCountryEvent.add(relationIRI);
		}
	}
	private void createIRIRelationCountryCountry() {
		for (String string : listRelationCountryCountry) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationCountryCountry.add(relationIRI);
		}
	}

	// relation organization
	private void createIRIRelationOrganizationTime() {
		for (String string : listRelationOrganizationTime) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationOrganizationTime.add(relationIRI);
		}
	}
	private void createIRIRelationOrganizationPerson() {
		for (String string : listRelationOrganizationPerson) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationOrganizationPerson.add(relationIRI);
		}
	}
	private void createIRIRelationOrganizationLocation() {
		for (String string : listRelationOrganizationLocation) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationOrganizationLocation.add(relationIRI);
		}
	}
	private void createIRIRelationOrganizationEvent() {
		for (String string : listRelationOrganizationEvent) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationOrganizationEvent.add(relationIRI);
		}
	}
	private void createIRIRelationOrganizationCountry() {
		for (String string : listRelationOrganizationCountry) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationOrganizationCountry.add(relationIRI);
		}
	}

	// relation location
	private void createIRIRelationLocationTime() {
		for (String string : listRelationLocationTime) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationLocationTime.add(relationIRI);
		}
	}
	private void createIRIRelationLocationPerson() {
		for (String string : listRelationLocationPerson) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationLocationPerson.add(relationIRI);
		}
	}
	private void createIRIRelationLocationOrganization() {
		for (String string : listRelationLocationOrganization) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationLocationOrganization.add(relationIRI);
		}
	}
	private void createIRIRelationLocationLocation() {
		for (String string : listRelationLocationLocation) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationLocationLocation.add(relationIRI);
		}
	}
	private void createIRIRelationLocationCountry() {
		for (String string : listRelationLocationCountry) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationLocationCountry.add(relationIRI);
		}
	}

	// relation event
	private void createIRIRelationEventTime() {
		for (String string : listRelationEventTime) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationEventTime.add(relationIRI);
		}
	}
	private void createIRIRelationEventPerson() {
		for (String string : listRelationEventPerson) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationEventPerson.add(relationIRI);
		}
	}
	private void createIRIRelationEventOrganization() {
		for (String string : listRelationEventOrganization) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationEventOrganization.add(relationIRI);
		}
	}
	private void createIRIRelationEventLocation() {
		for (String string : listRelationEventLocation) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationEventLocation.add(relationIRI);
		}
	}
	private void createIRIRelationEventEvent() {
		for (String string : listRelationEventEvent) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationEventEvent.add(relationIRI);
		}
	}
	private void createIRIRelationEventCountry() {
		for (String string : listRelationEventCountry) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationEventCountry.add(relationIRI);
		}
	}

	// relation person
	private void createIRIRelationPersonPerson() {
		for (String string : listRelationPersonPerson) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationPersonPerson.add(relationIRI);
		}
	}
	private void createIRIRelationPersonOrganization() {
		for (String string : listRelationPersonOrganization) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationPersonOrganization.add(relationIRI);
		}
	}
	private void createIRIRelationPersonLocation() {
		for (String string : listRelationPersonLocation) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationPersonLocation.add(relationIRI);
		}
	}
	private void createIRIRelationPersonEvent() {
		for (String string : listRelationPersonEvent) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationPersonEvent.add(relationIRI);
		}
	}
	private void createIRIRelationPersonTime() {
		for (String string : listRelationPersonTime) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationPersonTime.add(relationIRI);
		}
	}
	private void createIRIRelationPersonCountry() {
		for (String string : listRelationPersonCountry) {
			relationIRI = valueFactory.createIRI(RELATIONSHIP, string);
			listIRIRelationPersonCountry.add(relationIRI);
		}
	}

}
