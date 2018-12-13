package readfile.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import graphdb.Connection;

public class ReadFile extends FileNameConstant {
		private Connection connection = new Connection();
		private RepositoryConnection conn = connection.getRepositoryConnection();
		private ValueFactory vf = conn.getValueFactory();
	
		private final String RELATIONSHIP = "http://shadow.org/relationship/";
		private IRI relationIRI;
		
		Scanner sc;
		String line="";
		
		// Entity
		protected ArrayList<String> listPersonName;
		protected ArrayList<String> listPersonJob;
		protected ArrayList<String> listPersonDescription;
		
		protected ArrayList<String> listCountryContinent;
		protected ArrayList<String> listCountryDescription;
		protected ArrayList<String> listCountryName;
		
		protected ArrayList<String> listEventDescription;
		protected ArrayList<String> listEventName;
		
		protected ArrayList<String> listLocationName;
		protected ArrayList<String> listLocationDescription;
		
		protected ArrayList<String> listOrganizationName;
		protected ArrayList<String> listOrganizationHeadquarter;
		protected ArrayList<String> listOrganizationDescription;
		
		protected ArrayList<String> listTimeDescription;
		protected ArrayList<String> listTimmeName;
		
		// Relation
		protected ArrayList<IRI> listRelationPersonCountry;
		protected ArrayList<IRI> listRelationPersonTime;
		protected ArrayList<IRI> listRelationPersonPerson;
		protected ArrayList<IRI> listRelationPersonOrganization;
		protected ArrayList<IRI> listRelationPersonLocation;
		protected ArrayList<IRI> listRelationPersonEvent;
		                    
		protected ArrayList<IRI> listRelationEventCountry;
		protected ArrayList<IRI> listRelationEventEvent;
		protected ArrayList<IRI> listRelationEventLocation;
		protected ArrayList<IRI> listRelationEventOrganization;
		protected ArrayList<IRI> listRelationEventPerson;
		protected ArrayList<IRI> listRelationEventTime;
		                    
		protected ArrayList<IRI> listRelationLocationCountry;
		protected ArrayList<IRI> listRelationLocationPerson;
		protected ArrayList<IRI> listRelationLocationOrganization;
		protected ArrayList<IRI> listRelationLocationLocation;
		protected ArrayList<IRI> listRelationLocationTime;
		                    
		protected ArrayList<IRI> listRelationOrganizationCountry;
		protected ArrayList<IRI> listRelationOrganizationTime;
		protected ArrayList<IRI> listRelationOrganizationLocation;
		protected ArrayList<IRI> listRelationOrganizationEvent;
		protected ArrayList<IRI> listRelationOrganizationPerson;
		                    
		protected ArrayList<IRI> listRelationCountryCountry;
		protected ArrayList<IRI> listRelationCountryTime;
		protected ArrayList<IRI> listRelationCountryPerson;
		protected ArrayList<IRI> listRelationCountryEvent;
		protected ArrayList<IRI> listRelationCountryOrganization;
		protected ArrayList<IRI> listRelationCountryLocation;
		
