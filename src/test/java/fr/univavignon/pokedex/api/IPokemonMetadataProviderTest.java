package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * 
 * @author Baptiste
 *
 */
public class IPokemonMetadataProviderTest {
	
	/**
	 * 
	 */
	private final PokemonMetadata bulbizarreMetadata
		= new PokemonMetadata(0, "bulbizarre", 126, 126, 90);
	
	/**
	 * 
	 */
	private final PokemonMetadata aqualiMetadata
		= new PokemonMetadata(133, "aquali", 186, 168, 260);
	
	/**
	 * 
	 */
	@Mock private IPokemonMetadataProvider pokemonMetadataProviderMock;
	
	/**
	 * 
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * 
	 * @return
	 * @throws PokedexException
	 */
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() throws PokedexException {
		
		Mockito.when(pokemonMetadataProviderMock.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
		
		Mockito.when(pokemonMetadataProviderMock.getPokemonMetadata(133)).thenReturn(aqualiMetadata);
		
		return pokemonMetadataProviderMock;
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testGetPokemonMetadata() {
		
		try {
			
			assertEquals(bulbizarreMetadata, getIPokemonMetadataProvider().getPokemonMetadata(0));
			
			assertEquals(aqualiMetadata, getIPokemonMetadataProvider().getPokemonMetadata(133));
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
