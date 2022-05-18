package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonMetadataProviderTest {
	IPokemonMetadataProvider em;
	PokemonMetadata pok, pok2;
	
	@Before
	public void init() {
		em = mock(IPokemonMetadataProvider.class);
		pok = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		pok2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }
	
	@Test
	public void getPokemonMetadata() throws PokedexException{
		
		
		
		when(em.getPokemonMetadata(Mockito.anyInt())).thenAnswer(
    			new Answer() {
    				@Override
    				public Object answer(InvocationOnMock invocation) throws PokedexException {
    					Object[] args = invocation.getArguments();
    					int index = (int) args[0];
    					if(index == 0) {
    						return new PokemonMetadata(0,"Bulbizarre",126,126,90);
    					}
    					else if(index == 133) {
    						return new PokemonMetadata(133, "Aquali", 186, 168, 260);
    					}
    					else if(index<0 || index >150) {
    						throw new PokedexException("Index doit etre entre 0 et 150");
    					}
    					else {
    						return new PokemonMetadata(index, null,0,0,0);
    					}
    				}
    			}
    			);
		
		assertEquals("Bulbizarre", pok.getName());
		assertEquals(126, pok.getAttack());
		assertEquals(90, pok.getStamina());
		assertEquals("Aquali", pok2.getName());
		assertEquals(168, pok2.getDefense());
		
		//assertEquals(em.getPokemonMetadata(28).getIndex(), 28);
		
		/*
		 * failures
		 */
		//assertEquals(em.getPokemonMetadata(166).getName(), "Aquali");
		
	}
}
