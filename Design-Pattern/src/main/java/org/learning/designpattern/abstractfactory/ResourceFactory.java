package org.learning.designpattern.abstractfactory;

public interface ResourceFactory {

	Instance createInstance(Instance.Capacity capacity);

	Storage createStorage(int capMib);
}
