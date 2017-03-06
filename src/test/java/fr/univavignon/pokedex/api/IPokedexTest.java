package fr.univavignon.pokedex.api;

import org.junit.Rule;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokedexTest {
	
	@Mock private IPokedex pokedexMock;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	protected IPokedex getIPokedex() {
		
		Mockito.when(pokedexMock.size()).thenReturn(151);
		
		return null;
	}
}
