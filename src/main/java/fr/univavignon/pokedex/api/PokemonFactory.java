package fr.univavignon.pokedex.api;

/**
 * PokemonFactory class. Implements IPokemonFactory.
 * 
 * @author Baptiste
 *
 */
public class PokemonFactory implements IPokemonFactory{

	/**
	 * Create a Pokemon instance from properties.
	 * 
	 * @param index Numeric index.
	 * @param cp Fight level.
	 * @param hp Life points.
	 * @param dust Dust points.
	 * @param candy Candies number.
	 * @return New instance of Pokemon.
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
