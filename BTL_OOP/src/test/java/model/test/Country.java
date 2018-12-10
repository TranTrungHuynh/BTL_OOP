package model.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import io.FileNameConstant;

public class Country {
	
	private String name;
	
	public Country()
	{
		super();
	}

	public Country(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
