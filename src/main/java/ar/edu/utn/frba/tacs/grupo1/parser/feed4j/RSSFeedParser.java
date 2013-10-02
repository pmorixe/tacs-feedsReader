package ar.edu.utn.frba.tacs.grupo1.parser.feed4j;

import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RSSFeed;

/**
 * The feed parser. It can parse RSS 1.0, RSS 2.0, Atom 0.3 and Atom 1.0.
 * 
 * @author Carlo Pelliccia
 */
public class RSSFeedParser {

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
	public static RSSFeed parse(URL url) throws RSSFeedIOException,
			RSSFeedXMLParseException, UnsupportedRSSFeedException {
		try {
			// Esegue il parsing iniziale del documento XML.
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(url);
			// Cerca il modulo di interpretazione del feed.
			int code = RSSFeedRecognizer.recognizeFeed(document);
			switch (code) {
			case RSSFeedRecognizer.RSS_1_0:
				return TypeRSS_1_0.feed(url, document);
			case RSSFeedRecognizer.RSS_2_0:
				return TypeRSS_2_0.feed(url, document);
			case RSSFeedRecognizer.ATOM_0_3:
				return TypeAtom_0_3.feed(url, document);
			case RSSFeedRecognizer.ATOM_1_0:
				return TypeAtom_1_0.feed(url, document);
			default:
				throw new UnsupportedRSSFeedException();
			}
		} catch (DocumentException e) {
			throw new RSSFeedXMLParseException(e);
		}
	}

}
