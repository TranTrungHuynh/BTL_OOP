package create.entity;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Entity;

public class CreateRandomEntity extends FileNameConstant {
	// Entity
	private ArrayList<String> listPersonName;
	private ArrayList<String> listPersonJob;
	private ArrayList<String> listPersonDescription;
	
	private ArrayList<String> listCountryContinent;
	private ArrayList<String> listCountryDescription;
	private ArrayList<String> listCountryName;
	
	private ArrayList<String> listEventDescription;
	private ArrayList<String> listEventName;
	
	private ArrayList<String> listLocationName;
	private ArrayList<String> listLocationDescription;
	
	private ArrayList<String> listOrganizationName;
	private ArrayList<String> listOrganizationHeadquarter;
	private ArrayList<String> listOrganizationDescription;
	
	private ArrayList<String> listTimeDescription;
	private ArrayList<String> listTimmeName;
	
	// Relation
	private ArrayList<String> listRelationPersonCountry;
	private ArrayList<String> listRelationPersonTime;
	private ArrayList<String> listRelationPersonPerson;
	private ArrayList<String> listRelationPersonOrganization;
	private ArrayList<String> listRelationPersonLocation;
	private ArrayList<String> listRelationPersonEvent;
	
	private ArrayList<String> listRelationEventCountry;
	private ArrayList<String> listRelationEventEvent;
	private ArrayList<String> listRelationEventLocation;
	private ArrayList<String> listRelationEventOrganization;
	private ArrayList<String> listRelationEventPerson;
	private ArrayList<String> listRelationEventTime;
	
	private ArrayList<String> listRelationLocationCountry;
	private ArrayList<String> listRelationLocationPerson;
	private ArrayList<String> listRelationLocationOrganization;
	private ArrayList<String> listRelationLocationLocation;
	private ArrayList<String> listRelationLocationTime;
	
	private ArrayList<String> listRelationOrganizationCountry;
	private ArrayList<String> listRelationOrganizationTime;
	private ArrayList<String> listRelationOrganizationLocation;
	private ArrayList<String> listRelationOrganizationEvent;
	private ArrayList<String> listRelationOrganizationPerson;
	
	private ArrayList<String> listRelationCountryCountry;
	private ArrayList<String> listRelationCountryTime;
	private ArrayList<String> listRelationCountryPerson;
	private ArrayList<String> listRelationCountryEvent;
	private ArrayList<String> listRelationCountryOrganization;
	private ArrayList<String> listRelationCountryLocation;
	
	Scanner sc;
	String line="";
	
	public CreateRandomEntity()
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

