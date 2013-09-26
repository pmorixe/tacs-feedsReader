package ar.edu.utn.frba.tacs.grupo1.parser.feed4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;

import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RSSFeed;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RSSFeedHeader;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RSSFeedImage;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RSSFeedItem;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RawElement;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.bean.RawNode;
import ar.edu.utn.frba.tacs.grupo1.parser.feed4j.html.HTMLFragmentHelper;

/**
 * RSS 1.0 feed parser.
 * 
 * @author Carlo Pelliccia
 */
class TypeRSS_1_0 extends TypeAbstract {

	/**
	 * This method parses a dom4j Document representation assuming it is RSS 1.0
	 * feed.
	 * 
	 * @param source
	 *            The source URL for the feed.
	 * @param document
	 *            The dom4j Document representation of the XML representing the
	 *            feed.
	 * @return The Feed object representing the feed parsed contents.
	 */
	public static RSSFeed feed(URL source, Document document) {
		// Root element.
		Element root = document.getRootElement();
		// Return value.
		RSSFeed feed = new RSSFeed();
		// Start from the header.
		RSSFeedHeader header = new RSSFeedHeader();
		header.setURL(source);
		// Search for the "channel" and the "item" elements.
		Element channel = null;
		for (Iterator i = root.elementIterator(); i.hasNext();) {
			Element aux = (Element) i.next();
			String nsuri = aux.getNamespaceURI();
			if (nsuri.equals(Constants.RSS_1_0_NS_URI)) {
				String name = aux.getName();
				if (name.equals("item")) {
					RSSFeedItem item = handleItem(source, aux);
					if (item != null) {
						feed.addItem(item);
					}
				} else if (channel == null && name.equals("channel")) {
					channel = aux;
				}
			}
		}
		// Channel?
		if (channel != null) {
			// From channel to header, raw.
			populateRawElement(header, channel);
			// Parse every raw element and build non-raw ones.
			for (int i = 0; i < header.getNodeCount(); i++) {
				RawNode node = header.getNode(i);
				if (node instanceof RawElement) {
					RawElement element = (RawElement) node;
					String ensuri = element.getNamespaceURI();
					String ename = element.getName();
					String evalue = element.getValue();
					if (evalue != null) {
						// Textual element.
						if (ensuri.equals(Constants.RSS_1_0_NS_URI)) {
							if (ename.equals("title")) {
								header.setTitle(evalue);
							} else if (ename.equals("description")) {
								header.setDescription(evalue);
							} else if (ename.equals("link")) {
								try {
									header.setLink(new URL(evalue));
								} catch (MalformedURLException e) {
									;
								}
							}
						} else if (ensuri.equals(Constants.DC_NS_URI)) {
							if (evalue != null) {
								if (ename.equals("date")) {
									try {
										header
												.setPubDate(Constants.ISO_8601_DATE_FORMAT
														.parse(evalue));
									} catch (ParseException e) {
										;
									}
								} else if (ename.equals("language")) {
									if (isValidLanguageCode(evalue)) {
										header.setLanguage(evalue);
									}
								}
							}
						}
					} else {
						if (ensuri.equals(Constants.RSS_1_0_NS_URI)) {
							if (ename.equals("image")) {
								RSSFeedImage image = handleImage(element);
								if (image != null) {
									header.setImage(image);
								}
							}
						}
					}
				}
			}
		}
		// Remove from the header raw elements the handled image.
		RawElement[] rawimages = header.getElements(Constants.RSS_1_0_NS_URI,
				"image");
		for (int i = 0; i < rawimages.length; i++) {
			header.removeNode(rawimages[i]);
		}
		// Add the header
		feed.setHeader(header);
		// Well done!
		return feed;
	}

	/**
	 * Items handler.
	 */
	private static RSSFeedItem handleItem(URL source, Element el) {
		RSSFeedItem item = new RSSFeedItem();
		// Raw population.
		populateRawElement(item, el);
		// About -> GUID
		String rssGuid = item.getAttributeValue(Constants.RDF_NS_URI, "about");
		// Non-raw population.
		for (int i = 0; i < item.getNodeCount(); i++) {
			RawNode node = item.getNode(i);
			if (node instanceof RawElement) {
				RawElement element = (RawElement) node;
				String ensuri = element.getNamespaceURI();
				String ename = element.getName();
				String evalue = element.getValue();
				if (evalue != null) {
					// Textual element
					if (ensuri.equals(Constants.RSS_1_0_NS_URI)) {
						if (ename.equals("title")) {
							item.setTitle(evalue);
						} else if (ename.equals("link")) {
							try {
								item.setLink(new URL(evalue));
							} catch (MalformedURLException e) {
								;
							}
						} else if (ename.equals("description")) {
							item.setDescriptionAsText(evalue);
							item.setDescriptionAsHTML(HTMLFragmentHelper
									.fromTextPlainToHTML(evalue));
						}
					} else if (ensuri.equals(Constants.DC_NS_URI)) {
						if (evalue != null) {
							if (ename.equals("date")) {
								try {
									item
											.setPubDate(Constants.ISO_8601_DATE_FORMAT
													.parse(evalue));
								} catch (ParseException e) {
									;
								}
							}
						}
					}
				}
			}
		}
		// Valid?
		if (item.getTitle() == null || item.getLink() == null) {
			// No!
			return null;
		}
		// GUID for the item.
		if (rssGuid == null) {
			rssGuid = item.getLink().toExternalForm();
		}
		item.setGUID(buildGUID(source.hashCode(), rssGuid.hashCode()));
		// Well done!
		return item;
	}

	/**
	 * Channel image handler.
	 */
	private static RSSFeedImage handleImage(RawElement rawImage) {
		RSSFeedImage image = new RSSFeedImage();
		// Raw population.
		populateRawElement(image, rawImage);
		// Non-raw population.
		String value = image.getElementValue(Constants.RSS_1_0_NS_URI, "url");
		if (value != null) {
			try {
				image.setURL(new URL(value));
			} catch (MalformedURLException e) {
				;
			}
		}
		value = image.getElementValue(Constants.RSS_1_0_NS_URI, "title");
		if (value != null) {
			image.setDescription(value);
		}
		// Valid?
		if (image.getURL() == null) {
			return null;
		}
		// Well done!
		return image;
	}

}
