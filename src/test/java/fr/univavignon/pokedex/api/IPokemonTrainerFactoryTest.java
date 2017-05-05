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
 * 
 * @author Baptiste
 *
 */
public class IPokemonTrainerFactoryTest {
	
	/**
	 * 
	 */
	protected static final String mysticName = "mystic";
	
	/**
	 * 
	 */
	protected static final String instinctName = "instinct";
	
	/**
	 * 
	 */
	protected static final String valorName = "valor";
	
	/**
	 * 
	 */
	protected static PokemonTrainer mysticTrainer;
	
	/**
	 * 
	 */
	protected static PokemonTrainer instinctTrainer;
	
	/**
	 * 
	 */
	protected static PokemonTrainer valorTrainer;
	
	/**
	 * 
	 */
	@Mock private static IPokemonTrainerFactory pokemonTrainerFactoryMock;
	
	/**
	 * 
	 */
	@Mock private static IPokedexFactory pokedexFactoryMock;
	
	/**
	 * 
	 */
	@Mock private static IPokedex pokedexMock;
	
	/**
	 * 
	 */
	@Mock private static IPokemonMetadataProvider pokemonMetadataProviderMock;
	
	/**
	 * 
	 */
	@Mock private static IPokemonFactory pokemonFactoryMock;
	
	/**
	 * 
	 */
	@Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	/**
	 * 
	 */
	@BeforeClass
	public static void init() {
		
		mysticTrainer = new PokemonTrainer(mysticName, Team.MYSTIC, pokedexMock);
		
		instinctTrainer = new PokemonTrainer(instinctName, Team.INSTINCT, pokedexMock);
		
		valorTrainer = new PokemonTrainer(valorName, Team.VALOR, pokedexMock);
		
	}
	
	/**
	 * 
	 * @return
	 */
	protected IPokemonFactory getIPokemonFactory() {
		
		return pokemonFactoryMock;
		
	}
	
	/**
	 * 
	 * @return
	 */
	protected IPokemonMetadataProvider getIPokemonMetadataProvider() {
		
		return pokemonMetadataProviderMock;
		
	}
	
	/**
	 * 
	 * @return
	 */
	protected IPokedex getIPokedex() {
		
		return pokedexMock;
		
	}
	
	/**
	 * 
	 * @return
	 */
	protected IPokedexFactory getIPokedexFactory() {
		
		Mockito.when(pokedexFactoryMock.createPokedex(getIPokemonMetadataProvider(),
				getIPokemonFactory())).thenReturn(getIPokedex());
		
		return pokedexFactoryMock;
		
	}
	
	/**
	 * 
	 * @return
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
	 * 
	 */
	@Test
	public void testCreateTrainer() {
		
		assertEquals(mysticTrainer, getIPokemonTrainerFactory().createTrainer(mysticName, Team.MYSTIC, getIPokedexFactory()));

		assertEquals(instinctTrainer, getIPokemonTrainerFactory().createTrainer(instinctName, Team.INSTINCT, getIPokedexFactory()));
		
		assertEquals(valorTrainer, getIPokemonTrainerFactory().createTrainer(valorName, Team.VALOR, getIPokedexFactory()));
		
	}
	
}
