package fr.univavignon.pokedex.api;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Class to test implementation of IPokedex.
 * 
 * @author Baptiste
 *
 */
public class IPokedexImplTest extends IPokedexTest {
	
	/**
	 * Represents IPokedex's implementation.
	 */
	private static IPokedex pokedex;
	
	/**
	 * Intialization method.
	 */
	@BeforeClass
	public static void init() {
		
		PokedexFactory factory = new PokedexFactory();
		
		pokedex = factory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
		
		pokemons = new ArrayList<Pokemon>();
		
	}

	/**
	 * Getter of IPokedex.
	 * 
	 * @return Implementation of IPokedex.
	 */
	@Override
	protected IPokedex getIPokedex() throws PokedexException {
		
		return pokedex;
		
	}
	
	/**
	 * Test of addPokemon method.
	 */
	@Test
	@Override
	public void testAddPokemon() {
		
		pokemons.add(bulbizarre);
		pokemons.add(aquali);
		
		super.testAddPokemon();
		
	}
}
