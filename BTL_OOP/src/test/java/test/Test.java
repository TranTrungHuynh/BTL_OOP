package test;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import ch.qos.logback.core.net.SyslogOutputStream;
import createiri.CreateIRI;

public class Test {
	private static final String GRAPHDB_SERVER = "http://localhost:7200/";
	private static final String REPOSITORY_ID = "PersonData";

	public static RepositoryConnection getRepositoryConnection() {
		Repository repository = new HTTPRepository(GRAPHDB_SERVER, REPOSITORY_ID);
		try
		{
			repository.initialize();
			RepositoryConnection repositoryConnection = repository.getConnection();
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
		Model model = new TreeModel();
		
		long start = System.currentTimeMillis();
		
		
		
		String namespace = "http://shawdow.org/";
		ValueFactory vf = conn.getValueFactory();
		IRI huynh1 = vf.createIRI(namespace,"huynhid");
		IRI huynh2 = vf.createIRI(namespace , "huynhlabel");
		
		for (int i = 0; i < 10000; i++) {
			model = CreateIRI.CreateIri(conn, model);
//			model.add(huynh1, huynh2, vf.createLiteral("huynh" + i));
			System.out.println(model.size());
			if(model.size() == 70)
			{
				System.out.println(model.size());
//				model.clear();
				break;
			}
		}
		
		conn.add(model);
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
		System.out.println(model.size());
	}
	

}
