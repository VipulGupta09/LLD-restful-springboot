package org.learning.designpattern.abstractfactory.gcp;

import org.learning.designpattern.abstractfactory.Storage;

public class GoogleCloudStorage implements Storage{

	public GoogleCloudStorage(int capacity) {
		System.out.println("Allocated capaity GoogleCloudStorage "+capacity);
	}
	
	@Override
	public String getId() {
		return "gcs001";
	}

	@Override
	public String toString() {
		return "GoogleCloudStorage ";
	}
	
	

}
