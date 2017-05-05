package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Class to test IPokemonMetadata.
 * 
 * @author Baptiste
 *
 */
public class IPokemonMetadataProviderTest {
	
	/**
	 * Static value representing a Pokemon.
	 */
	private final PokemonMetadata bulbizarreMetadata
		= new PokemonMetadata(1, "Bulbasaur", 126, 126, 90);
	
	/**
	 * Static value representing a Pokemon.
	 */
	private final PokemonMetadata aqualiMetadata
		= new PokemonMetadata(134, "Vaporeon", 186, 168, 260);
	
	/**
	 * Represents IPokemonMetadataProvider's Mock.
	 */
	@Mock private IPokemonMetadataProvider pokemonMetadataProviderMock;
	
	/**
	 * Define Mockito rule.
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * Getter of IPokemonMetadataProvider.
	 * 
	 * @throws PokedexException Throws to manage index problem.
	 * @return Mock of IPokemonMetadataProvider.
	 */
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() throws PokedexException {
		
		Mockito.when(pokemonMetadataProviderMock.getPokemonMetadata(1)).thenReturn(bulbizarreMetadata);
		
		Mockito.when(pokemonMetadataProviderMock.getPokemonMetadata(134)).thenReturn(aqualiMetadata);
		
		return pokemonMetadataProviderMock;
		
	}
	
	/**
	 * Test of getPokemonMetadata method.
	 */
	@Test
	public void testGetPokemonMetadata() {
		
		try {
			
			assertEquals(bulbizarreMetadata, getIPokemonMetadataProvider().getPokemonMetadata(1));
			
			assertEquals(aqualiMetadata, getIPokemonMetadataProvider().getPokemonMetadata(134));
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
