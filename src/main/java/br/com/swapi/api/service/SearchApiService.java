package br.com.swapi.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SearchApiService {

	public JSONObject getBuilder(String path, String searchquery) throws Exception {

		URL url;
		
		try {
			
			if(searchquery == null) {
				url = new URL("https://swapi.dev/api/" + path + "/");
			} else {
				url = new URL("https://swapi.dev/api/" + path + "/" + searchquery + "/");
			}

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("charset", "utf-8");
			connection.connect();

			BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder result = new StringBuilder();
			String line;

			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			JSONObject myResponse = new JSONObject(result.toString());
			
			return myResponse;

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public ArrayNode getAllPlanetsExternal() throws Exception {
		
		JSONObject numPlanets = this.getBuilder("planets",null);
		int numPlanetsConvert = Integer.valueOf(numPlanets.get("count").toString());
		
		ObjectMapper objMapper = new ObjectMapper();
		
		ArrayNode arrayNode = objMapper.createArrayNode();
		
			
			try {
				
				for(int i = 1; i <= numPlanetsConvert; i++ ) {
				
				JSONObject numPlanetsById = this.getBuilder("planets",""+i+"");
				
				ObjectNode parentNode = objMapper.createObjectNode();
				JsonNode jsonNode = objMapper.readTree(numPlanetsById.toString());
				parentNode.set("planet" + numPlanetsById.get("name"), jsonNode);
				arrayNode.add(parentNode);
				}
				
				return arrayNode;
				
			} catch (Exception e) {	}			
				return arrayNode;
		
	}

}