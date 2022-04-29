package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;


public class IPokedexFactoryTest {
	IPokedexFactory em;
	IPokemonMetadataProvider pokMetadataProvider;
	IPokemonFactory pokemonFactory;
	IPokedex pokedex;
	
	@Before
	public void init() {
		em = mock(IPokedexFactory.class);
		pokMetadataProvider = mock(IPokemonMetadataProvider.class);
		pokemonFactory = mock(IPokemonFactory.class);
		pokedex = mock(IPokedex.class);
    }
	
	@Test
	public void createPokedex() {
		
		when(em.createPokedex(pokMetadataProvider, pokemonFactory)).thenReturn(pokedex);
		assertEquals(em.createPokedex(pokMetadataProvider, pokemonFactory), pokedex);
	}

}
