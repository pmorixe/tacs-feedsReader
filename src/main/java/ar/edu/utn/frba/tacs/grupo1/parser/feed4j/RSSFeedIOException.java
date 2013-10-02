package ar.edu.utn.frba.tacs.grupo1.parser.feed4j;

/**
 * This kind of exception is thrown by the parser every time a I/O error occurs
 * during the reading of a feed.
 * 
 * @author Carlo Pelliccia
 */
public class RSSFeedIOException extends RSSFeedException {

	private static final long serialVersionUID = 1L;

	public RSSFeedIOException() {
		super();
	}

	public RSSFeedIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public RSSFeedIOException(String message) {
		super(message);
	}

	public RSSFeedIOException(Throwable cause) {
		super(cause);
	}

}
