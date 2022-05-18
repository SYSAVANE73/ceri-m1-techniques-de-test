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
		assertEquals(126, pok.getAttack());	
		assertEquals(90, pok.getStamina());
		assertEquals(613, pok.getCp());
		assertEquals(4, pok.getCandy());
		assertEquals(56,00, pok.getIv());	
		
		assertEquals("Aquali", pok1.getName());		
		assertEquals(133, pok1.getIndex());	
		assertEquals(5000, pok1.getDust());	
		assertEquals(168, pok1.getDefense());
		assertEquals(202, pok1.getHp());	
		
		/*
		 * failure
		 */
		//assertEquals(30, pok1.getIndex());	
	}

}
