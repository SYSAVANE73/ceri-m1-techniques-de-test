package fr.univavignon.pokedex.api;

public class PokemonTrainerFactoryImplement implements IPokemonTrainerFactory{
	
	PokedexImplement pokedex;
	@Override
	public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
		// TODO Auto-generated method stub
		
		return new PokemonTrainer(name, team, pokedexFactory.createPokedex(pokedex, pokedex));
	}
}
