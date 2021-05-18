package org.learning.designpattern.abstractfactory.gcp;

import org.learning.designpattern.abstractfactory.Instance;
import org.learning.designpattern.abstractfactory.Instance.Capacity;
import org.learning.designpattern.abstractfactory.ResourceFactory;
import org.learning.designpattern.abstractfactory.Storage;

public class GoogleResourceFactory implements ResourceFactory {

	@Override
	public Instance createInstance(Capacity capacity) {
		return new GoogleComputeEngineInstance();
	}

	@Override
	public Storage createStorage(int capMib) {
		return new GoogleCloudStorage(capMib);
	}

}
