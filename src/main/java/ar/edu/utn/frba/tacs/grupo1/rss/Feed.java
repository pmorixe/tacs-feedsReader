package ar.edu.utn.frba.tacs.grupo1.rss;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.utn.frba.tacs.grupo1.rss.FeedMessage;

/**
 * 
 * La idea es representar una URL, hacia un RSS. Formato http://..../algo.rss
 * 
 */
public class Feed {

	String title; // Titulo del Feed
	String url; // URL propiamente dicha
	String copyright; // Derechos
	String language; // Lenguaje del Feed
	String pubDate; // Fecha de Publicación
	String summary; // Descripción
	Date createdDate; // Fecha de actualización

	final List<FeedMessage> entries = new ArrayList<FeedMessage>(); // Lista de
																	// actualizaciones

	public Feed(String title, String url, String summary, String language,
			String copyright, String pubDate) {
		this.title = title;
		this.url = url;
		this.summary = summary;
		this.language = language;
		this.copyright = copyright;
		this.pubDate = pubDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public List<FeedMessage> getEntries() {
		return entries;
	}

}
