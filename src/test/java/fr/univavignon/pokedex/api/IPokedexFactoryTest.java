package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Class to test IPokedexFactory.
 * 
 * @author Baptiste
 *
 */
public class IPokedexFactoryTest {
	
	/**
	 * Represents IPokedexFactory's Mock.
	 */
	@Mock private IPokedexFactory pokedexFactoryMock;
	
	/**
	 * Represents IPokemonMetadatProvider's Mock.
	 */
	@Mock private IPokemonMetadataProvider pokemonMetadataProviderMock;
	
	/**
	 * Represents IPokemonFactory's Mock.
	 */
	@Mock private IPokemonFactory pokemonFactoryMock;
	
	/**
	 * Represents IPokedex's Mock.
	 */
	@Mock private static IPokedex pokedexMock;
	
	/**
	 * Define Mockito rule.
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * Getter of IPokedexFactory.
	 * 
	 * @return Mock of IPokedexFactory.
	 */
	protected IPokedexFactory getIPokedexFactory() {
		
		Mockito.when(pokedexFactoryMock.createPokedex(getIPokemonMetadataProvider(),
				getIPokemonFactory())).thenReturn(getIPokedex());
		
		return pokedexFactoryMock;
		
	}
	
	/**
	 * Getter of IPokedex.
	 * 
	 * @return Mock of IPokedex.
	 */
	protected IPokedex getIPokedex() {
		
		return pokedexMock;
		
	}
	
	/**
	 * Getter of IPokemonMetadataProvider.
	 * 
	 * @return Mock of IPokemonMetadataProvider.
	 */
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() {
		
		return pokemonMetadataProviderMock;
		
	}
	
	/**
	 * Getter of IPokemonFactory.
	 * 
	 * @return Mock of IPokemonFactory.
	 */
	protected IPokemonFactory getIPokemonFactory() {
		
		return pokemonFactoryMock;
		
	}
	
	/**
	 * Test of createPokedex method.
	 */
	@Test
	public void testCreatePokedex() {
		
		assertEquals(getIPokedex(),
				getIPokedexFactory().createPokedex(getIPokemonMetadataProvider(), getIPokemonFactory()));
		
	}
	
}
