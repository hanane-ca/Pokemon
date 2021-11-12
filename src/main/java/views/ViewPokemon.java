package views;

import models.Pokemon;
import models.PokemonSql;

public class ViewPokemon {

    public static void ViewPokemonInfos(Pokemon pokemon){
        System.out.println("=============================");
        System.out.println("Pokémon # " + pokemon.getId());
        System.out.println("Nom : " + pokemon.getName());
        System.out.println("Poids : " + pokemon.getWeight());
        System.out.println("Taille : " + pokemon.getHeight());
        if(pokemon instanceof PokemonSql) {
            System.out.println("Description : " + ((PokemonSql)pokemon).getDescription());
        }
        System.out.println("=============================");
    }
}
