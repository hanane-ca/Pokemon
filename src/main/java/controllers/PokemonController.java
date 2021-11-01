package controllers;

import models.Pokemon;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PokemonController {
    public static Pokemon parseJson(String jsonResponse){

        try{
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;
                Pokemon pokemon = new Pokemon(obj.get("id").toString(), obj.get("name").toString(), obj.get("height").toString(), obj.get("weight").toString());
                return pokemon;
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
                return null;
            }
        }
        catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
            return null;
        }
    }
}
