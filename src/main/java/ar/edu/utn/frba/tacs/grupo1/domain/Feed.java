package ar.edu.utn.frba.tacs.grupo1.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * La idea es representar una URL, hacia un RSS. Formato http://..../algo.rss
 */
public class Feed implements Domain, Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String title; // Titulo del Feed

  private String url; // URL propiamente dicha

  private String copyright; // Derechos

  private String language; // Lenguaje del Feed

  private String pubDate; // Fecha de Publicación

  private String summary; // Descripción

  private Date createdDate; // Fecha de actualización

  private Subscription subscription;// Subscripción padre

  private List<Entry> entries = new ArrayList<Entry>(); // Lista de actualizaciones

  public Feed(String title, String url, String summary, String language, String copyright, String pubDate) {
    this.title = title;
    this.url = url;
    this.summary = summary;
    this.language = language;
    this.copyright = copyright;
    this.pubDate = pubDate;
  }

  public Feed() {
    // TODO Auto-generated constructor stub
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

  public List<Entry> getEntries() {
    return entries;
  }

  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Subscription getSubscription() {
    return subscription;
  }

  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }

}