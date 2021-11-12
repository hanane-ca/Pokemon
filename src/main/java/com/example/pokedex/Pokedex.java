package com.example.pokedex;


import controllers.PokemonController;
import models.Pokemon;
import models.PokemonSql;
import services.PokemonService;
import services.PokemonServiceSQL;
import services.PokemonserviceInterface;
import views.ViewPokemon;

public class Pokedex {

    public static void main(String[] args) {
        PokemonserviceInterface pokemonService = null;
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }
        if(args.length == 1){
            pokemonService = new PokemonService();
        }
        else if(args.length == 2){
            pokemonService = new PokemonServiceSQL(args[1]);
        }

        PokemonController pokemonController=new PokemonController();
        Pokemon pokemon=pokemonController.renderData(args[0],pokemonService);
        ViewPokemon view = new ViewPokemon(pokemon);
        System.out.println(view.generateText());
        System.out.println(view.generateHtml());
    }

    public String getName(){
        return "Hello";
    }
}
