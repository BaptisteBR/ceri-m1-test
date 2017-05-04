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
public class IPokedexFactoryTest {
	
	/**
	 * 
	 */
	@Mock private IPokedexFactory pokedexFactoryMock;
	
	/**
	 * 
	 */
	@Mock private IPokemonMetadataProvider pokemonMetadataProviderMock;
	
	/**
	 * 
	 */
	@Mock private IPokemonFactory pokemonFactoryMock;
	
	/**
	 * 
	 */
	@Mock private static IPokedex pokedexMock;
	
	/**
	 * 
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * 
	 * @return
	 */
	protected IPokedexFactory getIPokedexFactory() {
		
		Mockito.when(pokedexFactoryMock.createPokedex(getIPokemonMetadataProvider(),
				getIPokemonFactory())).thenReturn(getIPokedex());
		
		return pokedexFactoryMock;
		
	}
	
	/**
	 * 
	 * @return
	 */
	protected IPokedex getIPokedex() {
		
		return pokedexMock;
		
	}
	
	/**
	 * 
	 * @return
	 */
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() {
		
		return pokemonMetadataProviderMock;
		
	}
	
	protected IPokemonFactory getIPokemonFactory() {
		
		return pokemonFactoryMock;
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testCreatePokedex() {
		
		assertEquals(getIPokedex(),
				getIPokedexFactory().createPokedex(getIPokemonMetadataProvider(), getIPokemonFactory()));
		
	}
	
}
