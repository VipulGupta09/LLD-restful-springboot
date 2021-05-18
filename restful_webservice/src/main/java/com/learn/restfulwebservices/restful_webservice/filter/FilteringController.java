package com.learn.restfulwebservices.restful_webservice.filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@Autowired
	private FilterMethodClass filterMethodClass;
	
	@GetMapping(path = "filter")
	public MappingJacksonValue getAllValues() {
		Filter filter = new Filter("Filter1", "Filter2", "Filter3");
		MappingJacksonValue filterMethod = filterMethodClass.filterMethod(new HashSet<String>(Arrays.asList("value1","value2")), filter);
		return filterMethod;
	}
	
	@GetMapping(path = "filter-list")
	public MappingJacksonValue getListOfAllValues() {
		 List<Filter> list =  Arrays.asList(new Filter("Filter1", "Filter2", "Filter3"),
				new Filter("Filter1", "Filter2", "Filter3"));	
		 MappingJacksonValue filterMethod = filterMethodClass.filterMethod(new HashSet<String>(Arrays.asList("value2","value3")), list);
		 
		 return filterMethod;
	}

	

}
