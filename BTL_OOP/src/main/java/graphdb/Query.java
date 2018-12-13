package graphdb;

import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryEvaluationException;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

public class Query {

	private Connection connection;
	private RepositoryConnection conn;
	private long start, end;

	public Query()
	{
		connection = new Connection();
		conn = connection.getRepositoryConnection();
	}
	
	public ArrayList<String> queryBasic()
	{
		ArrayList<String> listResultQueryBasic = new ArrayList<String>();
		
		ArrayList<String> listQueryBasic = new ArrayList<String>();

		// Đưa ra tên tất cả các country có Continent là: Africa
		String strQuery1 = "PREFIX country: <http://shadow.org/country/>\n" +
				"SELECT DISTINCT ?object\n" +
				"WHERE {\n" +
				"?subject ?predicate \"Asia\".\n" +
				"?subject country:has_Label ?object.\n" +
				"}";
		
		// Đưa ra tên của tất cả các Person
		String strQuery2 =  "PREFIX person: <http://shadow.org/person/>\n" +
				"SELECT DISTINCT ?object\n" +
				"WHERE {\n" +
					"?subject person:has_Label ?object.\n" +
				"}";
		
		// Đưa ra tên tất cả các Organization bắt đầu bằng "UNESCO"
		String strQuery3 = "PREFIX organization: <http://shadow.org/organization/>\n" +
				"SELECT *\n" +
				"WHERE {\n" +
				"?subject organization:has_Label ?object.\n" +
				"FILTER (regex(?object,\"UNESCO\"))\n" +
				"}";
		
		// Đưa ra tên tất cả các Person làm Teacher
		String strQuery4 = "PREFIX person: <http://shadow.org/person/>\n" +
				"SELECT *\n" +
				"WHERE {\n" +
					"?subject person:has_Job \"Teacher\".\n" +
					"?subject person:has_Label ?object\n" +
				"}";
		
		
		
		listQueryBasic.add(strQuery1);
		listQueryBasic.add(strQuery2);
		listQueryBasic.add(strQuery3);
		listQueryBasic.add(strQuery4);
//		listQueryBasic.add(strQuery5);
//		listQueryBasic.add(strQuery6);
//		listQueryBasic.add(strQuery7);
//		listQueryBasic.add(strQuery8);
//		listQueryBasic.add(strQuery9);
//		listQueryBasic.add(strQuery10);


		for (int i = 0; i < listQueryBasic.size(); i++)
		{
//			System.out.println("\n*********************** Query " + (i+1) + " ******************************");
			listResultQueryBasic.add("*********************** Query " + (i+1) + " ******************************");
			
			start = System.currentTimeMillis();
			
			TupleQuery tupleQuery = conn.prepareTupleQuery(listQueryBasic.get(i));
			TupleQueryResult result = null;
			try 
			{
				result = tupleQuery.evaluate();
				while (result.hasNext())
				{
					BindingSet bindingSet = result.next();
					if(bindingSet.getValue("subject") != null)
					{
//						System.out.print(bindingSet.getValue("subject") + "\t");
						listResultQueryBasic.add(bindingSet.getValue("subject") + "\t");
					}
					if(bindingSet.getValue("predicate") != null)
					{
//						System.out.print(bindingSet.getValue("predicate") + "\t");
						listResultQueryBasic.add(bindingSet.getValue("predicate") + "\t");
					}
					if(bindingSet.getValue("object") != null)
					{
						listResultQueryBasic.add(handingQuery(bindingSet.getValue("object").toString()));
//						System.out.println(handingQuery(bindingSet.getValue("object").toString()));
//						System.out.println("\t" + bindingSet.getValue("object"));
					}
				}
			}
			catch (QueryEvaluationException qee) 
			{
				qee.printStackTrace();
			} 
			finally 
			{
				result.close();
			}
			end = System.currentTimeMillis();
//			System.out.println(("\nTime Query = ") + (end-start));
			listResultQueryBasic.add(("\nTime Query = ") + (end-start) + "\n\n\n");
		}
		
		return listResultQueryBasic;
	}

	public ArrayList<String> queryAdvance()
	{
		ArrayList<String> listResultQueryAdvance = new ArrayList<String>();
		
		return listResultQueryAdvance;
	}

	private String handingQuery(String object)
	{
		int lastIndex = object.lastIndexOf("\"");
		String result = object.substring(1, lastIndex);
		return result;
	}
	
	public void closeConnectionQuery()
	{
		conn.close();
	}
}
