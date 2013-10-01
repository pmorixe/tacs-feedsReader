package ar.edu.utn.frba.tacs.grupo1.domain.builders;

import ar.edu.utn.frba.tacs.grupo1.domain.Entry;

//Representa un Mensaje de Feed, un articulo o lo que sea
public class EntryBuilder {

  private String title = "Titulo Default";

  private String description = "Description";

  private String link = "www.link.com";

  private String author = "Autor";

  private String guid = "guid";

  public EntryBuilder withTitle(String title) {
    this.title = title;
    return this;
  }

  public EntryBuilder withDescription(String description) {
    this.description = description;
    return this;
  }

  public EntryBuilder withLink(String link) {
    this.link = link;
    return this;
  }

  public EntryBuilder withAuthor(String author) {
    this.author = author;
    return this;
  }

  public EntryBuilder withGuid(String guid) {
    this.guid = guid;
    return this;
  }

  public Entry build() {
    return new Entry(title, description, link, author, guid);
  }
}
