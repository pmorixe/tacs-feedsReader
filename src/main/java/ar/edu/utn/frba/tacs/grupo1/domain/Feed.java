package ar.edu.utn.frba.tacs.grupo1.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Feed implements Domain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String link;
	private String description;

	private int idSubscription;

	public Feed(String title, String link, String description) {
		this.title = title;
		this.link = link;
		this.description = description;
	}

	public Feed() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdSubscription() {
		return idSubscription;
	}

	public void setIdSubscription(int idSubscription) {
		this.idSubscription = idSubscription;
	}

}
