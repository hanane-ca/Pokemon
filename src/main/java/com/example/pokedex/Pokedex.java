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
        //if we have only one argument then it means we will use the api
        if(args.length == 1){
            pokemonService = new PokemonService();
        }
        //if we have 2 arguments it means that we will use the local database
        else if(args.length == 2){
            pokemonService = new PokemonServiceSQL(args[1]);
        }

        PokemonController pokemonController=new PokemonController();
        Pokemon pokemon=pokemonController.renderData(args[0],pokemonService);
        ViewPokemon view = new ViewPokemon(pokemon);
        //print the console text
        System.out.println(view.generateText());
        //print the html
        System.out.println(view.generateHtml());
    }

    public String getName(){
        return "Hello";
    }
}
