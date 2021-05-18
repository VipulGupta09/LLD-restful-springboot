package org.learning.designpattern.builder;

import java.time.LocalDate;

public class Client {

	public static void main(String[] args) {
		User user = createUser();
		UserDTOBuilder userDTOBuilder = new UserWebDTOBuilder();
		UserDTO dto = directBuild(userDTOBuilder, user);
		System.out.println(dto);

	}

	private static UserDTO directBuild(UserDTOBuilder builder, User user) {
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
