package model;

public class Relationship {
	private int id;
	private String name;
	
	
	public Relationship() {
		super();
	}
	public Relationship(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.getId() + " - " + this.getName();
	}
}
