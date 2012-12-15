package com.techiekernel.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techiekernel.model.FooBar;

@Controller
@RequestMapping("/foobar")
public class FooBarService {

	static Set<FooBar> fooBars;

	static {
		fooBars = new HashSet<FooBar>();
		FooBar foobar = null;
		for (int i = 0; i < 10; i++) {
			foobar = new FooBar(i, "Techie Kernel " + i);
			fooBars.add(foobar);
		}
	}

	@RequestMapping(value = "/{foobarId}", method = RequestMethod.GET, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public FooBar getFoobar(@PathVariable int foobarId) {
		for (FooBar foobar : fooBars) {
			if (foobar.getId() == foobarId)
				return foobar;
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public Set<FooBar> getFoobars() {
		return fooBars;
	}

	@RequestMapping(value = "/{foobarId}", method = RequestMethod.PUT, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	@ResponseBody
	public FooBar editFoobar(@RequestBody FooBar foobar,
			@PathVariable int foobarId) {
		for (FooBar foobar1 : fooBars) {
			if (foobarId == foobar1.getId()) {
				foobar1.setId(foobar.getId());
				foobar1.setName(foobar.getName());
				return foobar1;
			}
		}
		return null;
	}

	@RequestMapping(value = "/{foobarId}", method = RequestMethod.DELETE, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" })
	@ResponseBody
	public boolean deleteFoobar(@PathVariable int foobarId) {
		System.out.println("Delete call.");
		Iterator<FooBar> fooIterator = fooBars.iterator();
		while (fooIterator.hasNext()) {
			FooBar foobar = fooIterator.next();
			System.out.println(foobar);
			if (foobar.getId() == foobarId) {
				fooIterator.remove();
				return true;
			}
		}
		return false;
	}

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/xml, application/json", produces = {
			"application/json", "application/xml" }, consumes = {
			"application/json", "application/xml" })
	@ResponseBody
	public boolean createFoobar(@RequestBody FooBar fooBar) {
		return fooBars.add(fooBar);
	}

}
