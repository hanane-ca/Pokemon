package com.example.pokedex;

import controllers.PokemonController;
import models.Pokemon;
import models.PokemonSql;
import org.junit.Assert;
import org.junit.Test;
import services.PokemonService;
import services.PokemonServiceSQL;
import services.PokemonserviceInterface;
import java.util.Hashtable;

    public class PokemonsControllerTest {

        @Test
        public void getPokemon() {
            PokemonController pokemonController = new PokemonController();
            Pokemon pokemon = null;
            try {
                pokemon = pokemonController.renderData("2", new PokemonFetcherMock());
            } catch (Exception e) {
                e.printStackTrace();
            }

            /**
             * The fetcher returned a description, test that the controller returns an instance
             * of AdvancedPokemon
             */
            Assert.assertTrue(pokemon instanceof PokemonSql);
            PokemonSql PokemonSql = (PokemonSql) pokemon;

            /**
             * Test that the controller created the pokemon instance with all
             * the correct data
             */
            Assert.assertEquals("2", pokemon.getId());
            Assert.assertEquals("Poketest", pokemon.getName());
            Assert.assertEquals("22", pokemon.getHeight());
            Assert.assertEquals("33", pokemon.getWeight());
            Assert.assertEquals("Poke test description", PokemonSql.getDescription());

        }

        class PokemonFetcherMock implements PokemonserviceInterface {
            @Override
            public Hashtable<String, String> getPokemonInfos(String pokemonId) {
                Hashtable<String,String> pokemonInfos =new Hashtable<String,String>();
                pokemonInfos.put("name","Poketest");
                pokemonInfos.put("height","22");
                pokemonInfos.put("weight","33");
                pokemonInfos.put("description","Poke test description");
                return pokemonInfos;            }
        }

}
