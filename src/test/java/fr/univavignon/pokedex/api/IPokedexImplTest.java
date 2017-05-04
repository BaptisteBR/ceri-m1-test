package fr.univavignon.pokedex.api;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * @author Baptiste
 *
 */
public class IPokedexImplTest extends IPokedexTest {
	
	/**
	 * 
	 */
	private static IPokedex pokedex;
	
	/**
	 * 
	 */
	@BeforeClass
	public static void init() {
		
		PokedexFactory factory = new PokedexFactory();
		
		pokedex = factory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
		
		pokemons = new ArrayList<Pokemon>();
		
	}

	/**
	 * 
	 */
	@Override
	protected IPokedex getIPokedex() throws PokedexException {
		
		return pokedex;
		
	}
	
	/**
	 * 
	 */
	@Test
	@Override
	public void testAddPokemon() {
		
		pokemons.add(bulbizarre);
		pokemons.add(aquali);
		
		super.testAddPokemon();
		
	}
}
