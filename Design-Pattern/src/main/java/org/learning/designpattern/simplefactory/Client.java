package org.learning.designpattern.simplefactory;

public class Client {
	public static void main(String[] args) {
		ObjectFactory objFac = new ObjectFactory();
		OS os = objFac.getInstance("skdfj");
		if(os!=null)
		os.specifications();
		
		
	}
}
