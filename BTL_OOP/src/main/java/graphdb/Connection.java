package graphdb;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

public class Connection {
	// GraphDB 
	private final String GRAPHDB_SERVER = "http://localhost:7200/";
	private final String REPOSITORY_ID = "BTL_OOP_3";
	private RepositoryConnection repositoryConnection;

	public RepositoryConnection getRepositoryConnection() {
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
	
	public void closeConnection()
	{
		repositoryConnection.close();
	}
}
