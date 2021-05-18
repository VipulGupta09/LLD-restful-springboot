package org.learning.designpattern.factorymethod;

import org.learning.designpattern.factorymethod.concrete.Message;
import org.learning.designpattern.factorymethod.concrete.StringMessage;

public class StringMessageCreator extends MessageCreator{

	@Override
	public Message createMessage() {
		return new StringMessage();
	}

}
