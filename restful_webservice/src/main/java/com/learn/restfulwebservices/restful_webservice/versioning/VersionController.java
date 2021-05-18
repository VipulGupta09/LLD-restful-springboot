package com.learn.restfulwebservices.restful_webservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

	// URI Versioning
	// Twitter
	@GetMapping(path = "v1/person")
	public PersonV1 personV1() {
		return new PersonV1("PersonV1");
	}

	@GetMapping(path = "v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("PersonV2", "PerosnV2"));
	}

	// Request param versioning
	// Amazon
	@GetMapping(path = "person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("PersonV1");
	}

	@GetMapping(path = "person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("PersonV2", "PerosnV2"));
	}

	// Header param
	// Microsoft
	@GetMapping(path = "person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("PersonV1");
	}

	@GetMapping(path = "person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("PersonV2", "PerosnV2"));
	}
	
	// produces // mime-type-version // accept-header versioning // content negotiation // media-type versioning
	// GITHUB 
		@GetMapping(path = "person/produces", produces  = "application/myCompany-app-v1+json")
		public PersonV1 producesV1() {
			return new PersonV1("PersonV1");
		}

		@GetMapping(path = "person/produces", produces  = "application/myCompany-app-v2+json")
		public PersonV2 producesV2() {
			return new PersonV2(new Name("PersonV2", "PerosnV2"));
		}

}
