package fr.univavignon.pokedex.api;

import org.junit.BeforeClass;

/**
 * 
 * @author Baptiste
 *
 */
public class IPokemonTrainerFactoryImplTest extends IPokemonTrainerFactoryTest {

	/**
	 * 
	 */
	private static IPokemonMetadataProvider pokemonMetadataProvider;
	
	/**
	 * 
	 */
	private static IPokemonFactory pokemonFactory;
	
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
	private static IPokemonTrainerFactory pokemonTrainerFactory;
	
	/**
	 * 
	 */
	@BeforeClass
	public static void init() {
		
		pokemonMetadataProvider = new PokemonMetadataProvider();
		
		pokemonFactory = new PokemonFactory();
		
		pokedexFactory = new PokedexFactory();
		
		pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);
		
		pokemonTrainerFactory = new PokemonTrainerFactory();
		
		mysticTrainer = new PokemonTrainer(mysticName, Team.MYSTIC, pokedex);
		
		instinctTrainer = new PokemonTrainer(instinctName, Team.INSTINCT, pokedex);
		
		valorTrainer = new PokemonTrainer(valorName, Team.VALOR, pokedex);
		
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
	protected IPokedexFactory getIPokedexFactory() {
		
		return pokedexFactory;
		
	}
	
	/**
	 * 
	 */
	@Override
	protected IPokemonTrainerFactory getIPokemonTrainerFactory() {
		
		return pokemonTrainerFactory;
		
	}

}
