package com.techiekernel.model;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@XmlRootElement
@JsonAutoDetect
public class FooBar {
	int id;
	String name;

	public FooBar() {
		this.id = 1;
		this.name = "Techie Kernel";

	}
	
	public FooBar(int id, String name) {
		this.id = id;
		this.name = name;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FooBar [id=" + id + ", name=" + name + ", hashCode()="
				+ hashCode() + "]";
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof FooBar) {
			if(this.id == ((FooBar)obj).id)
				return true;
		}
		return false;
	}
	
}