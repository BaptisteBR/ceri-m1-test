package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class IPokemonTrainerFactoryTest {
	
	private static final String mysticName = "mystic";
	
	private static final String instinctName = "instinct";
	
	private static final String valorName = "valor";
	
	private PokemonTrainer mysticTrainer;
	
	private PokemonTrainer instinctTrainer;
	
	private PokemonTrainer valorTrainer;
	
	@Mock private IPokemonTrainerFactory pokemonTrainerFactoryMock;
	
	@Mock private IPokedexFactory pokedexFactoryMock;
	
	@Mock private IPokedex pokedexMock;
	
	@Mock private IPokemonMetadataProvider pokemonMetadataProviderMock;
	
	@Mock private IPokemonFactory pokemonFactoryMock;
	
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Before
	public void setUp() {
		
		mysticTrainer = new PokemonTrainer(mysticName, Team.MYSTIC, pokedexMock);
		
		instinctTrainer = new PokemonTrainer(instinctName, Team.INSTINCT, pokedexMock);
		
		valorTrainer = new PokemonTrainer(valorName, Team.VALOR, pokedexMock);
		
	}
	
	protected IPokedexFactory getIPokedexFactory() {
		
		Mockito.when(pokedexFactoryMock.createPokedex(pokemonMetadataProviderMock,
				pokemonFactoryMock)).thenReturn(pokedexMock);
		
		return pokedexFactoryMock;
		
	}
	
	protected IPokemonTrainerFactory getIPokemonTrainerFactory() {
		
		Mockito.when(pokemonTrainerFactoryMock.createTrainer(mysticName,
				Team.MYSTIC, getIPokedexFactory())).thenReturn(mysticTrainer);
		
		Mockito.when(pokemonTrainerFactoryMock.createTrainer(instinctName,
				Team.INSTINCT, getIPokedexFactory())).thenReturn(instinctTrainer);
		
		Mockito.when(pokemonTrainerFactoryMock.createTrainer(valorName,
				Team.VALOR, getIPokedexFactory())).thenReturn(valorTrainer);
		
		return pokemonTrainerFactoryMock;
		
	}
	
	@Test
	public void testCreateTrainer() {
		
		assertEquals(mysticTrainer, getIPokemonTrainerFactory().createTrainer(mysticName, Team.MYSTIC, getIPokedexFactory()));

		assertEquals(instinctTrainer, getIPokemonTrainerFactory().createTrainer(instinctName, Team.INSTINCT, getIPokedexFactory()));
		
		assertEquals(valorTrainer, getIPokemonTrainerFactory().createTrainer(valorName, Team.VALOR, getIPokedexFactory()));
		
	}
	
}
