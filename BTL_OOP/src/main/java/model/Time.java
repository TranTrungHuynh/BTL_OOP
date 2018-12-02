package model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Time extends Entity {
	private static final AtomicInteger count = new AtomicInteger(0);
	protected final int id;

	public Time() {
		super();
		id = count.incrementAndGet();
	}

	public Time(String name, String description, String link, Date date) {
		super(name, description, link, date);
		id = count.incrementAndGet();
	}

	public int getId()
	{
		return this.id;
	}
	
	public String toString() {
		return "id :" + this.getId() + "\nname :" + this.getName() + "\ndescription :" + this.getDescription() + "\ndate :" + this.getDate() + "\nlink :" + this.getLink();
	}
	
}
