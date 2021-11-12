package controllers;

import models.Pokemon;
import models.PokemonSql;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import services.PokemonserviceInterface;

import java.util.Hashtable;

public class PokemonController {
    public static Pokemon renderData(String pokemonId, PokemonserviceInterface pokemonService){
        Hashtable<String, String> pokemonInfos =pokemonService.getInfos(pokemonId);
        if (pokemonInfos.containsKey("description")) {
            PokemonSql pokemon = new PokemonSql();
            pokemon.setId(pokemonId);
            pokemon.setName(pokemonInfos.get("name"));
            pokemon.setHeight(pokemonInfos.get("height"));
            pokemon.setWeight(pokemonInfos.get("weight"));
            pokemon.setDescription(pokemonInfos.get("description"));
            return pokemon;
        } else {
            Pokemon pokemon = new Pokemon();
            pokemon.setId(pokemonId);
            pokemon.setName(pokemonInfos.get("name"));
            pokemon.setHeight(pokemonInfos.get("height"));
            pokemon.setWeight(pokemonInfos.get("weight"));
            return pokemon;
        }
    }
}
