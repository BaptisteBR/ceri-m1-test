package fr.univavignon.pokedex.api;

import org.junit.BeforeClass;

/**
 * Class to test IPokedexFactory Implementation. Extends IPokedexFactoryTest.
 * 
 * @author Baptiste
 *
 */
public class IPokedexFactoryImplTest extends IPokedexFactoryTest {
	
	/**
	 * Represents PokemonFactory implementation.
	 */
	private static IPokemonFactory pokemonFactory;
	
	/**
	 * Represents PokemonMetadataProvider implementation.
	 */
	private static IPokemonMetadataProvider pokemonMetadataProvider;
	
	/**
	 * Represents IPokedex implementation.
	 */
	private static IPokedex pokedex;
	
	/**
	 * Represents IPokedexFactory implementation.
	 */
	private static IPokedexFactory pokedexFactory;
	
	/**
	 * Initialization method.
	 */
	@BeforeClass
	public static void init() {
		
		pokemonMetadataProvider = new PokemonMetadataProvider();
		
		pokemonFactory = new PokemonFactory();
		
		pokedexFactory = new PokedexFactory();
		
		pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
		
	}
	
	/**
	 * Getter of IPokedexFactory.
	 * 
	 * @return Implementation of IPokedexFactory.
	 */
	@Override
	protected IPokedexFactory getIPokedexFactory() {
		
		return pokedexFactory;
		
	}
	
	/**
	 * Getter of IPokedex.
	 * 
	 * @return Implementation of IPokedex.
	 */
	@Override
	protected IPokedex getIPokedex() {
		
		return pokedex;
		
	}
	
	/**
	 * Getter of IPokemonMetadataProvider.
	 * 
	 * @return Implementation of IPokemonMetadataProvider.
	 */
	@Override
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() {
		
		return pokemonMetadataProvider;
		
	}
	
	/**
	 * Getter of IPokemonFactory.
	 * 
	 * @return Implementation of IPokemonFactory.
	 */
	@Override
	protected IPokemonFactory getIPokemonFactory() {
		
		return pokemonFactory;
		
	}

}
