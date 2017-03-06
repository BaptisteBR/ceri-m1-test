package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Test;

public class PokedexTest extends IPokedexTest {

	@Test
	public void testSize() {
		
		assertEquals(super.getIPokedex().size(), 151);
		
	}
}
