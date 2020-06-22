package br.com.swapi.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.swapi.api.model.Planeta;

public interface StarwarsRepository extends MongoRepository<Planeta, String> {

	public Planeta save(String data);
	public Optional<Planeta> findById(String id);
	void deleteById(String id);
	public List<Planeta> findAll();
	
}
