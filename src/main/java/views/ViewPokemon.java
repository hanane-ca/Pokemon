package views;

import models.Pokemon;

public class ViewPokemon {
    public static void ViewPokemonInfos(Pokemon pokemon){
        System.out.println("Pokémon id " + pokemon.getId());
        System.out.println("Pokémon name " + pokemon.getName());
        System.out.println("Pokémon description : weight (" +
                pokemon.getWeight() +
                "), height (" +
                pokemon.getHeight() +
                ")"
        );
    }
}
