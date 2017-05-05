package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Class to test IPokemonTrainerFactory.
 * 
 * @author Baptiste
 *
 */
public class IPokemonTrainerFactoryTest {
	
	/**
	 * Static value of team name.
	 */
	protected static final String mysticName = "mystic";
	
	/**
	 * Static value of team name.
	 */
	protected static final String instinctName = "instinct";
	
	/**
	 * Static value of team name.
	 */
	protected static final String valorName = "valor";
	
	/**
	 * Represents a trainer.
	 */
	protected static PokemonTrainer mysticTrainer;
	
	/**
	 * Represents a trainer.
	 */
	protected static PokemonTrainer instinctTrainer;
	
	/**
	 * Represents a trainer.
	 */
	protected static PokemonTrainer valorTrainer;
	
	/**
	 * Represents IPokemonTrainerFactory's Mock.
	 */
	@Mock private static IPokemonTrainerFactory pokemonTrainerFactoryMock;
	
	/**
	 * Represents IPokedexFactory"s Mock.
	 */
	@Mock private static IPokedexFactory pokedexFactoryMock;
	
	/**
	 * Represents IPokedex's Mock.
	 */
	@Mock private static IPokedex pokedexMock;
	
	/**
	 * Represents IPokemonMetadataProvider's Mock.
	 */
	@Mock private static IPokemonMetadataProvider pokemonMetadataProviderMock;
	
	/**
	 * Represents IPokemonFactory's Mock.
	 */
	@Mock private static IPokemonFactory pokemonFactoryMock;
	
	/**
	 * Define Mockito rule.
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * Initialization method.
	 */
	@BeforeClass
	public static void init() {
		
		mysticTrainer = new PokemonTrainer(mysticName, Team.MYSTIC, pokedexMock);
		
		instinctTrainer = new PokemonTrainer(instinctName, Team.INSTINCT, pokedexMock);
		
		valorTrainer = new PokemonTrainer(valorName, Team.VALOR, pokedexMock);
		
	}
	
	/**
	 * Getter of IPokemonFactory.
	 * 
	 * @return Mock of IPokemonFactory.
	 */
	protected IPokemonFactory getIPokemonFactory() {
		
		return pokemonFactoryMock;
		
	}
	
	/**
	 * Getter of IPokemonMetadataProvider.
	 * 
	 * @return Mock of IPokemonMetadataProvider.
	 */
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() {
		
		return pokemonMetadataProviderMock;
		
	}
	
	/**
	 * Getter of IPokedex.
	 * 
	 * @return Mock of IPokedex.
	 */
	protected IPokedex getIPokedex() {
		
		return pokedexMock;
		
	}
	
	/**
	 * Getter of IPokedexFactory.
	 * 
	 * @return Mock of IPokedexFactory.
	 */
	protected IPokedexFactory getIPokedexFactory() {
		
		Mockito.when(pokedexFactoryMock.createPokedex(getIPokemonMetadataProvider(),
				getIPokemonFactory())).thenReturn(getIPokedex());
		
		return pokedexFactoryMock;
		
	}
	
	/**
	 * Getter of IPokemonTrainerFactory.
	 * 
	 * @return Mock of IPokemonTrainerFactory.
	 */
	protected IPokemonTrainerFactory getIPokemonTrainerFactory() {
		
		Mockito.when(pokemonTrainerFactoryMock.createTrainer(mysticName,
				Team.MYSTIC, getIPokedexFactory())).thenReturn(mysticTrainer);
		
		Mockito.when(pokemonTrainerFactoryMock.createTrainer(instinctName,
				Team.INSTINCT, getIPokedexFactory())).thenReturn(instinctTrainer);
		
		Mockito.when(pokemonTrainerFactoryMock.createTrainer(valorName,
				Team.VALOR, getIPokedexFactory())).thenReturn(valorTrainer);
		
		return pokemonTrainerFactoryMock;
		
	}
	
	/**
	 * Test of createTrainer method.
	 */
	@Test
	public void testCreateTrainer() {
		
		assertEquals(mysticTrainer, getIPokemonTrainerFactory().createTrainer(mysticName, Team.MYSTIC, getIPokedexFactory()));

		assertEquals(instinctTrainer, getIPokemonTrainerFactory().createTrainer(instinctName, Team.INSTINCT, getIPokedexFactory()));
		
		assertEquals(valorTrainer, getIPokemonTrainerFactory().createTrainer(valorName, Team.VALOR, getIPokedexFactory()));
		
	}
	
}
