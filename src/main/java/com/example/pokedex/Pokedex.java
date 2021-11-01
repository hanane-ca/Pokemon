package com.example.pokedex;


import controllers.PokemonController;
import models.Pokemon;
import services.GetPokemonInfos;
import views.ViewPokemon;

public class Pokedex {

    public static void main(String[] args) {
        System.out.println("It's working !");
        if (args.length > 0) {
            System.out.println("Vous avez fourni l'argument " + args[0]);
        }
        String response = GetPokemonInfos.getInfos(args[0]);
        Pokemon pokemon =  PokemonController.parseJson(response);
        ViewPokemon.ViewPokemonInfos(pokemon);

    }
}
