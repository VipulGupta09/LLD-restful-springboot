package com.learn.restfulwebservices.restful_webservice.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private MessageSource messageSource;

	/*
	 * @GetMapping(path = "/hello-world-I18N") public String
	 * helloWorldInternationalize(@RequestHeader(name = "Accept-Header", required =
	 * false) Locale locale) { return
	 * messageSource.getMessage("good.morning.message", null, locale); }
	 */
	@GetMapping(path = "/hello-world-I18N")
	public String helloWorldInternationalize() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "hello-world";
	}

	@GetMapping(path = "/hello-world-get")
	public String helloWorldGetMapping() {
		return "hello-world";
	}

	@GetMapping(path = "hello-world-bean")
	public HelloWordBean helloWorldBean() {
		return new HelloWordBean("Hello-World-Bean");
	}

	@GetMapping(path = "/hello-world-bean/{name}")
	public HelloWordBean helloWordPathVariable(@PathVariable String name) {
		return new HelloWordBean(String.format("Hello %s", name));
	}

}
