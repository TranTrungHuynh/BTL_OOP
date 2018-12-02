package model;

import java.util.concurrent.atomic.AtomicInteger;

public class Person extends Entity {
	private static final AtomicInteger count = new AtomicInteger(0);
	protected final int id;
	private String job;

	public Person() {
		super();
		id = count.incrementAndGet();
	}

	public Person(String name, String description, String link, String date, String job) {
		super(name, description, link, date);
		this.job = job;
		id = count.incrementAndGet();
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		return "id :" + this.getId() +
				"\nname :" + this.getName() +
				"\njob :" + this.getJob() +
				"\ndescription :" + this.getDescription() +
				"\ndate :" + this.getDate() +
				"\nlink :" + this.getLink() + "\n";
	}
}
