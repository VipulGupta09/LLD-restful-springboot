package org.learning.designpattern.factorymethod;

import org.learning.designpattern.factorymethod.concrete.JsonMessage;
import org.learning.designpattern.factorymethod.concrete.Message;

public class JsonMessageCreator extends MessageCreator{

	@Override
	public Message createMessage() {
		return new JsonMessage();
	}

}
