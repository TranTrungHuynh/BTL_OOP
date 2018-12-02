package model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Organization extends Entity {
	private static final AtomicInteger count = new AtomicInteger(0);
	protected final int id;
	private String headquarter;

	public Organization() {
		super();
		id = count.incrementAndGet();
	}

	public Organization(String name, String description, String link, Date date, String headquarter) {
		super(name, description, link, date);
		this.headquarter = headquarter;
		id = count.incrementAndGet();
	}

	public String getHeadquarter() {
		return headquarter;
	}

	public void setHeadquarter(String headquarter) {
		this.headquarter = headquarter;
	}
	
	public int getId() {
		return id;
	}

	public String toString() {
		return "id :" + this.getId() +
				"\nname :" + this.getName() +
				"\nheadquarter :" + this.getHeadquarter() +
				"\ndescription :" + this.getDescription() +
				"\ndate :" + this.getDate() +
				"\nlink :" + this.getLink();
	}
}
