package org.learning.designpattern.abstractfactory.aws;

import org.learning.designpattern.abstractfactory.Storage;

public class S3Storage implements Storage{

	public S3Storage(int capacity) {
		System.out.println("Allocated capaity S3Storage "+capacity);
	}
	
	@Override
	public String getId() {
		return "S3001";
	}

	@Override
	public String toString() {
		return "S3Storage cloud";
	}
	
	

}
