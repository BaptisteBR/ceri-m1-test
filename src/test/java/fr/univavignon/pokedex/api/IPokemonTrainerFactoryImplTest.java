package fr.univavignon.pokedex.api;

import org.junit.BeforeClass;

/**
 * Class to test IPokemonTrainerFactory implementation.
 * 
 * @author Baptiste
 *
 */
public class IPokemonTrainerFactoryImplTest extends IPokemonTrainerFactoryTest {

	/**
	 * Represents IPokemonMetadataProvider implementation.
	 */
	private static IPokemonMetadataProvider pokemonMetadataProvider;
	
	/**
	 * Represents IPokemonFactory implementation.
	 */
	private static IPokemonFactory pokemonFactory;
	
	/**
	 * Represents IPokedex implementation.
	 */
	private static IPokedex pokedex;
	
	/**
	 * Represents IPokedexFactory implementation.
	 */
	private static IPokedexFactory pokedexFactory;
	
	/**
	 * Represents IPokemonTrainerFactory implementation.
	 */
	private static IPokemonTrainerFactory pokemonTrainerFactory;
	
	/**
	 * Initialization method.
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
	 * Getter of IPokedexFactory.
	 * 
	 * @return Implementation of IPokedexFactory.
	 */
	@Override
	protected IPokedexFactory getIPokedexFactory() {
		
		return pokedexFactory;
		
	}
	
	/**
	 * Getter of IPokemonTrainerFactory.
	 * 
	 * @return Implementation of IPokemonTrainerfactory.
	 */
	@Override
	protected IPokemonTrainerFactory getIPokemonTrainerFactory() {
		
		return pokemonTrainerFactory;
		
	}

}
