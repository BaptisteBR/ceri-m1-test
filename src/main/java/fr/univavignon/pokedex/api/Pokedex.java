package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * @author Baptiste
 *
 */
public class Pokedex implements IPokedex {
	
	/**
	 * 
	 */
	private List<Pokemon> listPokemon = null;

	/**
	 * 
	 */
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		
		PokemonMetadataProvider provider = new PokemonMetadataProvider();
		
		return provider.getPokemonMetadata(index);
		
	}

	/**
	 * 
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		
		PokemonFactory factory = new PokemonFactory();
		
		return factory.createPokemon(index, cp, hp, dust, candy);
		
	}

	/**
	 * 
	 */
	@Override
	public int size() {

		return this.getPokemons().size();
		
	}

	/**
	 * 
	 */
	@Override
	public int addPokemon(Pokemon pokemon) {

		for (int i = 0; i < this.size(); i++) {
		
			try {
				
				if (this.getPokemon(i) == null) {
					
					this.getPokemons().add(pokemon);
					
					return i;
					
				}
				
			}
			catch (PokedexException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		this.getPokemons().add(this.size(), pokemon);
		
		return this.size() - 1;
		
	}

	/**
	 * 
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
	 * 
	 */
	@Override
	public List<Pokemon> getPokemons() {
		
		if (this.listPokemon == null) {
			
			this.listPokemon = new ArrayList<Pokemon>();
			
		}
		
		return this.listPokemon;
		
	}

	/**
	 * 
	 */
	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		
		List<Pokemon> pokemons = this.getPokemons();
		
		pokemons.sort(order);
		
		return pokemons;
		
	}

}
