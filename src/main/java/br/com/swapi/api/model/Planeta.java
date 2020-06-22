package br.com.swapi.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "starwars")
public class Planeta {

	@Id
	public ObjectId _id;
	public String name;
	public String clima;
	public String terreno;
	public String shows;
	
	public Planeta() {}
	
	public Planeta(ObjectId _id,String name, String clima, String terreno, String shows) {
		
		this._id = _id;
		this.name = name;
        this.clima = clima;
        this.terreno = terreno;
        this.shows = shows;
	}
	
	
	
	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public String getShows() {
		return shows;
	}

	public void setShows(String shows) {
		this.shows = shows;
	}

	@Override
	  public String toString() {
	    return String.format(
	        "Planeta[id=%s, name='%s', clima='%s', terreno='%s',shows='%s']",
	        _id, name, clima, terreno, shows);
	  }

}
