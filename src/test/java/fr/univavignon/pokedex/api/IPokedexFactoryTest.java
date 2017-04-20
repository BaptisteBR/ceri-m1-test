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
	@Mock private IPokedex pokedexMock;
	
	/**
	 * 
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * 
	 * @return
	 */
	protected IPokedexFactory getIPokedexFactory() {
		
		Mockito.when(pokedexFactoryMock.createPokedex(pokemonMetadataProviderMock,
				pokemonFactoryMock)).thenReturn(pokedexMock);
		
		return pokedexFactoryMock;
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testCreatePokedex() {
		
		assertEquals(pokedexMock,
				getIPokedexFactory().createPokedex(pokemonMetadataProviderMock, pokemonFactoryMock));
		
	}
	
}
