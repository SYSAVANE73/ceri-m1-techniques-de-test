package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PokedexImplement implements IPokedex{
	
	public static List<Pokemon> pokedex;
	
	Pokemon pok1, pok2;
	
	public PokedexImplement() {
		pokedex = new ArrayList<Pokemon>();
		pok1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pok2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		pokedex.add(pok1);
		pokedex.add(pok2);
	}

	@Override
	public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
		// TODO Auto-generated method stub
		for(int i=0;i<pokedex.size();i++) {
			if(pokedex.get(i).getIndex() == index) {
				return pokedex.get(i);
			}
		}
		throw new PokedexException("Le PokemonMetadata n'existe pas");
	}

	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// TODO Auto-generated method stub
		return new Pokemon(index, null, candy, candy, index, cp, hp, dust, candy, candy);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return pokedex.size();
	}

	@Override
	public int addPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		pokedex.add(pokemon);
		return pokemon.getIndex();
	}

	@Override
	public Pokemon getPokemon(int id) throws PokedexException {
		// TODO Auto-generated method stub
		for(int i=0;i<pokedex.size();i++) {
			if(pokedex.get(i).getIndex() == id) {
				return pokedex.get(i);
			}
		}
		throw new PokedexException("Le Pokemon n'existe pas");
	}

	@Override
	public List<Pokemon> getPokemons() {
		// TODO Auto-generated method stub
		return pokedex;
	}

	@Override
	public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
		// TODO Auto-generated method stub
		return null;
	}

}
