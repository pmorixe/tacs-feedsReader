package ar.edu.utn.frba.tacs.grupo1.domain;

import java.text.spi.DateFormatProvider;
import java.util.Date;

import org.joda.time.DateTime;

public class Subscription {

	private Long id;

	private String url;
	
	private Date since = new Date();

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

	public Date getSince() {
		return since;
	}

	public void setSince(Date since) {
		this.since = since;
	}

}
