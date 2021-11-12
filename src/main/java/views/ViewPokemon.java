package views;

import models.Pokemon;
import models.PokemonSql;
import utilities.ConsoleTextGeneratorInterface;
import utilities.HtmlGeneratorInterface;

public class ViewPokemon implements ConsoleTextGeneratorInterface, HtmlGeneratorInterface {

    Pokemon pokemon;

    public ViewPokemon(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    @Override
    public String generateText() {
        String consoleText = "=============================\n" +
                " Pokémon # "+ pokemon.getId() + "\n" +
        "Nom : " + pokemon.getName() + "\n" +
                "Poids : " + pokemon.getWeight() + "\n" +
                "Taille : " + pokemon.getHeight() + "\n";
        if (pokemon instanceof PokemonSql) {
            consoleText += "Description : " + ((PokemonSql) pokemon).getDescription()+ "\n";
        }
        consoleText += "=============================";
        return consoleText;
    }

    @Override
    public String generateHtml() {
        String html ="<h1>"+pokemon.getName()+"</h1>\n" +
                "<ul>\n" +
                "<li> Id: "+pokemon.getId()+"</li>\n" +
                "<li>Taille :"+ pokemon.getHeight()+"</li>\n" +
                "<li>Poids : "+pokemon.getWeight()+"</li>\n" ;
        if(pokemon instanceof PokemonSql){
            html+="<li>Description : " + ((PokemonSql) pokemon).getDescription() +"</li>\n"
                    +"</ul>";
        }
        else
            html+="</ul>";
        return html;
    }
}
