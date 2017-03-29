package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

public class IPokedexTest {
	
	private final Pokemon bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 0.56);
	
	private List<Pokemon> pokemons = new ArrayList<Pokemon>();
	
	@Mock private IPokedex pokedexMock;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	protected IPokedex getIPokedex() throws PokedexException {
		
		Mockito.when(pokedexMock.size()).thenReturn(pokemons.size());
		Mockito.when(pokedexMock.addPokemon(bulbizarre)).thenAnswer(new Answer<Integer>() {

			@Override
			public Integer answer(InvocationOnMock invocation) throws Throwable {
				
				pokemons.add(bulbizarre);
				
				return pokemons.indexOf(bulbizarre);
				
			}
			
		});
		Mockito.when(pokedexMock.getPokemon(0)).thenReturn(bulbizarre);
		Mockito.when(pokedexMock.getPokemons()).thenReturn(pokemons);
		
		return pokedexMock;
		
	}
	
	@Test
	public void testSize() {
		
		try {
			
			assertEquals(pokemons.size(), getIPokedex().size());
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@Test
	public void testAddPokemon() {
		
		try {
			
			assertEquals(pokemons.indexOf(bulbizarre), getIPokedex().addPokemon(bulbizarre));
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	@Test
	public void testGetPokemon() {
		
		try {
			
			assertEquals(bulbizarre, getIPokedex().getPokemon(0));
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	/*
	@Test
	public void testGetPokemons() {
		
		try {
			
			//assertEquals();
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
	}
	*/
}
