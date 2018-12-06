package graphdb;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

public class Connection {
	// GraphDB 
	private static final String GRAPHDB_SERVER = "http://localhost:7200/";
	private static final String REPOSITORY_ID = "Test";

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
}
