package com.techiekernel.service;

import java.util.Iterator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techiekernel.model.FooBar;
import com.techiekernel.model.FooBarSet;

/**
 * This exmaple has been created to demonstrate the @path for JAX-RS
 * 
 * @author satish
 * 
 */
@Controller
@RequestMapping("/foobaresample1")
public class FooBarServiceExample1 {

	static FooBarSet fooBarSet;

	static {
		fooBarSet = new FooBarSet();
		FooBar foobar = null;
		for (int i = 0; i < 10; i++) {
			foobar = new FooBar(i, "TechieKernel" + i);
			fooBarSet.add(foobar);
		}
	}

	/**
	 * Normal URI Mapping with parameter
	 * @param foobarId
	 * @return
	 */
	@RequestMapping(value = "/{foobarId}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public FooBar getFoobar(@PathVariable int foobarId) {
		for (FooBar foobar : fooBarSet) {
			if (foobar.getId() == foobarId)
				return foobar;
		}
		return null;
	}

	/**
	 * Normal URI Mapping
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public FooBarSet getFoobars() {
		return fooBarSet;
	}

	/**
	 * URI mapping and regular expression
	 * @param foobarId
	 * @return
	 */
	@RequestMapping("/id/{foobarId:\\d+}")
	@ResponseBody
	public FooBar getFoobarById(@PathVariable int foobarId) {
		for (FooBar foobar : fooBarSet) {
			if (foobar.getId() == foobarId)
				return foobar;
		}
		return null;
	}

	/**
	 * URI mapping and regular expression
	 * @param foobarName
	 * @return
	 */
	@RequestMapping("/name/{foobarName:[a-zA-Z_0-9]+}")
	@ResponseBody
	public FooBar getFoobarByName(@PathVariable String foobarName) {
		for (FooBar foobar : fooBarSet) {
			if (foobar.getName().equalsIgnoreCase(foobarName))
				return foobar;
		}
		return null;
	}
}
