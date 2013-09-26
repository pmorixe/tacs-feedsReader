package ar.edu.utn.frba.tacs.grupo1.parser;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import ar.edu.utn.frba.tacs.grupo1.domain.Entry;
import ar.edu.utn.frba.tacs.grupo1.domain.Feed;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedIOException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedParser;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.RSSFeedXMLParseException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.UnsupportedRSSFeedException;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RSSFeed;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RSSFeedHeader;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RSSFeedItem;

public class FeedParser{
	
	private URL url;
	
	public FeedParser(String url) throws MalformedURLException{
		/*Burbujea excepción MalformedURLException()*/
		this.url = new URL(url);
	}
	
	public Feed readFeed() throws UnsupportedRSSFeedException, RSSFeedIOException, RSSFeedXMLParseException {
		/**
		 * Gets the feed from an URL and parses it.
		 * 
		 * @param url
		 *            The feed URL.
		 * @return A Feed object containing the information extracted from the feed.
		 * @throws RSSFeedIOException
		 *             I/O error during conetnts retrieving.
		 * @throws RSSFeedXMLParseException
		 *             The document retrieved is not valid XML.
		 * @throws UnsupportedRSSFeedException
		 *             The XML retrieved does not represents a feed whose kind is
		 *             known by the parser.
		 */
		
		/*Cargo la URL*/
		RSSFeed feed = RSSFeedParser.parse(this.url);
		
		/*Obtengo la parte principal y obligatoria del Feed*/
		RSSFeedHeader header = feed.getHeader();
		
		
		Feed domainFeed = new Feed(header.getTitle(), header.getLink().toString(), header.getDescription(), header.getLanguage(), null, header.getPubDate().toString());
		
		/*Obtengo el cuerpo, no obligatoria del Feed*/
		List<Entry> list = new ArrayList<Entry>();

		int countItem =  feed.getItemCount();
		
		for (int index = 0; index < countItem; index++) {
			RSSFeedItem item = feed.getItem(index);
			list.add( new Entry(item.getTitle(), item.getDescriptionAsText(), item.getLink().toString(), null, item.getGUID()) );
	    }
		domainFeed.setEntries(list);
		
		return domainFeed;
	}
	
}
	