package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;


public class IPokedexFactoryTest {
	
	@Test
	public void createPokedex() {
		
		
		IPokedexFactory em = mock(IPokedexFactory.class);
		IPokemonMetadataProvider pokMetadataProvider = mock(IPokemonMetadataProvider.class);
		IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
		IPokedex pokedex = mock(IPokedex.class);
		
		
		when(em.createPokedex(pokMetadataProvider, pokemonFactory)).thenReturn(pokedex);
		
		assertEquals(em.createPokedex(pokMetadataProvider, pokemonFactory), pokedex);
	}

}
