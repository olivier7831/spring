package movieapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movieapp.entity.Person;
import movieapp.persistance.PersonRepository;

@RestController
@RequestMapping("api/persons")
public class PersonnController {
	
	@Autowired
	PersonRepository personRepository;
	
	/**
	 * url api/persons
	 * @return
	 */
	@GetMapping
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	/**
	 * url api/persons/name
	 * @return
	 */
	@GetMapping("/name")
	public List<Person> findName(String name) {
		return personRepository.findByName(name);
	}
	
	/**
	 * url api/persons/{id}
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Person> findId(@PathVariable int id) {
		return personRepository.findById(id);
	}
	
	@PostMapping()
	public void persons(@RequestBody List<Person> persons) {
		
	}
}
