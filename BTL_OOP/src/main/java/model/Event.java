package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Event extends Entity {
	private static final AtomicInteger count = new AtomicInteger(0);
	protected final int id;

	public Event() {
		super();
		id = count.incrementAndGet();
	}

	public Event(String name, String description, String link, String date) {
		super(name, description, link, date);
		id = count.incrementAndGet();
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "id :" + this.getId() +
				"\nname :" + this.getName() +
				"\ndescription :" + this.getDescription() +
				"\ndate :" + this.getDate() +
				"\nlink :" + this.getLink();
	}
}
