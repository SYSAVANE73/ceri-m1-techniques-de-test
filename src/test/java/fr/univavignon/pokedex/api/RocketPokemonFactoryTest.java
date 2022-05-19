package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class RocketPokemonFactoryTest {
	RocketPokemonFactory rock;
	Pokemon pok, pok1, pok2, pok3, pok4;
	
	
	@Before
	public void init() {
		rock = new RocketPokemonFactory();
		pok = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
		pok1 = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
		pok2 = rock.createPokemon(-1, 0, 0, 0, 0);
		pok3 = rock.createPokemon(1, 0, 0, 0, 0);
		pok4 = rock.createPokemon(10, 20, 30, 40, 50);
    }
	
	@Test
	public void createPokemon() {
					
		assertEquals(0, pok.getIndex());	
		assertEquals("Bulbizarre", pok.getName());	
		
		assertEquals(133, pok1.getIndex());	
		assertEquals("Aquali", pok1.getName());	
		
		assertEquals(1000, pok2.getAttack());
		assertEquals("Ash's Pikachu", pok2.getName());
		
		assertEquals(49, pok3.getAttack());
		assertEquals("Bulbasaur", pok3.getName());
		
		assertEquals(10, pok4.getIndex());
		assertEquals(20, pok4.getCp());
		
		/*
		 * failed
		 */
		//assertEquals(100, pok3.getAttack());
	}
	
	

}
