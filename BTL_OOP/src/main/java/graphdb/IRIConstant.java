package graphdb;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;

public class IRIConstant {
	protected String LABEL = "/has_Label";
	protected String DESCRIPTION = "/has_Description";
	protected String DATE = "/has_Date";
	protected String LINK = "/has_Link";
	protected String JOB = "/has_Job";
	protected String CONTINENT = "/has_Continent";
	protected String HEADQUARTER = "/has_Headquarter";

	protected IRI PERSON;
	protected IRI COUNTRY;
	protected IRI EVENT;
	protected IRI TIME;
	protected IRI LOCATION;
	protected IRI ORGANIZATION;
	protected IRI RELATIONSHIP;

	final String NAMESPACE = "http://shadow.org/";
	
	ValueFactory valueFactory = Connection.getRepositoryConnection().getValueFactory();
	
	public IRIConstant()
	{
		PERSON = valueFactory.createIRI(NAMESPACE, "person");
		COUNTRY = valueFactory.createIRI(NAMESPACE, "country");
		EVENT = valueFactory.createIRI(NAMESPACE, "event");
		TIME = valueFactory.createIRI(NAMESPACE, "time");
		LOCATION = valueFactory.createIRI(NAMESPACE, "location");
		ORGANIZATION = valueFactory.createIRI(NAMESPACE, "organization");
		RELATIONSHIP = valueFactory.createIRI(NAMESPACE, "relationship");
	}
	
}
