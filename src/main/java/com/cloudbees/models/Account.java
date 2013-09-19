package com.cloudbees.models;

import java.util.concurrent.atomic.AtomicLong;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Account {
	
	private Long id;
	
	@NotNull
	@Size(min=1, max=25)
	private String name = "Juan";
	
	@NotNull
	@Size(min=1, max=25)
	private String lastName = "De Los Palotes";
	
	@NotNull
	@Size(min=1, max=1024)
	private String urlFeed = "";
	
	public Long getId() {
		return id;
	}

	void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	
	public String getlastName() {
		return lastName;
	}


	public void setName(String name) {
		this.name = name;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUrlFeed() {
		return urlFeed;
	}

	public void setUrlFeed(String urlFeed) {
		this.urlFeed = urlFeed;
	}


	public Long assignId() {
		this.id = idSequence.incrementAndGet();
		return id;
	}
	
	private static final AtomicLong idSequence = new AtomicLong();
	
}