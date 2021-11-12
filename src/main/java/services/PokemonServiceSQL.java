package services;

import java.sql.ResultSet;
import java.sql.*;
import java.util.Hashtable;

import static java.lang.Integer.parseInt;

public class PokemonServiceSQL implements PokemonserviceInterface{
    String sqlFile;
    public PokemonServiceSQL(String sqlFile){
        this.sqlFile = sqlFile;
    }
    @Override
    public Hashtable<String, String> getInfos(String pokemonId) {
        Hashtable<String, String> pokemonInfos
                = new Hashtable<String, String>();
        /* Connect to the database */
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:"+sqlFile;
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement(String.format("SELECT name,height,weight, description FROM pokemons WHERE id = ?"));
            stmt.setString(1,pokemonId);
            ResultSet rs    = stmt.executeQuery();
            rs.next();
            pokemonInfos.put("id",pokemonId);
            pokemonInfos.put("name",rs.getString("name"));
            pokemonInfos.put("height",rs.getString("height"));
            pokemonInfos.put("weight",rs.getString("weight"));
            pokemonInfos.put("description",rs.getString("description"));
            return pokemonInfos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
