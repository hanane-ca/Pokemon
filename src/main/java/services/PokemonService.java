package services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Hashtable;

public class PokemonService implements PokemonserviceInterface{

    public Hashtable<String, String> getInfos(String pokemonId) {
        Hashtable<String, String> pokemonInfos
                = new Hashtable<String, String>();
        String jsonResponse = "";
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(String.format("https://pokeapi.co/api/v2/pokemon/%s",pokemonId));
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                JSONObject obj =(JSONObject)resultObject;
                pokemonInfos.put("id",obj.get("id").toString());
                pokemonInfos.put("name",obj.get("name").toString());
                pokemonInfos.put("height",obj.get("height").toString());
                pokemonInfos.put("weight",obj.get("weight").toString());
                return pokemonInfos;
            } else {
                System.err.println("Error, we expected a JSON Object from the API");
                return null;
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
