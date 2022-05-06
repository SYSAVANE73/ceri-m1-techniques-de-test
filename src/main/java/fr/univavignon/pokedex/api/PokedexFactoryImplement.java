package fr.univavignon.pokedex.api;

public class PokedexFactoryImplement implements IPokedexFactory{

	IPokemonMetadataProvider metadataProvider;
	IPokemonFactory pokemonFactory;
	
	/*
	public PokedexFactoryImplement() {
		metadataProvider = new MetadataP
	}
	*/
	@Override
	public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
		// TODO Auto-generated method stub
		return new PokedexImplement();
	}

}
