package application;

import java.util.ArrayList;

public class People {
	
	private String name;
	private String midname;
	private String surname;
	private String dob;
	private static int personIdnum = 0 ;
	private String personId;
	
	public static ArrayList <People> peoplereg = new ArrayList<People>();
	//create a hashmap?"
	
	public People(String name, String midname, String surname, String dob) {
		this.name = name;
		this.midname = midname;
		this.surname = surname;
		this.dob = dob;
		personIdnum++;
		 //Why can you change this if its private?
		personId = "U" + personIdnum;
		peoplereg.add(this);
	}
	
	public People(String name, String surname, String dob) {
		this.name = name;
		this.surname = surname;
		this.dob = dob;
		personIdnum++;
		personId = "U" + personIdnum ;
		peoplereg.add(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMidname() {
		return midname;
	}
	public void setMidname(String midname) {
		this.midname = midname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	

}
