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
        //we will use a hashTable where the name of the attributes are the keys and the data is the values
        Hashtable<String, String> pokemonInfos =pokemonService.getPokemonInfos(pokemonId);
        //Check if we use the api or local data in other words check if we have the description arg or not
        //So we can use the appropriate module
        //Also the controller doesn't depend on the implementation because we treat each case in here
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
