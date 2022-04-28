package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class IPokemonFactoryTest {
	
	@Test
	public void createPokemon() {
		
		IPokemonFactory em = mock(IPokemonFactory.class);
		
		Pokemon pok = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		Pokemon pok1 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		when(em.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pok);
		when(em.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pok1);
		
		
		//assertEquals(em.createPokemon(0, 613, 64, 4000, 4), pok);
		//assertEquals(em.createPokemon(133, 2729, 202, 5000, 4), pok1);
		
		//failures
		assertEquals(em.createPokemon(10, 613, 64, 4000, 4), pok);
	}

}
