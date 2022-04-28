package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {
	
	@Test
	public void getPokemonMetadata() throws PokedexException{
		
		IPokemonMetadataProvider em = mock(IPokemonMetadataProvider.class);
		
		PokemonMetadata pok = new PokemonMetadata(0, "Bulbizarrz", 126, 126, 90);
		PokemonMetadata pok2 = new PokemonMetadata(133, "Aquali", 186, 168, 260);
		
		when(em.getPokemonMetadata(Mockito.anyInt())).thenReturn(assertExeption(0));
		
		assertEquals("Bulbizarrz", pok.getName());
		assertEquals("Aquali", pok2.getName());
	}
	
	
	public PokemonMetadata assertExeption(int index) throws PokedexException{
		
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
