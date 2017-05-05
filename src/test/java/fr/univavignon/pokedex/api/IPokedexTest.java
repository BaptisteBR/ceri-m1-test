package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

/**
 * Class to test IPokedex.
 * 
 * @author Baptiste
 *
 */
public class IPokedexTest {
	
	/**
	 * Static value representing a Pokemon.
	 */
	protected final static Pokemon bulbizarre
		= new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 0);
	
	/**
	 * Static value representing a Pokemon.
	 */
	protected final static Pokemon aquali
		= new Pokemon(134, "Vaporeon", 186, 168, 260, 2729, 202, 5000, 4, 0);
	
	/**
	 * List of Pokemon.
	 */
	protected static List<Pokemon> pokemons;
	
	/**
	 * Represents IPokedex's Mock.
	 */
	@Mock private IPokedex pokedexMock;
	
	/**
	 * Define Mockito rule.
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * Initialization method.
	 */
	@BeforeClass
	public static void init() {
		
		pokemons = new ArrayList<Pokemon>();
		
	}
	
	/**
	 * Getter of IPokedex.
	 * 
	 * @throws PokedexException Throws to manage index error in getPokemon method.
	 * @return Mock of IPokedex.
	 */
	protected IPokedex getIPokedex() throws PokedexException {
		
		Mockito.when(pokedexMock.size()).thenReturn(pokemons.size());
		
		Mockito.when(pokedexMock.addPokemon(bulbizarre)).thenAnswer(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				
				pokemons.add(bulbizarre);
				
				return pokemons.indexOf(bulbizarre);
				
			}
			
		});
		
		Mockito.when(pokedexMock.addPokemon(aquali)).thenAnswer(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				
				pokemons.add(aquali);
				
				return pokemons.indexOf(aquali);
				
			}
			
		});
		
		Mockito.when(pokedexMock.getPokemon(0)).thenReturn(bulbizarre);
		
		Mockito.when(pokedexMock.getPokemon(1)).thenReturn(aquali);
		
		Mockito.when(pokedexMock.getPokemons()).thenReturn(pokemons);
		
		return pokedexMock;
		
	}
	
	/**
	 * Test of addPokemon method.
	 */
	@Test
	public void testAddPokemon() {
		
		try {
			
			int indexB = getIPokedex().addPokemon(bulbizarre);
			int indexA = getIPokedex().addPokemon(aquali);
			
			assertEquals(pokemons.indexOf(bulbizarre), indexB);
			
			assertEquals(pokemons.indexOf(aquali), indexA);
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * Test of size method.
	 */
	@Test
	public void testSize() {
		
		try {
			
			assertEquals(pokemons.size(), getIPokedex().size());
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * Test of getPokemon method.
	 */
	@Test
	public void testGetPokemon() {
		
		try {
			
			assertEquals(bulbizarre, getIPokedex().getPokemon(0));
			
			assertEquals(aquali, getIPokedex().getPokemon(1));
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * Test of getPokemons method.
	 */
	@Test
	public void testGetPokemons() {
		
		try {
			
			assertEquals(pokemons.size(), getIPokedex().getPokemons().size());
						
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
}
