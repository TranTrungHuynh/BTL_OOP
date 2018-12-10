package create.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import model.Organization;

public class CreateOrganization extends RandomDate {
	public Organization getRandomOrganization(ArrayList<String> listOrganizationName,
			ArrayList<String> listOrganizationHeadquarter, ArrayList<String> listOrganizationDescription)
	{
		Random rd = new Random();
		String name = listOrganizationName.get(rd.nextInt(listOrganizationName.size()));
		String headquarter = listOrganizationHeadquarter.get(rd.nextInt(listOrganizationHeadquarter.size()));
		String description = listOrganizationDescription.get(rd.nextInt(listOrganizationDescription.size()));
		Date date = getDateRandom();
		String link = "http://shadow.org/linkOrganization" + rd.nextInt(listOrganizationName.size());
		Organization organization = new Organization(name, description, link, date, headquarter);
		return organization;
	}
}
