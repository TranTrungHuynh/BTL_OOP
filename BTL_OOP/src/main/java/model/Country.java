package model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Country extends Entity {
	private static final AtomicInteger count = new AtomicInteger(0);
	protected final int id;
	private String continent;
	
	public Country() {
		super();
		id = count.incrementAndGet();
	}

	public Country(String name, String description, String continent, String link, Date date) {
		super(name, description, link, date);
		id = count.incrementAndGet();
		this.continent = continent;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return "id :" + this.getId() + "\nname :" +
				this.getName() + "\ncontinent :" +
				this.getContinent() + "\ndescription :" +
				this.getDescription() + "\ndate :" +
				this.getDate() + "\nlink :" + this.getLink();
	}
}
