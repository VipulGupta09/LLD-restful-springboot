package org.learning.designpattern.simplefactory;

public class ObjectFactory {

	public OS getInstance(String str) {
		if(str.equals("Android"))
			return new Android();
		else if(str.equals("IOS"))
			return new IOS();
		else if(str.equals("Windows"))
			return new Windows();
		else
			System.out.println("Wrong Choice!!!");
		return null;
	}
}
