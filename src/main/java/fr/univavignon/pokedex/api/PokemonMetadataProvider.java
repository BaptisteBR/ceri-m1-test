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
 * 
 * @author Baptiste
 *
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {
	
	/**
	 * 
	 */
	private static final String url = "https://raw.githubusercontent.com/PokemonGo-Enhanced/node-pokemongo-data/master/data.json";
	
	/**
	 * 
	 */
	private static final String indexKey = "PkMn";
	
	/**
	 * 
	 */
	private static final String nameKey = "Identifier";
	
	/**
	 * 
	 */
	private static final String attackKey = "BaseAttack";
	
	/**
	 * 
	 */
	private static final String defenseKey = "BaseDefense";
	
	/**
	 * 
	 */
	private static final String staminaKey = "BaseStamina";
	
	/**
	 * 
	 */
	private List<PokemonMetadata> listPokemonMetadata = null;

	/**
	 * 
	 */
	public PokemonMetadataProvider() {}
	
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
		
		System.out.println("this.listPokemonMetadata.size(): " + this.listPokemonMetadata.size());
		
		for (PokemonMetadata metadata : this.listPokemonMetadata) {
			
			if (metadata.getIndex() == index) {
				
				System.out.println("metadata.getIndex(): " + metadata.getIndex());
				
				return metadata;
				
			}
			
		}
		
		throw new PokedexException("Index doesn't exist !");
		
	}
	
	/**
	 * 
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
				
				System.out.println("metadata.getIndex(): " + metadata.getIndex());
					
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
	 * 
	 * @param url
	 * @return
	 */
	@SuppressWarnings("deprecation")
	private String requestDataFromWeb(String url) throws IOException{
		
		try (InputStream is = new URL(url).openStream()) {
			
			return IOUtils.toString(is);
			
		}
		
	}

}
