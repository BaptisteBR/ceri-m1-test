package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Class to test IPokemonFactory.
 * 
 * @author Baptiste
 *
 */
public class IPokemonFactoryTest {
	
	/**
	 * Static value representing a Pokemon.
	 */
	private static final Pokemon bulbizarre
		= new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0);
	
	/**
	 * Static value representing a Pokemon.
	 */
	private static final Pokemon aquali
		= new Pokemon(134, "Vaporeon", 186, 168, 260, 2729, 202, 5000, 4, 0);
	
	/**
	 * Represents IPokemonFactory's Mock.
	 */
	@Mock private IPokemonFactory pokemonFactoryMock;
	
	/**
	 * Define Mockito rule.
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * Getter of IPokemonFactory.
	 * 
	 * @return Mock of IPokemonFActory.
	 */
	protected IPokemonFactory getIPokemonFactory() {
		
		Mockito.when(pokemonFactoryMock.createPokemon(1, 613, 64, 4000, 4)).thenReturn(bulbizarre);
		
		Mockito.when(pokemonFactoryMock.createPokemon(134, 2729, 202, 5000, 4)).thenReturn(aquali);
		
		return pokemonFactoryMock;
		
	}
	
	/**
	 * Test of createPokemon method.
	 */
	@Test
	public void testCreatePokemon() {
		
		assertEquals(bulbizarre, getIPokemonFactory().createPokemon(1, 613, 64, 4000, 4));
		
		assertEquals(aquali, getIPokemonFactory().createPokemon(134, 2729, 202, 5000, 4));
		
	}
	
}
