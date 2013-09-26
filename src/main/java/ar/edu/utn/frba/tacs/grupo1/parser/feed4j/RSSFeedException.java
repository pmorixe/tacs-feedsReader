package ar.edu.utn.frba.tacs.grupo1.parser.feed4j;

/**
 * The base kind of the exceptions thrown by the feed parser.
 * 
 * @author Carlo Pelliccia
 */
public abstract class RSSFeedException extends Exception {

	public RSSFeedException() {
		super();
	}

	public RSSFeedException(String message, Throwable cause) {
		super(message, cause);
	}

	public RSSFeedException(String message) {
		super(message);
	}

	public RSSFeedException(Throwable cause) {
		super(cause);
	}

}