	public ArrayList<String> getListPersonName() {
		return listPersonName;
	}
	public void setListPersonName(ArrayList<String> listPersonName) {
		this.listPersonName = listPersonName;
	}
	public ArrayList<String> getListPersonJob() {
		return listPersonJob;
	}
	public void setListPersonJob(ArrayList<String> listPersonJob) {
		this.listPersonJob = listPersonJob;
	}
	public ArrayList<String> getListPersonDescription() {
		return listPersonDescription;
	}
	public void setListPersonDescription(ArrayList<String> listPersonDescription) {
		this.listPersonDescription = listPersonDescription;
	}
	public ArrayList<String> getListCountryContinent() {
		return listCountryContinent;
	}
	public void setListCountryContinent(ArrayList<String> listCountryContinent) {
		this.listCountryContinent = listCountryContinent;
	}
	public ArrayList<String> getListCountryDescription() {
		return listCountryDescription;
	}
	public void setListCountryDescription(ArrayList<String> listCountryDescription) {
		this.listCountryDescription = listCountryDescription;
	}
	public ArrayList<String> getListCountryName() {
		return listCountryName;
	}
	public void setListCountryName(ArrayList<String> listCountryName) {
		this.listCountryName = listCountryName;
	}
	public ArrayList<String> getListEventDescription() {
		return listEventDescription;
	}
	public void setListEventDescription(ArrayList<String> listEventDescription) {
		this.listEventDescription = listEventDescription;
	}
	public ArrayList<String> getListEventName() {
		return listEventName;
	}
	public void setListEventName(ArrayList<String> listEventName) {
		this.listEventName = listEventName;
	}
	public ArrayList<String> getListLocationName() {
		return listLocationName;
	}
	public void setListLocationName(ArrayList<String> listLocationName) {
		this.listLocationName = listLocationName;
	}
	public ArrayList<String> getListLocationDescription() {
		return listLocationDescription;
	}
	public void setListLocationDescription(ArrayList<String> listLocationDescription) {
		this.listLocationDescription = listLocationDescription;
	}
	public ArrayList<String> getListOrganizationName() {
		return listOrganizationName;
	}
	public void setListOrganizationName(ArrayList<String> listOrganizationName) {
		this.listOrganizationName = listOrganizationName;
	}
	public ArrayList<String> getListOrganizationHeadquarter() {
		return listOrganizationHeadquarter;
	}
	public void setListOrganizationHeadquarter(ArrayList<String> listOrganizationHeadquarter) {
		this.listOrganizationHeadquarter = listOrganizationHeadquarter;
	}
	public ArrayList<String> getListOrganizationDescription() {
		return listOrganizationDescription;
	}
	public void setListOrganizationDescription(ArrayList<String> listOrganizationDescription) {
		this.listOrganizationDescription = listOrganizationDescription;
	}
	public ArrayList<String> getListTimeDescription() {
		return listTimeDescription;
	}
	public void setListTimeDescription(ArrayList<String> listTimeDescription) {
		this.listTimeDescription = listTimeDescription;
	}
	public ArrayList<String> getListTimmeName() {
		return listTimmeName;
	}
	public void setListTimmeName(ArrayList<String> listTimmeName) {
		this.listTimmeName = listTimmeName;
	}
	public ArrayList<String> getListRelationPersonCountry() {
		return listRelationPersonCountry;
	}
	public void setListRelationPersonCountry(ArrayList<String> listRelationPersonCountry) {
		this.listRelationPersonCountry = listRelationPersonCountry;
	}
	public ArrayList<String> getListRelationPersonTime() {
		return listRelationPersonTime;
	}
	public void setListRelationPersonTime(ArrayList<String> listRelationPersonTime) {
		this.listRelationPersonTime = listRelationPersonTime;
	}
	public ArrayList<String> getListRelationPersonPerson() {
		return listRelationPersonPerson;
	}
	public void setListRelationPersonPerson(ArrayList<String> listRelationPersonPerson) {
		this.listRelationPersonPerson = listRelationPersonPerson;
	}
	public ArrayList<String> getListRelationPersonOrganization() {
		return listRelationPersonOrganization;
	}
	public void setListRelationPersonOrganization(ArrayList<String> listRelationPersonOrganization) {
		this.listRelationPersonOrganization = listRelationPersonOrganization;
	}
	public ArrayList<String> getListRelationPersonLocation() {
		return listRelationPersonLocation;
	}
	public void setListRelationPersonLocation(ArrayList<String> listRelationPersonLocation) {
		this.listRelationPersonLocation = listRelationPersonLocation;
	}
	public ArrayList<String> getListRelationPersonEvent() {
		return listRelationPersonEvent;
	}
	public void setListRelationPersonEvent(ArrayList<String> listRelationPersonEvent) {
		this.listRelationPersonEvent = listRelationPersonEvent;
	}
	public ArrayList<String> getListRelationEventCountry() {
		return listRelationEventCountry;
	}

	public void setListRelationEventCountry(ArrayList<String> listRelationEventCountry) {
		this.listRelationEventCountry = listRelationEventCountry;
	}

	public ArrayList<String> getListRelationEventEvent() {
		return listRelationEventEvent;
	}

	public void setListRelationEventEvent(ArrayList<String> listRelationEventEvent) {
		this.listRelationEventEvent = listRelationEventEvent;
	}

	public ArrayList<String> getListRelationEventLocation() {
		return listRelationEventLocation;
	}

	public void setListRelationEventLocation(ArrayList<String> listRelationEventLocation) {
		this.listRelationEventLocation = listRelationEventLocation;
	}

	public ArrayList<String> getListRelationEventOrganization() {
		return listRelationEventOrganization;
	}

	public void setListRelationEventOrganization(ArrayList<String> listRelationEventOrganization) {
		this.listRelationEventOrganization = listRelationEventOrganization;
	}

	public ArrayList<String> getListRelationEventPerson() {
		return listRelationEventPerson;
	}

	public void setListRelationEventPerson(ArrayList<String> listRelationEventPerson) {
		this.listRelationEventPerson = listRelationEventPerson;
	}

	public ArrayList<String> getListRelationEventTime() {
		return listRelationEventTime;
	}

	public void setListRelationEventTime(ArrayList<String> listRelationEventTime) {
		this.listRelationEventTime = listRelationEventTime;
	}

	public ArrayList<String> getListRelationLocationCountry() {
		return listRelationLocationCountry;
	}

	public void setListRelationLocationCountry(ArrayList<String> listRelationLocationCountry) {
		this.listRelationLocationCountry = listRelationLocationCountry;
	}

	public ArrayList<String> getListRelationLocationPerson() {
		return listRelationLocationPerson;
	}

	public void setListRelationLocationPerson(ArrayList<String> listRelationLocationPerson) {
		this.listRelationLocationPerson = listRelationLocationPerson;
	}

	public ArrayList<String> getListRelationLocationOrganization() {
		return listRelationLocationOrganization;
	}

	public void setListRelationLocationOrganization(ArrayList<String> listRelationLocationOrganization) {
		this.listRelationLocationOrganization = listRelationLocationOrganization;
	}