		public ReadFile()
		{
			super();
			
			// Entity
			listPersonName              = new ArrayList<String>();
			listPersonJob               = new ArrayList<String>();
			listPersonDescription       = new ArrayList<String>();
					
			listCountryContinent        = new ArrayList<String>();
			listCountryDescription      = new ArrayList<String>();
			listCountryName             = new ArrayList<String>();
			
			listEventDescription        = new ArrayList<String>();
			listEventName               = new ArrayList<String>();
							 
			listLocationName            = new ArrayList<String>();
			listLocationDescription     = new ArrayList<String>();
			
			listOrganizationName        = new ArrayList<String>();
			listOrganizationDescription = new ArrayList<String>();
			listOrganizationHeadquarter = new ArrayList<String>();
			
			listTimeDescription         = new ArrayList<String>();
			listTimmeName               = new ArrayList<String>();
			
			// Relation
			listRelationPersonCountry        = new ArrayList<IRI>();
			listRelationPersonTime           = new ArrayList<IRI>();
			listRelationPersonEvent          = new ArrayList<IRI>();
			listRelationPersonLocation       = new ArrayList<IRI>();
			listRelationPersonOrganization   = new ArrayList<IRI>();
			listRelationPersonPerson         = new ArrayList<IRI>();
			                                                 
			listRelationEventCountry         = new ArrayList<IRI>();
			listRelationEventEvent           = new ArrayList<IRI>();
			listRelationEventLocation        = new ArrayList<IRI>();
			listRelationEventOrganization    = new ArrayList<IRI>();
			listRelationEventPerson          = new ArrayList<IRI>();
			listRelationEventTime            = new ArrayList<IRI>();
			                                                 
			listRelationLocationCountry      = new ArrayList<IRI>();
			listRelationLocationLocation     = new ArrayList<IRI>();
			listRelationLocationOrganization = new ArrayList<IRI>();
			listRelationLocationPerson       = new ArrayList<IRI>();
			listRelationLocationTime         = new ArrayList<IRI>();
			                                                 
			listRelationOrganizationCountry  = new ArrayList<IRI>();
			listRelationOrganizationEvent    = new ArrayList<IRI>();
			listRelationOrganizationLocation = new ArrayList<IRI>();
			listRelationOrganizationPerson   = new ArrayList<IRI>();
			listRelationOrganizationTime     = new ArrayList<IRI>();
			                                                 
			listRelationCountryCountry       = new ArrayList<IRI>();
			listRelationCountryEvent         = new ArrayList<IRI>();
			listRelationCountryLocation      = new ArrayList<IRI>();
			listRelationCountryOrganization  = new ArrayList<IRI>();
			listRelationCountryPerson        = new ArrayList<IRI>();
			listRelationCountryTime          = new ArrayList<IRI>();
			
			// File Entity
			readFilePerson();
			readFileCountry();
			readFileEvent();
			readFileLocation();
			readFileOrganization();
			readFileTime();
			
			// File Relation
			readFileRelationPersonCountry();
			readFileRelationPersonTime();
			readFileRelationPersonEvent();
			readFileRelationPersonLocation();
			readFileRelationPersonOrganization();
			readFileRelationPersonPerson();

			readFileRelationEventCountry();
			readFileRelationEventEvent();
			readFileRelationEventLocation();
			readFileRelationEventOrganization();
			readFileRelationEventPerson();
			readFileRelationEventTime();

			readFileRelationLocationCountry();
			readFileRelationLocationLocation();
			readFileRelationLocationOrganization();
			readFileRelationLocationPerson();
			readFileRelationLocationTime();

			readFileRelationOrganizationCountry();
			readFileRelationOrganizationEvent();
			readFileRelationOrganizationLocation();
			readFileRelationOrganizationPerson();
			readFileRelationOrganizationTime();
			
			readFileRelationCountryCountry();
			readFileRelationCountryEvent();
			readFileRelationCountryLocation();
			readFileRelationCountryOrganization();
			readFileRelationCountryPerson();
			readFileRelationCountryTime();
			
			closeConnectionReadFile();
		}
		
