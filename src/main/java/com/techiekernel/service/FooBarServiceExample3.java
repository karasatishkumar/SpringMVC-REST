package com.techiekernel.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techiekernel.model.FooBar;
import com.techiekernel.model.FooBarSet;

/**
 * This exmaple has been created to demonstrate the @RequestParam for JAX-RS.
 * 
 * @author satish
 * 
 */
@Controller
@RequestMapping("/foobaresample3")
public class FooBarServiceExample3 {

	static FooBarSet fooBarSet;

	static {
		fooBarSet = new FooBarSet();
		FooBar foobar = null;
		for (int i = 0; i < 10; i++) {
			foobar = new FooBar(i, "TechieKernel" + i);
			fooBarSet.add(foobar);
		}
	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public FooBar getFoobar(@RequestParam int foobarId) {
		for (FooBar foobar : fooBarSet) {
			if (foobar.getId() == foobarId)
				return foobar;
		}
		return null;
	}
	
	@RequestMapping(value= "/name" ,method = RequestMethod.GET, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public FooBar getFoobar(@RequestParam int foobarId, @RequestParam String name) {
		for (FooBar foobar : fooBarSet) {
			if (foobar.getId() == foobarId && foobar.getName().equalsIgnoreCase(name))
				return foobar;
		}
		return null;
	}
}
