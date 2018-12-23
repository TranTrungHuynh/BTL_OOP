package main;

import file.io.WriteFile;
import graphdb.uploadData;
import graphdb.Query;

public class Main {
	public static void main(String[] args) {

		int numberOfEntity = 5000;
		int numberOfRelationship = 10000;

		// Define object upload relation and entity
		uploadData upData = new uploadData();

		/*==============Upload Entity data to server=========*/
		upData.upLoadEntity(numberOfEntity);

		/*============== Upload Relationship ===================*/
		upData.uploadRelationData(numberOfRelationship);

		
		System.out.println("end");
		
		// Define object query
		Query query         = new Query();
		WriteFile writeFile = new WriteFile();
		boolean checkWriteFile;

		/*============== Query Data ===================*/
		checkWriteFile = writeFile.writeFileQuery("./ResultQueryBasic.txt", query.queryBasic());
		if(checkWriteFile)
		{
			System.out.println("Write file ResultQueryBasic.txt success !");
		}
		else
		{
			System.out.println("Error write ResultQueryBasic.txt file !");
		}

		checkWriteFile = writeFile.writeFileQuery("./ResultQueryAdvance.txt", query.queryAdvance());
		if(checkWriteFile)
		{
			System.out.println("Write file ResultQueryAdvance.txt success !");
		}
		else
		{
			System.out.println("Error write ResultQueryAdvance.txt file !");
		}
		query.closeConnectionQuery();

		System.exit(0);
	}  
}


