package br.com.swapi.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class SearchService {

	public JSONObject getBuilder(String path, String searchquery) throws Exception {

		try {
			URL url = new URL("https://swapi.dev/api/planets/");

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

			JSONObject myResponse = new JSONObject(result.toString().trim());

			System.out.println("CCCCCCCCCCCC " + myResponse.get("count"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return null;

	}

}
