package ar.edu.utn.frba.tacs.grupo1.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Representa un Mensaje de Feed, un articulo o lo que sea
public class Entry {

  public Entry(String title, String description, String link, String author, String guid) {
    this.title = title;
    this.description = description;
    this.link = link;
    this.author = author;
    this.guid = guid;

  }

  public Entry() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private String title;

  private String description;

  private String link;

  private String author;

  private String guid;

  private Feed feed;// Padre

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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public Feed getFeed() {
    return feed;
  }

  public void setFeed(Feed feed) {
    this.feed = feed;
  }

  @Override
  public String toString() {
    return "FeedMessage [title=" + title + ", description=" + description + ", link=" + link + ", author="
        + author + ", guid=" + guid + "]";
  }

}
