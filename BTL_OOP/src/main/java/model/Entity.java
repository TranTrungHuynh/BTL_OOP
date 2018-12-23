package model;

import java.util.Date;

public class Entity {
	protected String name;
	protected String description;
	protected String link;
	protected Date date;
	
	public Entity() {
		super();
	}

	public Entity(String name, String description, String link, Date date) {
		super();
		this.name = name;
		this.description = description;
		this.link = link;
		this.date = date;
	}

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
