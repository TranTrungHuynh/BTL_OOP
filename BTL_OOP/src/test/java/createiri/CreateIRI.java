package createiri;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

public class CreateIRI {
	public static void CreateIri(RepositoryConnection conn, Model model) {
		String namespace = "http://shawdow.org/";
		ValueFactory vf = conn.getValueFactory();
		IRI huynh1 = vf.createIRI(namespace,"huynhid");
		IRI huynh2 = vf.createIRI(namespace , "huynhlabel");
		
		for (int i = 0; i < 5; i++) {
			model.add(huynh1, huynh2, vf.createLiteral("huynh" + i));
			if(model.size() == 70)
			{
//				model.clear();
				break;
			}
		}
	}
}
