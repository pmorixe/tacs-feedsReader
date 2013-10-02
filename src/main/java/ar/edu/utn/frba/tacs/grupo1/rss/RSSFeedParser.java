package ar.edu.utn.frba.tacs.grupo1.rss;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedParser {
	
	private URL url;

	public RSSFeedParser(String feedUrl) {
		try {
			this.url = new URL(feedUrl);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public Feed readFeed() {
		Feed feeds = null;
		try {
			boolean isFeedHeader = true;
			String description = "";
			String title = "";
			String link = "";
			String language = "";
			String copyright = "";
			String author = "";
			String pubdate = "";
			String guid = "";

			// Obtengo una instancia del manejador de XML
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			
			//Obtengo un lector
			XMLEventReader eventReader = inputFactory.createXMLEventReader(this.read());

			// Leo el XML
			while (eventReader.hasNext()) {
				//Obtengo el evento
				XMLEvent event = eventReader.nextEvent();
				if (event.isStartElement()) {
					String localPart = event.asStartElement().getName()
							.getLocalPart();
					//Se puede mejorar, pero me 
					switch (localPart) {
					case "item":
						if (isFeedHeader) {
							isFeedHeader = false;
							feeds = new Feed(title, link, description,
									language, copyright, pubdate);
						}
						event = eventReader.nextEvent();
						break;
					case "title":
						title = getCharacterData(event, eventReader);
						break;
					case "description":
						description = getCharacterData(event, eventReader);
						break;
					case "link":
						link = getCharacterData(event, eventReader);
						break;
					case "guid":
						guid = getCharacterData(event, eventReader);
						break;
					case "language":
						language = getCharacterData(event, eventReader);
						break;
					case "author":
						author = getCharacterData(event, eventReader);
						break;
					case "pubDate":
						pubdate = getCharacterData(event, eventReader);
						break;
					case "copyright":
						copyright = getCharacterData(event, eventReader);
						break;
					}
				} else if (event.isEndElement()) {
					if (event.asEndElement().getName().getLocalPart() == ("item")) {
						FeedMessage message = new FeedMessage();
						message.setAuthor(author);
						message.setDescription(description);
						message.setGuid(guid);
						message.setLink(link);
						message.setTitle(title);
						feeds.getEntries().add(message);	
						event = eventReader.nextEvent();
						continue;
					}
				}
			}
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
		return feeds;
	}

	private String getCharacterData(XMLEvent event, XMLEventReader eventReader)
			throws XMLStreamException {
		String result = "";
		event = eventReader.nextEvent();
		if (event instanceof Characters) {
			result = event.asCharacters().getData();
		}
		return result;
	}

	/**
	 * Convierto el recurso URL en entrada de datos(Input) en forma de
	 * flujo(Stream)
	 * 
	 * @return InputStream
	 */
	private InputStream read() {
		try {
			return url.openStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
