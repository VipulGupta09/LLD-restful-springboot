package org.learning.designpattern.builder;

import java.time.LocalDate;
import java.time.Period;

public class UserProductClassDTO {
	private String name;
	private String address;
	private String age;
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	private void setAddress(String address) {
		this.address = address;
	}
	public String getAge() {
		return age;
	}
	private void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserProductClass [name=" + name + ", address=" + address + ", age=" + age + "]";
	}
	
	public static UserProductDTOBuilder getBuilder() {
		return new UserProductDTOBuilder();
	}
	
	
	public static class UserProductDTOBuilder{

		private String fname;
		private String lname;
		private String age;
		private String address;
		private UserProductClassDTO userDTO;

		public UserProductDTOBuilder withFirstName(String fname) {
			this.fname = fname;
			return this;
		}

		public UserProductDTOBuilder withLastName(String lname) {
			this.lname = lname;
			return this;
		}

		public UserProductDTOBuilder withBirthday(LocalDate date) {
			Period ageInYear = Period.between(date, LocalDate.now());
			age = Integer.toString(ageInYear.getYears());
			return this;
		}

		public UserProductDTOBuilder withAddress(Address address) {
			this.address = address.getHouseNumber() + " " + address.getCity() + " " + address.getState() + " "
					+ address.getZipcode() + " " + address.getStreet();
			return this;
		}

		public UserProductClassDTO build() {
			this.userDTO = new UserProductClassDTO();
			userDTO.setName(fname+" "+lname);
			userDTO.setAddress(address);
			userDTO.setAge(age);
			
			return this.userDTO;
		}

		public UserProductClassDTO getUserDTO() {
			return this.userDTO;
		}


	}
	
	
}
