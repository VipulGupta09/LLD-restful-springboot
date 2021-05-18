package org.learning.designpattern.abstractfactory.aws;

import org.learning.designpattern.abstractfactory.Instance;
import org.learning.designpattern.abstractfactory.Instance.Capacity;
import org.learning.designpattern.abstractfactory.ResourceFactory;
import org.learning.designpattern.abstractfactory.Storage;

public class AwsResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new Ec2Instance();
	}

	@Override
	public Storage createStorage(int capMib) {
		return new S3Storage(capMib);
	}

}
