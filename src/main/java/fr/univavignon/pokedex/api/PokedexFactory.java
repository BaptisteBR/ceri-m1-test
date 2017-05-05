package fr.univavignon.pokedex.api;

/**
 * PokedexFactory class. Implements IPokedexFactory interface.
 * 
 * @author Baptiste
 *
 */
public class PokedexFactory implements IPokedexFactory {

	/**
	 * Create a Pokedex from a metadata provider and a Pokemon factory.
	 * 
	 * @param metadataProvider Provider of metadata.
	 * @param pokemonFactory Factory to create Pokemons.
	 * @return New instance of Pokedex.
	 */
	@Override
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		
		return new Pokedex(metadataProvider, pokemonFactory);
		
	}

}
