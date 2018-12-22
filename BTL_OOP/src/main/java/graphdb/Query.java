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
				"SELECT DISTINCT *\n" +
				"WHERE {\n" +
				"?subject organization:has_Label ?object.\n" +
				"FILTER (regex(?object,\"UNESCO\"))\n" +
				"}";
		
		// Đưa ra tên tất cả các Person làm Teacher
		String strQuery4 = "PREFIX person: <http://shadow.org/person/>\n" +
				"SELECT DISTINCT *\n" +
				"WHERE {\n" +
					"?subject person:has_Job \"Teacher\".\n" +
					"?subject person:has_Label ?object\n" +
				"}";
		
		// Đưa ra tổ chức có trụ sở ở "Delhi, India"
		String strQuery5 = "PREFIX organization: <http://shadow.org/organization/>\n" +
					"SELECT DISTINCT ?object\n" +
					"WHERE {\n" +
						"?subject organization:has_Label ?object.\n" +
						"?subject organization:has_Headquarter \"Delhi, India\".\n" +
					"}";
		
		// Đưa ra thời gian tổ chức sự kiện "Vietnam Tech Conference"
		String strQuery6 = "PREFIX event: <http://shadow.org/event/>\n" +
				"SELECT DISTINCT ?object\n" +
				"WHERE {\n" +
					"?subject event:has_Label \"Vietnam Tech Conference\".\n" +
					"?subject event:has_Date ?object.\n" +
					"}";
		
		// Mô tả về đất nước New Caledonia
		String strQuery7 = "PREFIX country: <http://shadow.org/country/>\n" +
				"SELECT DISTINCT ?object WHERE {\n" +
					"?subject country:has_Label \"New Caledonia\".\n" +
					"?subject country:has_Description ?object.\n" +
				"}";
		
		// Những người sinh sau năm 1998
		String strQuery8 = "PREFIX person: <http://shadow.org/person/>\n" +
				"SELECT DISTINCT ?object WHERE {\n" +
					"?subject person:has_Label ?object.\n" +
					"?subject person:has_Date ?date.\n" +
					"FILTER (year(?date) >= 1998)\n" +
				"}";
		
		// Thông tin của person1
		String strQuery9 = "PREFIX person: <http://shadow.org/person/>\n" +
				"SELECT ?predicate ?object\n" +
				"WHERE {\n" +
						"person:person1 ?predicate ?object.\n" +
				"}";
		
		// Đưa các các loại công việc của mọi người
		String strQuery10 = "PREFIX person: <http://shadow.org/person/>\n" +
				"SELECT DISTINCT ?object\n" +
				"WHERE {\n" +
				"?subject person:has_Job ?object.\n" +
				"}";
		
		listQueryBasic.add(strQuery1);
		listQueryBasic.add(strQuery2);
		listQueryBasic.add(strQuery3);
		listQueryBasic.add(strQuery4);
		listQueryBasic.add(strQuery5);
		listQueryBasic.add(strQuery6);
		listQueryBasic.add(strQuery7);
		listQueryBasic.add(strQuery8);
		listQueryBasic.add(strQuery9);
		listQueryBasic.add(strQuery10);


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
				String line = "";
				while (result.hasNext())
				{
					BindingSet bindingSet = result.next();
					if(bindingSet.getValue("subject") != null)
					{
						line += "subject: " + bindingSet.getValue("subject") + "\t\t\t";
					}
					if(bindingSet.getValue("predicate") != null)
					{
						line += "predicate: " + bindingSet.getValue("predicate") + "\t\t\t";
					}
					if(bindingSet.getValue("object") != null)
					{
						line += "object: " + handingQuery(bindingSet.getValue("object").toString());
					}
					listResultQueryBasic.add(line);
					line = "";
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
			listResultQueryBasic.add(("\nTime Query = ") + (end-start) + "\n\n\n");
		}
		
		return listResultQueryBasic;
	}

	public ArrayList<String> queryAdvance()
	{
		ArrayList<String> listResultQueryAdvance = new ArrayList<String>();
		ArrayList<String> listQueryAdvance = new ArrayList<String>();
		
		// Đưa ra các sự kiện diễn ra tại Cagliari, Italy vào các năm 2000, 2004, 2008
		String strQuery1 = "PREFIX event: <http://shadow.org/event/>\n" + 
				"PREFIX location: <http://shadow.org/location/>\n" + 
				"PREFIX time: <http://shadow.org/time/>\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\n" + 
				"SELECT DISTINCT ?object\r\n" + 
				"WHERE{\r\n" + 
					"?event relationship:held_At ?location.\n" + 
					"?location location:has_Label \"Cagliari, Italy\".\n" + 
					"?event relationship:held_On ?time.\n" + 
					"?time time:has_Label ?labelTime.\n" + 
					"?event event:has_Label ?object.\r\n" + 
					"FILTER(regex(?labelTime, \"2000\") ||\n" + 
					"regex(?labelTime, \"2004\") ||\n" + 
					"regex(?labelTime, \"2008\")\n" + 
					")\n" + 
				"}\n" + 
				"ORDER BY ?object";
		
		// Đưa ra những đất nước chuẩn bị sự kiện Industrial Components & Subcontracting Vietnam Hanoi vào tháng Nov
		String strQuery2 = "PREFIX event: <http://shadow.org/event/>\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\n" + 
				"PREFIX country: <http://shadow.org/country/>\n" + 
				"PREFIX time: <http://shadow.org/time/>\n" + 
					"SELECT DISTINCT ?object\r\n" + 
					"WHERE {\r\n" + 
					"?event event:has_Label \"Industrial Components & Subcontracting Vietnam Hanoi\".\n" + 
					"?event relationship:organization ?country.\n" + 
					"?country country:has_Label ?object.\n" + 
					"?event relationship:take_Place_On ?time.\n" + 
					"?time time:has_Label ?date.\n" + 
					"FILTER (regex(?date,\"Nov\"))\n" + 
				"}";
		
		// Đưa ra những người chuẩn bị sự kiện Vietbuild Home diễn ra ở Italy hoặc Indonesia
		String strQuery3 = "PREFIX person: <http://shadow.org/person/>\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\n" + 
				"PREFIX event: <http://shadow.org/event/>\n" + 
				"PREFIX location: <http://shadow.org/location/>\n" + 
				"SELECT DISTINCT ?object\n" + 
				"WHERE {\n" + 
					"?person person:has_Label ?object.\n" + 
					"?person relationship:prepare ?event .\n" + 
					"?event event:has_Label \"Vietbuild Home\" .\n" + 
					"?event relationship:take_Place_Of ?location.\n" + 
					"?location location:has_Label ?loca.\n" + 
					"FILTER (regex(?loca,\"Italy\")||regex(?loca,\"Indonesia\"))\n" + 
				"}\n" + 
				"ORDER BY ?object";
		
		// Những người được mời tham dự sự kiện Begin Edu Fair- Hanoi (Autumn  Edition) vào thời gian Nov. 4, 1991
		String strQuery4 = "PREFIX person: <http://shadow.org/person/>\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\n" + 
				"PREFIX time: <http://shadow.org/time/>\n" + 
				"PREFIX event: <http://shadow.org/event/>\n" + 
				"SELECT ?object\n" + 
				"WHERE {\n" + 
					"?event relationship:invite ?person.\n" + 
					"?person person:has_Label ?object.\r\n" + 
					"?person person:has_Job \"VP Accounting\".\n" + 
					"?event relationship:on ?time.\n" + 
					"?event event:has_Label \"Begin Edu Fair- Hanoi (Autumn  Edition)\".\n" + 
					"?time time:has_Label \"Nov. 4, 1991\".\n" + 
				"}";
		
		// Chọn tên những người làm nghề Senior Developer, tham gia chuẩn bị sự kiện nào đó tại địa điểm Abidjan, Ivory Coast
		String strQuery5 = "PREFIX organization: <http://shadow.org/organization/>\n" + 
				"PREFIX location: <http://shadow.org/location/>\n" + 
				"PREFIX person: <http://shadow.org/person/>\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\n" + 
				"SELECT ?object\n" + 
				"WHERE {\n" + 
					"?person person:has_Job \"Senior Developer\".\n" + 
					"?person person:has_Label ?object.\n" + 
					"?person relationship:prepare ?event.\n" + 
					"?event relationship:take_Place_Of ?location.\n" + 
					"?location location:has_Label \"Abidjan, Ivory Coast\".\n" + 
				"}";
		// Những phụ nữ tảo hôn sống tại Việt Nam? (Person có quan hệ mother với person khác và năm sinh của person con - năm sinh person mẹ < 18)
		String strQuery6 = "PREFIX person: <http://shadow.org/person/>\r\n" + 
				"PREFIX country: <http://shadow.org/country/>\r\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\r\n" + 
				"SELECT DISTINCT ?object \r\n" + 
				"WHERE {\r\n" + 
					"?person person:has_Label ?object.\n" + 
					"?person person:has_Date ?motherBirth.\n" + 
					"?person relationship:mother ?child.\n" + 
					"?child person:has_Date ?childBirth.\n" + 
					"?person relationship:live ?country.\n" + 
					"?country country:has_Label \"Việt Nam\".\n" + 
					"FILTER (year(?childBirth) - year(?motherBirth) < 18)\n" + 
				"}";
		
		// 10 tổ chức mà thành lập năm 2009 mà Ryan Ingram lãnh đạo
		String strQuery7 = "PREFIX organization:<http://shadow.org/organization/>\n" + 
				"PREFIX person:<http://shadow.org/person/>\n" + 
				"PREFIX time:<http://shadow.org/time/>\n" + 
				"PREFIX relationship:<http://shadow.org/relationship/>\n" + 
				"SELECT DISTINCT ?object\n" + 
				"WHERE{\n" + 
					"?person person:has_Label \"Ryan Ingram\".\n" + 
					"?person relationship:lead ?organization.\n" + 
					"?organazation organization:has_Label ?object.\n" + 
					"?organization relationship:start ?time.\n" + 
					"?time time:has_Label ?label.\n" + 
					"FILTER(regex(?label, \"2009\"))\n" + 
				"}\n" + 
				"ORDER BY ?object\n" + 
				"LIMIT 10\n" + 
				"";
		
		// Giám đốc trẻ tuổi nhất cung cấp hàng cho nước có tên là Swaziland
		String strQuery8 = "PREFIX person: <http://shadow.org/person/>\n" + 
				"PREFIX country: <http://shadow.org/country/>\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\n" + 
				"SELECT  ?object\n" + 
				"WHERE {\n" + 
					"?person relationship:found ?organization.\n" + 
					"?person person:has_Label ?object.\n" + 
					"?organization relationship:provide ?country.\n" + 
					"?country country:has_Label \"Swaziland\".\n" + 
					"?person person:has_Date ?time.\n" + 
				"}\n" + 
				"ORDER BY DESC(?time) LIMIT 1";
		
		// Người làm nghề kỹ sư 3 được event "VietFood" với mô tả "8 năm tổ chức một lần "  mời tham gia đã học ở nơi nào.
		String strQuery9 = "PREFIX person: <http://shadow.org/person/>\n" + 
				"PREFIX event: <http://shadow.org/event/>\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\n" + 
				"PREFIX country: <http://shadow.org/country/>\n" + 
				"PREFIX location: <http://shadow.org/location/>\n" + 
				"PREFIX organization: <http://shadow.org/country/>\n" + 
					"SELECT distinct ?object\r\n" + 
					"WHERE {\r\n" + 
					"?location location:has_Label ?object.\n" + 
					"?subject event:has_Label \"VietFood\".  \n" + 
					"?person person:has_Job \"Engineer III\".\n" + 
					"?subject event:has_Description \"8 năm tổ chức 1 lần\".\n" + 
					"?event relationship:welcome ?person.\n" + 
					"?person relationship:study ?location.\n" + 
				"}";
		
		// Đưa ra những người là Assistant Professor đến thăm Ấn Độ
		String strQuery10 = "PREFIX person: <http://shadow.org/person/>\n" + 
				"PREFIX relationship: <http://shadow.org/relationship/>\n" + 
				"PREFIX country: <http://shadow.org/country/>\n" + 
				"SELECT ?object\n" + 
				"WHERE {\n" + 
					"?person person:has_Label ?object.\n" + 
					"?person person:has_Job \"Assistant Professor\".\n" + 
					"?person relationship:visit ?country .\n" + 
					"?country country:has_Label \"Ấn Độ\". \n" + 
				"}";
		
		listQueryAdvance.add(strQuery1);
		listQueryAdvance.add(strQuery2);
		listQueryAdvance.add(strQuery3);
		listQueryAdvance.add(strQuery4);
		listQueryAdvance.add(strQuery5);
		listQueryAdvance.add(strQuery6);
		listQueryAdvance.add(strQuery7);
		listQueryAdvance.add(strQuery8);
		listQueryAdvance.add(strQuery9);
		listQueryAdvance.add(strQuery10);
		
		for (int i = 0; i < listQueryAdvance.size(); i++)
		{
//			System.out.println("\n*********************** Query " + (i+1) + " ******************************");
			listResultQueryAdvance.add("*********************** Query " + (i+1) + " ******************************");
			
			start = System.currentTimeMillis();
			
			TupleQuery tupleQuery = conn.prepareTupleQuery(listQueryAdvance.get(i));
			TupleQueryResult result = null;
			try 
			{
				result = tupleQuery.evaluate();
				String line = "";
				while (result.hasNext())
				{
					BindingSet bindingSet = result.next();
					if(bindingSet.getValue("subject") != null)
					{
						line += "subject: " + bindingSet.getValue("subject") + "\t\t\t";
					}
					if(bindingSet.getValue("predicate") != null)
					{
						line += "predicate: " + bindingSet.getValue("predicate") + "\t\t\t";
					}
					if(bindingSet.getValue("object") != null)
					{
						line += "object: " + handingQuery(bindingSet.getValue("object").toString());
					}
					listResultQueryAdvance.add(line);
					line = "";
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
			listResultQueryAdvance.add(("\nTime Query = ") + (end-start) + "\n\n\n");
		}
		
		return listResultQueryAdvance;
	}

	private String handingQuery(String object)
	{
		int lastIndex = object.lastIndexOf("\"");
		if(lastIndex < 0)
			return object;
		String result = object.substring(1, lastIndex);
		return result;
	}
	
	public void closeConnectionQuery()
	{
		conn.close();
	}
}
