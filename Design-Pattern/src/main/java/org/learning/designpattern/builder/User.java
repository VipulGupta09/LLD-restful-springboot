package org.learning.designpattern.builder;

import java.time.LocalDate;

public class User {
	private String fName;
	private String lName;
	private LocalDate dob;
	private Address adderss;
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Address getAdderss() {
		return adderss;
	}
	public void setAdderss(Address adderss) {
		this.adderss = adderss;
	}
	
	
}
