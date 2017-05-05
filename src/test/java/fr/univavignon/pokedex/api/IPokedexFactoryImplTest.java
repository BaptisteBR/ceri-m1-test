package fr.univavignon.pokedex.api;

import org.junit.BeforeClass;

/**
 * 
 * @author Baptiste
 *
 */
public class IPokedexFactoryImplTest extends IPokedexFactoryTest {
	
	/**
	 * 
	 */
	private static IPokemonFactory pokemonFactory;
	
	/**
	 * 
	 */
	private static IPokemonMetadataProvider pokemonMetadataProvider;
	
	/**
	 * 
	 */
	private static IPokedex pokedex;
	
	/**
	 * 
	 */
	private static IPokedexFactory pokedexFactory;
	
	/**
	 * 
	 */
	@BeforeClass
	public static void init() {
		
		pokemonMetadataProvider = new PokemonMetadataProvider();
		
		pokemonFactory = new PokemonFactory();
		
		pokedexFactory = new PokedexFactory();
		
		pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
		
	}
	
	/**
	 * 
	 */
	@Override
	protected IPokedexFactory getIPokedexFactory() {
		
		return pokedexFactory;
		
	}
	
	/**
	 * 
	 */
	@Override
	protected IPokedex getIPokedex() {
		
		return pokedex;
		
	}
	
	/**
	 * 
	 */
	@Override
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() {
		
		return pokemonMetadataProvider;
		
	}
	
	/**
	 * 
	 */
	@Override
	protected IPokemonFactory getIPokemonFactory() {
		
		return pokemonFactory;
		
	}

}