		/*=============================================Read File Relation=====================================*/
		private void readFileRelationCountryTime() {
			try
			{
				sc = new Scanner(new File(fileRelationCountryTime));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationCountryTime.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationCountryPerson() {
			try
			{
				sc = new Scanner(new File(fileRelationCountryPerson));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationCountryPerson.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationCountryOrganization() {
			try
			{
				sc = new Scanner(new File(fileRelationCountryOrganization));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationCountryOrganization.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationCountryLocation() {
			try
			{
				sc = new Scanner(new File(fileRelationCountryLocation));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationCountryLocation.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationCountryEvent() {
			try
			{
				sc = new Scanner(new File(fileRelationCountryEvent));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationCountryEvent.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationCountryCountry()
		{
			try
			{
				sc = new Scanner(new File(fileRelationCountryCountry));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationCountryCountry.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}


		private void readFileRelationOrganizationTime() {
			try
			{
				sc = new Scanner(new File(fileRelationOrganizationTime));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationOrganizationTime.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationOrganizationPerson() {
			try
			{
				sc = new Scanner(new File(fileRelationOrganizationPerson));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationOrganizationPerson.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationOrganizationLocation() {
			try
			{
				sc = new Scanner(new File(fileRelationOrganizationLocation));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationOrganizationLocation.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationOrganizationEvent() {
			try
			{
				sc = new Scanner(new File(fileRelationOrganizationEvent));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationOrganizationEvent.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationOrganizationCountry() {
			try
			{
				sc = new Scanner(new File(fileRelationOrganizationCountry));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationOrganizationCountry.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}

		private void readFileRelationLocationTime() {
			try
			{
				sc = new Scanner(new File(fileRelationLocationTime));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationLocationTime.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationLocationPerson() {
			try
			{
				sc = new Scanner(new File(fileRelationLocationPerson));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationLocationPerson.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationLocationOrganization() {
			try
			{
				sc = new Scanner(new File(fileRelationLocationOrganization));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationLocationOrganization.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationLocationLocation() {
			try
			{
				sc = new Scanner(new File(fileRelationLocationLocation));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationLocationLocation.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationLocationCountry() {
			try
			{
				sc = new Scanner(new File(fileRelationLocationCountry));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationLocationCountry.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}

		private void readFileRelationEventTime() {
			try
			{
				sc = new Scanner(new File(fileRelationEventTime));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationEventTime.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationEventPerson() {
			try
			{
				sc = new Scanner(new File(fileRelationEventPerson));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationEventPerson.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationEventOrganization() {
			try
			{
				sc = new Scanner(new File(fileRelationEventOrganization));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationEventOrganization.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationEventLocation() {
			try
			{
				sc = new Scanner(new File(fileRelationEventLocation));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationEventLocation.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationEventEvent() {
			try
			{
				sc = new Scanner(new File(fileRelationEventEvent));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationEventEvent.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationEventCountry() {
			try
			{
				sc = new Scanner(new File(fileRelationEventCountry));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationEventCountry.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		
		
		
		private void readFileRelationPersonPerson() {
			try
			{
				sc = new Scanner(new File(fileRelationPersonPerson));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationPersonPerson.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationPersonOrganization() {
			try
			{
				sc = new Scanner(new File(fileRelationPersonOrganization));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationPersonOrganization.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationPersonLocation() {
			try
			{
				sc = new Scanner(new File(fileRelationPersonLocation));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationPersonLocation.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationPersonEvent() {
			try
			{
				sc = new Scanner(new File(fileRelationPersonEvent));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationPersonEvent.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationPersonTime() {
			try
			{
				sc = new Scanner(new File(fileRelationPersonTime));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationPersonTime.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileRelationPersonCountry() {
			try
			{
				sc = new Scanner(new File(fileRelationPersonCountry));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					relationIRI = vf.createIRI(RELATIONSHIP, line);
					listRelationPersonCountry.add(relationIRI);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		
		/*========================================================Read File Entity=================================================*/
		private void readFileTime() {
			try
			{
				sc = new Scanner(new File(fileTimmeName));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listTimmeName.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(fileTimeDescription));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listTimeDescription.add(line);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileOrganization() {
			try
			{
				sc = new Scanner(new File(fileOrganizationName));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listOrganizationName.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(fileOrganizationHeadquarter));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listOrganizationHeadquarter.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(fileOrganizationDescription));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listOrganizationDescription.add(line);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileLocation() {
			try
			{
				sc = new Scanner(new File(fileLocationName));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listLocationName.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(fileLocationDescription));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listLocationDescription.add(line);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileEvent() {
			try
			{
				sc = new Scanner(new File(fileEventName));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listEventName.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(fileEventDescription));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listEventDescription.add(line);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFileCountry() {
			try
			{
				sc = new Scanner(new File(fileCountryName));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listCountryName.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(fileCountryDescription));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listCountryDescription.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(fileCountryContinent));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listCountryContinent.add(line);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		private void readFilePerson() {
			try
			{
				sc = new Scanner(new File(filePersonName));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listPersonName.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(filePersonDescription));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listPersonDescription.add(line);
				}
				sc.close();
				
				sc = new Scanner(new File(filePersonJob));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listPersonJob.add(line);
				}
				sc.close();
			}
			catch (Exception Ex)
			{
				Ex.printStackTrace();
			}
		}
		
	public void closeConnectionReadFile()
	{
		conn.close();
	}
}
