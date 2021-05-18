package org.learning.designpattern.abstractfactory.aws;

import org.learning.designpattern.abstractfactory.Instance;
import org.learning.designpattern.abstractfactory.Storage;

public class Ec2Instance implements Instance{
	
	public  Ec2Instance() {
		System.out.println("Created Ec2Instance...");
	}

	@Override
	public void start() {
		System.out.println("Ec2Instance storage started...");
		
	}

	@Override
	public void stop() {
		 System.out.println("Ec2Instance storage stopped...");
		
	}

	@Override
	public void attachStorage(Storage storage) {
		 System.out.println("Ec2Instance storage attached..."+storage);
		
	}

	@Override
	public String toString() {
		return "Ec2Instance [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
