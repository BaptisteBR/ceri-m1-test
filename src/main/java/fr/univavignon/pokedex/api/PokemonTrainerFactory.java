package fr.univavignon.pokedex.api;

/**
 * 
 * @author Baptiste
 *
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

	/**
	 * 
	 */
	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		
		IPokemonMetadataProvider provider = new PokemonMetadataProvider();
		
		IPokemonFactory pokemonFactory = new PokemonFactory();
		
		return new PokemonTrainer(name, team, pokedexFactory.createPokedex(provider, pokemonFactory));
		
	}

}
