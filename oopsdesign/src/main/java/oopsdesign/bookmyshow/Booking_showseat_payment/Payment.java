package oopsdesign.bookmyshow.Booking_showseat_payment;

import java.util.Date;

import oopsdesign.bookmyshow.enums.PaymentStatus;

public class Payment {
	private double amount;
	private Date createdOn;
	private int transactionId;
	private PaymentStatus status;
}
