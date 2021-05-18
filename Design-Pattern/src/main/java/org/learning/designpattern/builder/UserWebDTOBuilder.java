package org.learning.designpattern.builder;

import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder {
	private String fname;
	private String lname;
	private String age;
	private String address;
	private UserDTO userDTO;

	@Override
	public UserDTOBuilder withFirstName(String fname) {
		this.fname = fname;
		return this;
	}

	@Override
	public UserDTOBuilder withLastName(String lname) {
		this.lname = lname;
		return this;
	}

	@Override
	public UserDTOBuilder withBirthday(LocalDate date) {
		Period ageInYear = Period.between(date, LocalDate.now());
		age = Integer.toString(ageInYear.getYears());
		return this;
	}

	@Override
	public UserDTOBuilder withAddress(Address address) {
		this.address = address.getHouseNumber() + " " + address.getCity() + " " + address.getState() + " "
				+ address.getZipcode() + " " + address.getStreet();
		return this;
	}

	@Override
	public UserDTO build() {
		userDTO = new UserWebDTO(fname + " " + lname, address, age);
		return userDTO;
	}

	@Override
	public UserDTO getUserDTO() {
		return userDTO;
	}

}
