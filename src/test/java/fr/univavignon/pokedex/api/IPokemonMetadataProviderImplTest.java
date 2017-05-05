package fr.univavignon.pokedex.api;

/**
 * Class to test IPokemonMetadataProvider implementation.
 * 
 * @author Baptiste
 *
 */
public class IPokemonMetadataProviderImplTest extends IPokemonMetadataProviderTest {

	/**
	 * Getter of IpokemonMetadataProvider.
	 * 
	 * @return Implementation of IPokemonMetadataProvider.
	 */
	@Override
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() {
		
		return new PokemonMetadataProvider();
		
	}

}
