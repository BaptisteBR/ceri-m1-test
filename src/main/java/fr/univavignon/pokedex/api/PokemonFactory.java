package fr.univavignon.pokedex.api;

/**
 * 
 * @author Baptiste
 *
 */
public class PokemonFactory implements IPokemonFactory{

	/**
	 * 
	 * @param index
	 * @param cp
	 * @param hp
	 * @param dust
	 * @param candy
	 * @return
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		
		Pokemon pokemon = null;
		
		PokemonMetadataProvider provider = new PokemonMetadataProvider();
		
		PokemonMetadata data;
		
		try {
			
			data = provider.getPokemonMetadata(index);
			
			pokemon = new Pokemon(data.getIndex(), data.getName(), data.getAttack(), data.getDefense(), data.getStamina(), cp, hp, dust, candy, 0);
			
		}
		catch (PokedexException e) {
			
			e.printStackTrace();
			
		}
		
		return pokemon;
		
	}
	
}
