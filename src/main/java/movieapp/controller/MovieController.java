package movieapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import movieapp.entity.Movie;
import movieapp.persistance.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

	@Autowired
	private MovieRepository movieRepository;
	
	/**
	 * url /api/movies
	 * @return
	 */
	@GetMapping
	public List<Movie> movies() {
//		return List.of(
//			new Movie("Kabir Singh", 2019, 172),
//			new Movie("Devdas", 2002, 185)
//		);
		return movieRepository.findAll();
	}
	
	/**
	 * url /api/movies/find
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Movie> movie(@PathVariable("id") int id) {
		return movieRepository.findById(id);
	}
	
	/**
	 * url /api/movies
	 * @param movie
	 * @return
	 */
	@PostMapping
	@ResponseBody
	public Movie addMovie(@RequestBody Movie movie) {
		movieRepository.save(movie);
		System.out.println(movie.toString());
		return movie;
	}
	
	/**
	 * url /api/movies
	 * @param movie
	 * @return
	 */
	@PostMapping("/addlist")
	@ResponseBody
	public List<Movie> addMovies(@RequestBody List<Movie> movies) {
		movieRepository.saveAll(movies);
		System.out.println(movies.toString());
		return movies;
	}
}
