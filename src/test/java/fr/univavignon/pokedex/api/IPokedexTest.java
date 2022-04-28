package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.mockito.*;

public class IPokedexTest {
	
	public static List<Pokemon> pokedex = new ArrayList<Pokemon>();
	IPokedex em = mock(IPokedex.class);
	IPokemonMetadataProvider pokMeta = mock(IPokemonMetadataProvider.class);
	IPokemonFactory pokfac = mock(IPokemonFactory.class);
	IPokemonMetadataProvider meta = mock(IPokemonMetadataProvider.class);
	
	@Test
	public void size() {
		addPokemon();
		when(em.size()).thenReturn(pokedex.size());
		
		assertEquals(em.size(), 4);
	}
	
	@Test
	public void addPokemon() {
		Pokemon pok1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pok2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		
		pokedex.add(pok1);
		pokedex.add(pok2);
		
		when(em.addPokemon(pok1)).thenReturn(pok1.getIndex());
		when(em.addPokemon(pok2)).thenReturn(pok2.getIndex());
		
		assertEquals(em.addPokemon(pok1), 0);
		assertEquals(em.addPokemon(pok2), 133);
		//assertEquals(em.addPokemon(pok2), 150);
	}
	
	@Test
	public void getPokemon() throws PokedexException {
		addPokemon();
		Pokemon pok3 = pokfac.createPokemon(0, 613, 64, 4000, 4);
		
		when(pokedex.get(0)).thenReturn(getPokemonIndex(0));
		assertEquals(pokedex.get(0), pokfac.createPokemon(0, 613, 64, 4000, 4));
		//assertEquals(pokedex.get(0), pokfac.createPokemon(133, 2729, 202, 5000, 4));
	}
	
	public Pokemon getPokemonIndex(int index) throws PokedexException {
		for(int i=0;i<pokedex.size();i++) {
			if(pokedex.get(i).getIndex() == index) {
				//System.out.println(pokedex.get(i).getIndex());
				return pokedex.get(i);
			}
		}
		//throw new PokedexException("n'existe pas");
		return null;
	}
	
	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * 
	 * @return Unmodifiable list of all pokemons.
	 */
	@Test
	public void getPokemons()  {
		addPokemon();
		List<Pokemon> listPokemon = new ArrayList<Pokemon>();
		
		 for(Pokemon p: pokedex) {
			 listPokemon.add(p);
		 }
		 
		Pokemon pok2 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		listPokemon.add(pok2);
		System.out.println(listPokemon.size());
		when(pokedex.get(0).getIndex()).thenReturn(listPokemon.get(0).getIndex());
		assertEquals(pokedex.get(1).getIndex(), 133);
	}
	//List<Pokemon> getPokemons();

	/**
	 * Returns an unmodifiable list of all pokemons this pokedex contains.
	 * The list view will be sorted using the given <tt>order</tt>.
	 * 
	 * @param order Comparator instance used for sorting the created view.
	 * @return Sorted unmodifiable list of all pokemons.
	 */
	//List<Pokemon> getPokemons(Comparator<Pokemon> order);

}
