package org.learning.designpattern.factorymethod.concrete;

public class JsonMessage extends Message {

	@Override
	public String getContent() {
		return "JSONMessage";
	}

}
