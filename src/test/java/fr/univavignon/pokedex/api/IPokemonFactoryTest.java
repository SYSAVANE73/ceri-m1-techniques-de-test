package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {
	IPokemonFactory em;
	Pokemon pok, pok1;
	
	@Before
	public void init() {
		em = mock(IPokemonFactory.class);
		pok = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pok1 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }
	
	@Test
	public void createPokemon() {
		
		when(em.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pok);
		when(em.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(pok1);
		
		assertEquals(0, pok.getIndex());
		assertEquals("Aquali", pok1.getName());		
		assertEquals(133, pok1.getIndex());	
		assertEquals(4000, pok.getDust());	
		/*
		 * failure
		 */
		//assertEquals(30, pok1.getIndex());	
	}

}
