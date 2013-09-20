package com.cloudbees.models;

import java.text.spi.DateFormatProvider;

import org.joda.time.DateTime;

public class Subscription {

	private Long id;

	private String url;
	
	private DateTime since = new DateTime();

	public Subscription() {
	}

	public Subscription(Long id, String url) {
		this.id = id;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DateTime getSince() {
		return since;
	}

	public void setSince(DateTime since) {
		this.since = since;
	}

}
