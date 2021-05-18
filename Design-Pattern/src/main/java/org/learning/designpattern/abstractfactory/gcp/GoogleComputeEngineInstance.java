package org.learning.designpattern.abstractfactory.gcp;

import org.learning.designpattern.abstractfactory.Instance;
import org.learning.designpattern.abstractfactory.Storage;

public class GoogleComputeEngineInstance implements Instance{

	public GoogleComputeEngineInstance() {
		System.out.println("GoolgeComplutedEngineInstance Created...");
	}
	@Override
	public void start() {
		System.out.println("GoogleCompluteEngine started...");
		
	}

	@Override
	public void stop() {
		System.out.println("GoogleCompluteEngine stopped...");
		
	}

	@Override
	public void attachStorage(Storage storage) {
		System.out.println("GoogleCompluteEngine storage attached..."+storage);
		
	}

	@Override
	public String toString() {
		return "GoolgeComputeEngineInstance [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
