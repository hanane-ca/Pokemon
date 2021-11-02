package services;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class GetPokemonInfos implements PokemonserviceInterface{

    public String getInfos(String pokemonId) {
        String jsonResponse = "";
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(String.format("https://pokeapi.co/api/v2/pokemon/%s",pokemonId));
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }
}
