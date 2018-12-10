package readfile.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile extends FileNameConstant {
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
		protected ArrayList<String> listRelationPersonCountry;
		protected ArrayList<String> listRelationPersonTime;
		protected ArrayList<String> listRelationPersonPerson;
		protected ArrayList<String> listRelationPersonOrganization;
		protected ArrayList<String> listRelationPersonLocation;
		protected ArrayList<String> listRelationPersonEvent;
		
		protected ArrayList<String> listRelationEventCountry;
		protected ArrayList<String> listRelationEventEvent;
		protected ArrayList<String> listRelationEventLocation;
		protected ArrayList<String> listRelationEventOrganization;
		protected ArrayList<String> listRelationEventPerson;
		protected ArrayList<String> listRelationEventTime;
		
		protected ArrayList<String> listRelationLocationCountry;
		protected ArrayList<String> listRelationLocationPerson;
		protected ArrayList<String> listRelationLocationOrganization;
		protected ArrayList<String> listRelationLocationLocation;
		protected ArrayList<String> listRelationLocationTime;
		
		protected ArrayList<String> listRelationOrganizationCountry;
		protected ArrayList<String> listRelationOrganizationTime;
		protected ArrayList<String> listRelationOrganizationLocation;
		protected ArrayList<String> listRelationOrganizationEvent;
		protected ArrayList<String> listRelationOrganizationPerson;
		
		protected ArrayList<String> listRelationCountryCountry;
		protected ArrayList<String> listRelationCountryTime;
		protected ArrayList<String> listRelationCountryPerson;
		protected ArrayList<String> listRelationCountryEvent;
		protected ArrayList<String> listRelationCountryOrganization;
		protected ArrayList<String> listRelationCountryLocation;
		
		Scanner sc;
		String line="";
		
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
			listRelationPersonCountry        = new ArrayList<String>();
			listRelationPersonTime           = new ArrayList<String>();
			listRelationPersonEvent          = new ArrayList<String>();
			listRelationPersonLocation       = new ArrayList<String>();
			listRelationPersonOrganization   = new ArrayList<String>();
			listRelationPersonPerson         = new ArrayList<String>();
			
			listRelationEventCountry         = new ArrayList<String>();
			listRelationEventEvent           = new ArrayList<String>();
			listRelationEventLocation        = new ArrayList<String>();
			listRelationEventOrganization    = new ArrayList<String>();
			listRelationEventPerson          = new ArrayList<String>();
			listRelationEventTime            = new ArrayList<String>();
			
			listRelationLocationCountry      = new ArrayList<String>();
			listRelationLocationLocation     = new ArrayList<String>();
			listRelationLocationOrganization = new ArrayList<String>();
			listRelationLocationPerson       = new ArrayList<String>();
			listRelationLocationTime         = new ArrayList<String>();
			
			listRelationOrganizationCountry  = new ArrayList<String>();
			listRelationOrganizationEvent    = new ArrayList<String>();
			listRelationOrganizationLocation = new ArrayList<String>();
			listRelationOrganizationPerson   = new ArrayList<String>();
			listRelationOrganizationTime     = new ArrayList<String>();
			
			listRelationCountryCountry       = new ArrayList<String>();
			listRelationCountryEvent         = new ArrayList<String>();
			listRelationCountryLocation      = new ArrayList<String>();
			listRelationCountryOrganization  = new ArrayList<String>();
			listRelationCountryPerson        = new ArrayList<String>();
			listRelationCountryTime          = new ArrayList<String>();
			
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
		}
		
		/*=============================================Read File Relation=====================================*/
		private void readFileRelationCountryTime() {
			try
			{
				sc = new Scanner(new File(fileRelationCountryTime));
				while(sc.hasNextLine())
				{
					line = sc.nextLine();
					listRelationCountryTime.add(line);
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
					listRelationCountryPerson.add(line);
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
					listRelationCountryOrganization.add(line);
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
					listRelationCountryLocation.add(line);
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
					listRelationCountryEvent.add(line);
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
					listRelationCountryCountry.add(line);
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
					listRelationOrganizationTime.add(line);
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
					listRelationOrganizationPerson.add(line);
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
					listRelationOrganizationLocation.add(line);
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
					listRelationOrganizationEvent.add(line);
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
					listRelationOrganizationCountry.add(line);
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
					listRelationLocationTime.add(line);
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
					listRelationLocationPerson.add(line);
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
					listRelationLocationOrganization.add(line);
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
					listRelationLocationLocation.add(line);
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
					listRelationLocationCountry.add(line);
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
					listRelationEventTime.add(line);
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
					listRelationEventPerson.add(line);
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
					listRelationEventOrganization.add(line);
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
					listRelationEventLocation.add(line);
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
					listRelationEventEvent.add(line);
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
					listRelationEventCountry.add(line);
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
					listRelationPersonPerson.add(line);
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
					listRelationPersonOrganization.add(line);
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
					listRelationPersonLocation.add(line);
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
					listRelationPersonEvent.add(line);
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
					listRelationPersonTime.add(line);
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
					listRelationPersonCountry.add(line);
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
}
