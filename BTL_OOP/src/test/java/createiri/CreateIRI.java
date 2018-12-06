package createiri;

import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

public class CreateIRI {
	public static Model CreateIri(RepositoryConnection conn, Model model) {
		String namespace = "http://shawdow.org/";
		ValueFactory vf = conn.getValueFactory();
		IRI huynh1 = vf.createIRI(namespace,"huynhid");
		IRI huynh2 = vf.createIRI(namespace , "huynhlabel");
		Random rd = new Random();
		model.add(huynh1, huynh2, vf.createLiteral("huynh" + rd.nextInt(5)));
		
		return model;
		
//		for (int i = 0; i < 5; i++) {
//			model.add(huynh1, huynh2, vf.createLiteral("huynh" + i));
//			if(model.size() == 70)
//			{
////				model.clear();
////				break;
//				conn.add(model);
//				model.clear();
//			}
//		}
	}
}