	public ArrayList<String> getListRelationLocationLocation() {
		return listRelationLocationLocation;
	}

	public void setListRelationLocationLocation(ArrayList<String> listRelationLocationLocation) {
		this.listRelationLocationLocation = listRelationLocationLocation;
	}
	public ArrayList<String> getListRelationLocationTime() {
		return listRelationLocationTime;
	}

	public void setListRelationLocationTime(ArrayList<String> listRelationLocationTime) {
		this.listRelationLocationTime = listRelationLocationTime;
	}
	public ArrayList<String> getListRelationOrganizationCountry() {
		return listRelationOrganizationCountry;
	}

	public void setListRelationOrganizationCountry(ArrayList<String> listRelationOrganizationCountry) {
		this.listRelationOrganizationCountry = listRelationOrganizationCountry;
	}

	public ArrayList<String> getListRelationOrganizationTime() {
		return listRelationOrganizationTime;
	}

	public void setListRelationOrganizationTime(ArrayList<String> listRelationOrganizationTime) {
		this.listRelationOrganizationTime = listRelationOrganizationTime;
	}

	public ArrayList<String> getListRelationOrganizationLocation() {
		return listRelationOrganizationLocation;
	}

	public void setListRelationOrganizationLocation(ArrayList<String> listRelationOrganizationLocation) {
		this.listRelationOrganizationLocation = listRelationOrganizationLocation;
	}

	public ArrayList<String> getListRelationOrganizationEvent() {
		return listRelationOrganizationEvent;
	}

	public void setListRelationOrganizationEvent(ArrayList<String> listRelationOrganizationEvent) {
		this.listRelationOrganizationEvent = listRelationOrganizationEvent;
	}

	public ArrayList<String> getListRelationOrganizationPerson() {
		return listRelationOrganizationPerson;
	}

	public void setListRelationOrganizationPerson(ArrayList<String> listRelationOrganizationPerson) {
		this.listRelationOrganizationPerson = listRelationOrganizationPerson;
	}

	public ArrayList<String> getListRelationCountryCountry() {
		return listRelationCountryCountry;
	}

	public void setListRelationCountryCountry(ArrayList<String> listRelationCountryCountry) {
		this.listRelationCountryCountry = listRelationCountryCountry;
	}

	public ArrayList<String> getListRelationCountryTime() {
		return listRelationCountryTime;
	}

	public void setListRelationCountryTime(ArrayList<String> listRelationCountryTime) {
		this.listRelationCountryTime = listRelationCountryTime;
	}

	public ArrayList<String> getListRelationCountryPerson() {
		return listRelationCountryPerson;
	}

	public void setListRelationCountryPerson(ArrayList<String> listRelationCountryPerson) {
		this.listRelationCountryPerson = listRelationCountryPerson;
	}

	public ArrayList<String> getListRelationCountryEvent() {
		return listRelationCountryEvent;
	}

	public void setListRelationCountryEvent(ArrayList<String> listRelationCountryEvent) {
		this.listRelationCountryEvent = listRelationCountryEvent;
	}

	public ArrayList<String> getListRelationCountryOrganization() {
		return listRelationCountryOrganization;
	}

	public void setListRelationCountryOrganization(ArrayList<String> listRelationCountryOrganization) {
		this.listRelationCountryOrganization = listRelationCountryOrganization;
	}
	public ArrayList<String> getListRelationCountryLocation() {
		return listRelationCountryLocation;
	}
	public void setListRelationCountryLocation(ArrayList<String> listRelationCountryLocation) {
		this.listRelationCountryLocation = listRelationCountryLocation;
	}


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
	
	

	
	// Read File Entity
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
	public ArrayList<Entity> getListRandomEntity(int numberOfEntity)
	{
		ArrayList<Entity> listEntity = new ArrayList<Entity>();
		for(int i = 0; i < numberOfEntity; i++)
		{
			listEntity.add(randomEntity());
		}
		return listEntity;
	}
	
	private Entity randomEntity()
	{
		Entity entity;
		
		Random rd = new Random();
		int chooseEntity = rd.nextInt(6);
		switch(chooseEntity)
		{
			case 0:
					entity = CreatePerson.getRandomPerson(listPersonName, listPersonDescription, listPersonJob);
					break;
			case 1:
					entity = CreateCountry.getRandomCountry(listCountryName, listCountryContinent, listCountryDescription);
					break;
			case 2:
					entity = CreateEvent.getRandomEvent(listEventName, listEventDescription);
					break;
			case 3:
					entity = CreateLocation.getRandomLocation(listLocationName, listLocationDescription);
					break;
			case 4:
					entity = CreateOrganization.getRandomOrganization(listOrganizationName, listOrganizationHeadquarter, listOrganizationDescription);
					break;
			case 5:
					entity = CreateTime.getRandomTime(listTimmeName, listTimeDescription);
					break;
			default:
				entity = null;
				break;
		}
		return entity;
	}
}
