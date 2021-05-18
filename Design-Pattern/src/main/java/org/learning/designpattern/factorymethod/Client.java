package org.learning.designpattern.factorymethod;

import org.learning.designpattern.factorymethod.concrete.Message;

public class Client {
	public static void main(String[] args) {
		printMessage(new JsonMessageCreator());
		printMessage(new StringMessageCreator());
	}
	
	public static void printMessage(MessageCreator creator) {
		Message msg = creator.getMessage();
		System.out.println(msg.getContent());
	}
}
