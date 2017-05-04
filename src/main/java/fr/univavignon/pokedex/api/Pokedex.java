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
	private static List<Pokemon> listPokemon = null;
	
	/**
	 * 
	 */
	private IPokemonMetadataProvider provider;
	
	/**
	 * 
	 */
	private IPokemonFactory factory;
	
	/**
	 * 
	 * @param provider
	 * @param factory
	 */
	public Pokedex(IPokemonMetadataProvider provider, IPokemonFactory factory) {
		
		this.provider = provider;
		this.factory = factory;
		
	}

	/**
	 * 
	 */
	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		
		return provider.getPokemonMetadata(index);
		
	}

	/**
	 * 
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		
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
		
		//System.out.println("this.getPokemons().indexOf(pokemon): " + this.getPokemons().indexOf(pokemon));
		
		return this.getPokemons().indexOf(pokemon);
		
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
		
		if (listPokemon == null) {
			
			listPokemon = new ArrayList<Pokemon>();
			
		}
		
		return listPokemon;
		
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
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		
		Pokedex pokedex = (Pokedex) obj;
		
		
		
		return true;
		
	}

}
