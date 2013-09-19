package com.cloudbees.models;

public class Subscription {

	private Long id;

	private String url;

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

}
