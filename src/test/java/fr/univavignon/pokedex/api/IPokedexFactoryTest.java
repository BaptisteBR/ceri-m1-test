package fr.univavignon.pokedex.api;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokedexFactoryTest {
	
	@Mock private IPokedexFactory pokedexFactoryMock;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	protected IPokedexFactory getIPokedexFactory() {
		
		
		
		return pokedexFactoryMock;
		
	}
	
}
