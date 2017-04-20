package fr.univavignon.pokedex.api;

public class IPokemonMetadataProviderImplTest extends IPokemonMetadataProviderTest {

	@Override
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() {
		
		return new PokemonMetadataProvider();
		
	}

}
