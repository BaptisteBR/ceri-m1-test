package fr.univavignon.pokedex.api;

/**
 * 
 * @author Baptiste
 *
 */
public class IPokedexImplTest extends IPokedexTest {

	/**
	 * 
	 */
	@Override
	protected IPokedex getIPokedex() throws PokedexException {
		
		return new Pokedex();
		
	}

}
