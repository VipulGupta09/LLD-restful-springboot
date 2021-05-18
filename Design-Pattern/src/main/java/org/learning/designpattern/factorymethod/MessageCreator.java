package org.learning.designpattern.factorymethod;

import org.learning.designpattern.factorymethod.concrete.Message;

public abstract class MessageCreator {

	public Message getMessage() {
		Message msg = createMessage();
		return msg;

	}

	//factory method
	public abstract Message createMessage();
}
