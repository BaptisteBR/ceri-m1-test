package fr.univavignon.pokedex.api;

/**
 * Custom exception for data writer PokemonTrainerWriter.
 * 
 * @author Baptiste
 *
 */
@SuppressWarnings("serial")
public class PokemonTrainerWriterException extends Exception {

	/**
	 * Constructor.
	 */
	public PokemonTrainerWriterException() {}
	
	/**
	 * Constructor with custom message.
	 * 
	 * @param message Message to print.
	 */
	public PokemonTrainerWriterException(String message) {
		
		super(message);
		
	}
	
	/**
	 * Constructor with custom message, and cause.
	 * 
	 * @param message Message to print.
	 * @param cause Cause of the exception.
	 */
	public PokemonTrainerWriterException(String message, Throwable cause) {
		
		super(message, cause);
		
	}
	
	/**
	 * Constructor with cause.
	 * 
	 * @param cause Cause of the exception.
	 */
	public PokemonTrainerWriterException(Throwable cause) {
		
		super(cause);
		
	}
	
}
