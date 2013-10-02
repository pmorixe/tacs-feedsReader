package ar.edu.utn.frba.tacs.grupo1.parser.feed4j;

/**
 * This kind of exception is thrown every time a XML parsing problem occour
 * during the parse process.
 * 
 * @author Carlo Pelliccia
 */
public class RSSFeedXMLParseException extends RSSFeedException {

	private static final long serialVersionUID = 1L;

	public RSSFeedXMLParseException() {
		super();
	}

	public RSSFeedXMLParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public RSSFeedXMLParseException(String message) {
		super(message);
	}

	public RSSFeedXMLParseException(Throwable cause) {
		super(cause);
	}

}
