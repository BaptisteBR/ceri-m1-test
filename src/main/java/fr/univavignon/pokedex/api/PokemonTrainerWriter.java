package fr.univavignon.pokedex.api;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class define the JSON writer to save data locally.
 * 
 * @author Baptiste
 *
 */
public class PokemonTrainerWriter {

	/**
	 * Instance of the singleton.
	 */
	private static PokemonTrainerWriter instance;
	
	/**
	 * Writer for buffered data.
	 */
	private BufferedWriter bw;
	
	/**
	 * Writer in file.
	 */
	private FileWriter fw;
	
	/**
	 * Constructor.
	 * 
	 * @param name Name of the writer (name of file).
	 * @throws IOException Exception occured when unable to create writer components.
	 */
	private PokemonTrainerWriter(String name) throws IOException {
		
		this.fw = new FileWriter(name);
		this.bw = new BufferedWriter(fw);
		
	}
	
	/**
	 * Public method to create the writer if it doesn't exist.
	 * 
	 * @param name Name of writer.
	 * @throws IOExeption Exception occured when unable to create components.
	 */
	public static void create(String name) throws IOException {
		
		if (instance == null) {
			
			instance = new PokemonTrainerWriter(name);
			
		}
		
	}
	
	/**
	 * Return the unique instance of the singleton.
	 * 
	 * @throws PokemonTrainerWriterException Exception throws there isn't an instance.
	 * @return Unique instance of the writer.
	 */
	private static PokemonTrainerWriter getInstance() throws PokemonTrainerWriterException {
		
		if (instance == null) {
			
			throw new PokemonTrainerWriterException("PokemonTrainerWriter is not initialized !");
			
		}
		else {
			
			return instance;
			
		}
		
	}
	
	/**
	 * Public method to write data into file.
	 * 
	 * @param content Trainer's data to write.
	 * @throws IOException Exception occured when there is a problem on singleton's instance.
	 * @throws PokemonTrainerWriterException Exception throws when there is no singleton.
	 */
	public static void write(PokemonTrainer content) throws IOException, PokemonTrainerWriterException {
		
		//getInstance().bw.write(content);
		
	}
	
	/**
	 * Close the writer (close BufferedWriter and FileWriter).
	 * 
	 * @throws IOException Exception occured when a problem is detected on singleton's components.
	 * @throws PokemonTrainerWriterException Exception throws when there is problem on singleton.
	 */
	public static void close() throws IOException, PokemonTrainerWriterException {
		
		if (getInstance().bw != null) {
			
			getInstance().bw.close();
			
		}
		
		if (getInstance().fw != null) {
			
			getInstance().fw.close();
			
		}
		
	}
	
}
