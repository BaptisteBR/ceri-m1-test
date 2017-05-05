package fr.univavignon.pokedex.api;

/**
 * PokemonTrainerFactory class. Implements IPokemonTrainerFactory interface.
 * 
 * @author Baptiste
 *
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

	/**
	 * Create a trainer with name, team, and specified Pokemons factory.
	 * 
	 * @param name Trainer's name.
	 * @param team Trainer's team.
	 * @param pokedexFactory Pokemons factory.
	 * @return New instance of PokemonTrainer.
	 */
	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		
		IPokemonMetadataProvider provider = new PokemonMetadataProvider();
		
		IPokemonFactory pokemonFactory = new PokemonFactory();
		
		return new PokemonTrainer(name, team, pokedexFactory.createPokedex(provider, pokemonFactory));
		
	}

}
