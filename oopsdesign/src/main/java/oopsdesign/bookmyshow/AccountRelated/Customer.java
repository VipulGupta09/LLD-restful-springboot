package oopsdesign.bookmyshow.AccountRelated;

import java.util.ArrayList;
import java.util.List;

import oopsdesign.bookmyshow.Booking_showseat_payment.Booking;

public class Customer {
	public boolean makeBooking(Booking booking) {
		return true;
	}

	public List<Booking> getBookings() {
		return new ArrayList<Booking>();
	}
}
