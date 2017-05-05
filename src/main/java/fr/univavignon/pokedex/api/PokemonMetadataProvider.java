package fr.univavignon.pokedex.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * PokemonMetadataProvider class. Implements IPokemonMetadataProvider
 * 
 * @author Baptiste
 *
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {
	
	/**
	 * Path to get metadata list for all Pokemons.
	 */
	private static final String url = "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
	
	/**
	 * Key to retrieve Pokemon's numeric index.
	 */
	private static final String indexKey = "PkMn";
	
	/**
	 * Key to retrieve Pokemon's name.
	 */
	private static final String nameKey = "Identifier";
	
	/**
	 * Key to retrieve Pokemon's attack level.
	 */
	private static final String attackKey = "BaseAttack";
	
	/**
	 * Key to retrieve Pokemon's defense level.
	 */
	private static final String defenseKey = "BaseDefense";
	
	/**
	 * Key to retrieve Pokemon's stamina.
	 */
	private static final String staminaKey = "BaseStamina";
	
	/**
	 * List to store Pokemons metadata.
	 */
	private List<PokemonMetadata> listPokemonMetadata = null;

	/**
	 * Constructor.
	 */
	public PokemonMetadataProvider() {}
	
	/**
	 * Get Pokemon metadata from numeric index.
	 * 
	 * @param index Numeric index of searched Pokemon.
	 * @throws PokedexException Exception throws if an error occured.
	 * @return Pokemon meatadata at the specified index.
	 */
	/**{@inheritDoc}}**/
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		
		if (this.listPokemonMetadata == null) {
			
			this.listPokemonMetadata = getFromWeb();
			
		}
		
		if (this.listPokemonMetadata.isEmpty()) {
			
			throw new PokedexException("Unable to get list of Pokemon metadata !");
			
		}
		
		if (index < 0) {
			
			throw new PokedexException("Negative index is forbidden !");
			
		}
		
		for (PokemonMetadata metadata : this.listPokemonMetadata) {
			
			if (metadata.getIndex() == index) {
				
				return metadata;
				
			}
			
		}
		
		throw new PokedexException("Index doesn't exist !");
		
	}
	
	/**
	 * Get list of Pokemon metadata from the web.
	 * 
	 * @throws IOException Exception occured when unable to get web response.
	 * @throws JSONException Exception occured when parse data.
	 * @return List of Pokemons metadata.
	 */
	private List<PokemonMetadata> getFromWeb() {
		
		List<PokemonMetadata> listMetadata = new ArrayList<PokemonMetadata>();
		
		try {
			
			String data = requestDataFromWeb(url);
			
			JSONArray array = new JSONArray(data);
			
			JSONObject object;
			
			PokemonMetadata metadata;
			
			for (int i = 0; i < array.length(); i++) {
				
				object = array.getJSONObject(i);
					
				metadata = new PokemonMetadata(
						object.getInt(indexKey),
						object.getString(nameKey),
						object.getInt(attackKey),
						object.getInt(defenseKey),
						object.getInt(staminaKey)
				);
					
				//listMetadata.add(metadata.getIndex(), metadata);
				listMetadata.add(metadata);
				
			}
			
		}
		catch (IOException e) {
			
			e.printStackTrace();
			
		}
		catch (JSONException e) {
			
			e.printStackTrace();
			
		}
		
		return listMetadata;
		
	}
	
	/**
	 * Request data from the web, using URL passed in parameter.
	 * 
	 * @param url URL to retrieve JSON data.
	 * @throws IOException Exception throws when open stream to get data.
	 * @return Response in string format.
	 */
	@SuppressWarnings("deprecation")
	private String requestDataFromWeb(String url) throws IOException{
		
		try (InputStream is = new URL(url).openStream()) {
			
			return IOUtils.toString(is);
			
		}
		
	}

}
