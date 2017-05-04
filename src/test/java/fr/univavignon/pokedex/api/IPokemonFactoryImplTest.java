package fr.univavignon.pokedex.api;

/**
 * 
 * @author Baptiste
 *
 */
public class IPokemonFactoryImplTest extends IPokemonFactoryTest {

	/**
	 * 
	 */
	@Override
	protected IPokemonFactory getIPokemonFactory() {
		
		return new PokemonFactory();
		
	}

}
