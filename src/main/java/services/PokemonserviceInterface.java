package services;

import java.util.Hashtable;

public interface PokemonserviceInterface {
    public Hashtable<String, String> getPokemonInfos(String pokemonId);
}
