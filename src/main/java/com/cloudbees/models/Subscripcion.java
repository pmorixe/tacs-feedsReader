package com.cloudbees.models;

public class Subscripcion {

	private Long subcripcionId;

	private String url;

	public Subscripcion() {
	}

	public Subscripcion(Long id, String url) {
		this.subcripcionId = id;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getSubcripcionId() {
		return subcripcionId;
	}

	public void setSubcripcionId(Long subcripcionId) {
		this.subcripcionId = subcripcionId;
	}

}
