package org.learning.designpattern.abstractfactory;

import org.learning.designpattern.abstractfactory.Instance.Capacity;
import org.learning.designpattern.abstractfactory.aws.AwsResourceFactory;
import org.learning.designpattern.abstractfactory.gcp.GoogleResourceFactory;

public class Client {
	private ResourceFactory factory;
	
	public Client(ResourceFactory factory) {
		this.factory = factory;
	}
	
	public Instance createServer(Instance.Capacity capacity,int storageMib) {
		Instance instance = factory.createInstance(capacity);
		Storage storage = factory.createStorage(storageMib);
		instance.attachStorage(storage);
		return instance;
	}
	
	public static void main(String[] args) {
		Client aws = new Client(new AwsResourceFactory());
		Instance i1 = aws.createServer(Capacity.micro, 20480);
		i1.start();
		i1.stop();
		System.out.println("*************************************");
		Client gcp = new Client(new GoogleResourceFactory());
		Instance i2 = gcp.createServer(Capacity.micro, 20480);
		i2.start();
		i2.stop();
	}
}
