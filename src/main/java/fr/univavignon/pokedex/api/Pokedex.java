package fr.univavignon.pokedex.api;

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
	private IPokemonMetadataProvider pokemonMetadataProvider;

	/**
	 * 
	 */
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		
		return pokemonMetadataProvider.getPokemonMetadata(index);
		
	}

	/**
	 * 
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		// TODO Auto-generated method stub
		return null;
	}

}
