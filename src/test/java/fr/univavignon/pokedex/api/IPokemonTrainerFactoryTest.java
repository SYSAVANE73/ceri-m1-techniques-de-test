package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class IPokemonTrainerFactoryTest {
	IPokemonTrainerFactory em;
	Team team;
	IPokedex pokedex;
	PokemonTrainer poktraine1, poktraine2;
	
	@Before
	public void init() {
		em = mock(IPokemonTrainerFactory.class);
		
        IPokedexFactory pokedexfactory = mock(IPokedexFactory.class);
        IPokemonMetadataProvider pokmetaprovider = mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
        
        pokedex = pokedexfactory.createPokedex(pokmetaprovider, pokemonFactory);
        poktraine1 = new PokemonTrainer("Ahmed", team.valueOf("MYSTIC"), pokedex);
        poktraine2 = new PokemonTrainer("Ghiz", team.valueOf("VALOR"), pokedex);
    }
	
	@Test
	public void createTrainer() {
		
        when(em.createTrainer(Mockito.anyString(),Mockito.any(Team.class),Mockito.any(IPokedexFactory.class))).thenAnswer(
    			new Answer() {
    				@Override
    				public Object answer(InvocationOnMock invocation) throws PokedexException {
    					Object[] args = invocation.getArguments();
    					String valeur = (String) args[0];
    					if(valeur.equals("Ahmed")){
    						return new PokemonTrainer("Ahmed", team.valueOf("MYSTIC"), pokedex);
    					}
    					else if(valeur.equals("Ghiz")) {
    						return new PokemonTrainer("Ghiz", team.valueOf("VALOR"), pokedex);
    					}
    					else {
    						return new PokedexException("Impossible de créer");
    					}
    				}
    			}
    			);
        
		
		assertEquals(poktraine1.getName(), "Ahmed" );
		assertEquals(poktraine1.getTeam(), team.valueOf("MYSTIC"));
		assertEquals(poktraine2.getName(), "Ghiz");
		assertEquals(poktraine2.getTeam(), team.valueOf("VALOR"));
		/*
		 * failure
		 */
		//assertEquals(poktraine1.getTeam(), team.valueOf("INSTINCT"));
    }
	
}
