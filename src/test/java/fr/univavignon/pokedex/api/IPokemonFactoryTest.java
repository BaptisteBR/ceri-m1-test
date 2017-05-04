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
public class IPokemonFactoryTest {
	
	/**
	 * 
	 */
	private final Pokemon bulbizarre
		= new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0);
	
	/**
	 * 
	 */
	private final Pokemon aquali
		= new Pokemon(134, "Vaporeon", 186, 168, 260, 2729, 202, 5000, 4, 0);
	
	/**
	 * 
	 */
	@Mock private IPokemonFactory pokemonFactoryMock;
	
	/**
	 * 
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * 
	 * @return
	 */
	protected IPokemonFactory getIPokemonFactory() {
		
		Mockito.when(pokemonFactoryMock.createPokemon(1, 613, 64, 4000, 4)).thenReturn(bulbizarre);
		
		Mockito.when(pokemonFactoryMock.createPokemon(134, 2729, 202, 5000, 4)).thenReturn(aquali);
		
		return pokemonFactoryMock;
		
	}
	
	/**
	 * 
	 */
	@Test
	public void testCreatePokemon() {
		
		assertEquals(bulbizarre, getIPokemonFactory().createPokemon(1, 613, 64, 4000, 4));
		
		assertEquals(aquali, getIPokemonFactory().createPokemon(134, 2729, 202, 5000, 4));
		
	}
	
}
