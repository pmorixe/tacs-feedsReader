package ar.edu.utn.frba.tacs.grupo1.domain.builders;

import java.util.Date;

import org.joda.time.DateTime;

import ar.edu.utn.frba.tacs.grupo1.domain.Feed;

/**
 * La idea es representar una URL, hacia un RSS. Formato http://..../algo.rss
 */
public class FeedBuilder {

  private String title = "Titulo Default"; // Titulo del Feed

  private String url = "www.default.com"; // URL propiamente dicha

  private String copyright = "copyright"; // Derechos

  private String language = "español"; // Lenguaje del Feed

  private String pubDate = "..."; // Fecha de Publicación

  private String summary = "descripcion"; // Descripción

  private Date createdDate = new DateTime().toDate(); // Fecha de actualización

  public FeedBuilder withTitle(String title) {
    this.title = title;
    return this;
  }

  public FeedBuilder withUrl(String url) {
    this.url = url;
    return this;
  }

  public FeedBuilder withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public FeedBuilder withCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  public FeedBuilder withCopyright(String copyright) {
    this.copyright = copyright;
    return this;
  }

  public FeedBuilder withLanguage(String language) {
    this.language = language;
    return this;
  }

  public FeedBuilder withPubDate(String pubDate) {
    this.pubDate = pubDate;
    return this;
  }

  public Feed build() {
    return new Feed(title, url, summary, language, copyright, pubDate);

  }
}