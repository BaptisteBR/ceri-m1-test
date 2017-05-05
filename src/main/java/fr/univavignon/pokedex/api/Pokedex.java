package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Pokedex class. Impelments IPokedex interface.
 * 
 * @author Baptiste
 *
 */
public class Pokedex implements IPokedex {
	
	/**
	 * Store Pokedex's pokemon list.
	 */
	private static List<Pokemon> listPokemon = null;
	
	/**
	 * Provider to get Pokemon's metadata.
	 */
	private IPokemonMetadataProvider provider;
	
	/**
	 * Factory to create Pokemons.
	 */
	private IPokemonFactory factory;
	
	/**
	 * Constructor.
	 * 
	 * @param provider Provider to get Pokemon's metadata.
	 * @param factory Factory to create Pokemons.
	 */
	public Pokedex(IPokemonMetadataProvider provider, IPokemonFactory factory) {
		
		this.provider = provider;
		this.factory = factory;
		
	}

	/**
	 * Get Pokemon's metadata from index.
	 * 
	 * @param index Pokemon's index.
	 * @return Pokemon's metadata got from provider.
	 */
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		
		return provider.getPokemonMetadata(index);
		
	}

	/**
	 * Create a Pokemon from properties.
	 * 
	 * @param index Numeric index.
	 * @param cp Fight level.
	 * @param hp Life points.
	 * @param dust Dust points
	 * @param candy Candies number.
	 * @return Pokemon created by the factory.
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		
		return factory.createPokemon(index, cp, hp, dust, candy);
		
	}

	/**
	 * Get size of Pokedex.
	 * 
	 * @return Number of Pokemons store in the Pokedex.
	 */
	@Override
	public int size() {

		return this.getPokemons().size();
		
	}

	/**
	 * Add a Pokemon to the Pokedex.
	 * 
	 * @param pokemon Pokemon to add.
	 * @return Index of added Pokemon.
	 */
	@Override
	public int addPokemon(Pokemon pokemon) {
		
		/*
		for (int i : this.getPokemons().) {
		
			try {
				
				this.getPokemon(i);
				
			}
			catch (PokedexException e) {
				
				this.getPokemons().add(i, pokemon);
				
				return i;
				
			}
			
		}		
		*/
		
		this.getPokemons().add(pokemon);
		
		return this.getPokemons().indexOf(pokemon);
		
	}

	/**
	 * Get Pokemon from list index.
	 * 
	 * @param id Index to search.
	 * @throws PokedexException Throws when index doesn't exist.
	 * @return Pokemon at the specified index.
	 */
	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		
		try {
			
			return this.getPokemons().get(id);
			
		}
		catch (IndexOutOfBoundsException e) {
			
			throw new PokedexException("Index doesn't exist !");
			
		}

	}

	/**
	 * Retrieve Pokemons list from the Pokedex.
	 * 
	 * @return Pokemons list.
	 */
	@Override
	public List<Pokemon> getPokemons() {
		
		if (listPokemon == null) {
			
			listPokemon = new ArrayList<Pokemon>();
			
		}
		
		return listPokemon;
		
	}

	/**
	 * Retrieve Pokemons list ordered by the comparator.
	 * 
	 * @param order Comparator to order the list.
	 * @return Pokemons list ordered.
	 */
	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		
		List<Pokemon> pokemons = this.getPokemons();
		
		pokemons.sort(order);
		
		return pokemons;
		
	}
	
	/**
	 * Compare two Pokedex.
	 * 
	 * @param obj Pokedex to compare with current.
	 * @return Indicate if the two Pokedex are equals.
	 */
	@Override
	public boolean equals(Object obj) {
		
		Pokedex pokedex = (Pokedex) obj;
		
		if (pokedex.size() != this.size()) {
			
			return false;
			
		}
		
		return true;
		
	}

}
