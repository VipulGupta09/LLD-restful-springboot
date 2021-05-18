package com.learn.restfulwebservices.restful_webservice.filter;

import java.util.List;
import java.util.Set;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Component
public class FilterMethodClass {

	public MappingJacksonValue filterMethod(Set<String> set, Filter bean) {

		SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.FilterExceptFilter(set);

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);

		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

	public MappingJacksonValue filterMethod(Set<String> set, List<Filter> bean) {

		SimpleBeanPropertyFilter filter = new SimpleBeanPropertyFilter.FilterExceptFilter(set);

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);

		mappingJacksonValue.setFilters(filters);

		return mappingJacksonValue;
	}

}
