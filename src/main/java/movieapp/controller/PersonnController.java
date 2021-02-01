package movieapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/persons")
public class PersonnController {
	
	/**
	 * url api/persons
	 * @return
	 */
	@GetMapping
	public List<String> persons() {
		return List.of("Shahid Kapoor", "Kiara Advani", "Krishan Kumar");
	}
	
	/**
	 * url api/persons/star
	 * @return
	 */
	@GetMapping("/star")
	public String star() {
		return "Kiara Advani";
	}
	
	/**
	 * url api/persons/producer
	 * @return
	 */
	@GetMapping("/producer")
	public String producer() {
		return "Krishan Kumar";
	}
	
}
