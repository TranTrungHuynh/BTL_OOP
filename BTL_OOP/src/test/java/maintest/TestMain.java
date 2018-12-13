package maintest;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import io.ReadFile;
import model.test.Country;

public class TestMain {

	private static final String GRAPHDB_SERVER = "http://localhost:7200/";
	private static final String REPOSITORY_ID = "Test";
	private static RepositoryConnection repositoryConnection;

	public static RepositoryConnection getRepositoryConnection() {
		Repository repository = new HTTPRepository(GRAPHDB_SERVER, REPOSITORY_ID);
		try
		{
			repository.initialize();
			repositoryConnection = repository.getConnection();
			return repositoryConnection;
		}
		catch (RepositoryException Ex)
		{
			Ex.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		RepositoryConnection conn = getRepositoryConnection();
		
		ValueFactory vf = conn.getValueFactory();
		IRI subject = vf.createIRI("http://shadow.org/person");
		IRI predicate = vf.createIRI("http://shadow.org/relation");
		IRI object;
		Model model = new TreeModel();
		
		int count = 0;
		long start = System.currentTimeMillis();
		for(int i = 0; i  < 15000000; i++)
		{
			object = vf.createIRI("http://shadow.org/" + i);
			model.add(subject, predicate, object);
			if(model.size() == 300000)
			{
				conn.add(model);
				model.clear();
				System.out.println("count = " + ++count);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("end - start = " + (end-start));
	}
}
