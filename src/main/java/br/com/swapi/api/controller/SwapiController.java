package br.com.swapi.api.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.swapi.api.model.Planeta;
import br.com.swapi.api.service.SearchApiService;
import br.com.swapi.api.service.StarwarsRepository;

@RestController
@RequestMapping("/")
public class SwapiController {

	@Autowired
	private StarwarsRepository starwarsRepo;

	@GetMapping(value = "/home")
	public String readData(Model model) throws Exception {

		String dataTest = ".";
		System.out.println(getNumPlanets());
		return getNumPlanets().toString();
	}

	@GetMapping(path = "/search/{id}")
	public String findById(@PathVariable(name = "id") String id) {
		Optional<Planeta> planet = starwarsRepo.findById(id);
		return planet.toString();
	}

	@GetMapping(path = "/search/all")
	public String findAll() {
		List<Planeta> planet = starwarsRepo.findAll();
		return planet.toString();
	}

	@PutMapping(path = "/add/")
	public String insert(@RequestBody Planeta data) {
		data.set_id(ObjectId.get());
		Planeta newPlaneta = starwarsRepo.save(data);
		return newPlaneta.toString();
	}

	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable(name = "id") String id) {
		 starwarsRepo.deleteById(id);
	}

	private JSONObject getNumPlanets() throws Exception {

		JSONObject planetData;

		SearchApiService getPlanets_ = new SearchApiService();
		planetData = getPlanets_.getBuilder("planets", null);

		// System.out.println(planetData.get("count"));

		return planetData;

	}

}
