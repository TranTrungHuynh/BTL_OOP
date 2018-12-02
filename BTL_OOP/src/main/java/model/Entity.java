package model;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Entity {
//	private static final AtomicInteger count = new AtomicInteger(0);
//	protected final int id;
	protected String name;
	protected String description;
	protected String link;
	protected Date date;
	
	public Entity() {
		super();
//		id = count.incrementAndGet();
	}

	public Entity(String name, String description, String link, Date date) {
		super();
//		this.id = count.incrementAndGet();
		this.name = name;
		this.description = description;
		this.link = link;
		this.date = date;
	}

//	public int getId() {
//		return id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
