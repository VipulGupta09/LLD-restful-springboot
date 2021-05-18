package org.learning.designpattern.builder;

import java.time.LocalDate;

import org.learning.designpattern.builder.UserProductClassDTO.UserProductDTOBuilder;

public class Client1 {

	public static void main(String[] args) {
		User user = createUser();
		UserProductClassDTO dto = directBuild(UserProductClassDTO.getBuilder(), user);
		System.out.println(dto);

	}

	private static UserProductClassDTO directBuild(UserProductDTOBuilder builder, User user) {
	return 	builder.withFirstName(user.getfName()).withLastName(user.getlName()).withAddress(user.getAdderss())
				.withBirthday(user.getDob()).build();

	}

	public static User createUser() {
		User user = new User();
		user.setfName("Vipul");
		user.setlName("Gupta");
		user.setDob(LocalDate.of(1960, 5, 6));
		Address address = new Address();
		address.setHouseNumber("554/2");
		address.setZipcode("250002");
		address.setState("UP");
		address.setStreet("5");
		address.setCity("Meerut");
		user.setAdderss(address);

		return user;
	}
}
