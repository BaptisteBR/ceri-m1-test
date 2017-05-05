package fr.univavignon.pokedex.api;

/**
 * Class to test IPokemonFactory implementation.
 * 
 * @author Baptiste
 *
 */
public class IPokemonFactoryImplTest extends IPokemonFactoryTest {

	/**
	 * Getter of IPokemonFactory.
	 * 
	 * @return Implementation of IPokemonFactory.
	 */
	@Override
	protected IPokemonFactory getIPokemonFactory() {
		
		return new PokemonFactory();
		
	}

}
