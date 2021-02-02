package movieapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import movieapp.entity.Movie;
import movieapp.persistance.MovieRepository;

@Transactional
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
	
	@PutMapping
	public Optional<Movie> updateMovie(@RequestBody Movie movie) {
		Optional<Movie> optMovieDb = movieRepository.findById(movie.getId());
		optMovieDb.ifPresent(m -> {
			m.setDirector(movie.getDirector());
			m.setDuration(movie.getDuration());
			m.setId(movie.getId());
			m.setTitle(movie.getTitle());
			m.setYear(movie.getYear());
		});
		System.out.println(optMovieDb.toString());
		return optMovieDb;
	}
	
	@DeleteMapping
	public Optional<Movie> deleteMovie(@RequestBody Movie movie) {
		return deleteMovie(movie.getId());
	}
	
	@DeleteMapping("/{id}")
	public Optional<Movie> deleteMovie(@PathVariable("id") int id) {
		Optional<Movie> optMovieDb = movieRepository.findById(id);
		
		optMovieDb.ifPresent(m -> movieRepository.deleteById(id));
		System.out.println(optMovieDb.toString());
		return optMovieDb;
	}
	
	@GetMapping("/byTitle")
	@ResponseBody
	public List<Movie> moviesByTitle(@RequestParam String title) {
		return movieRepository.findByTitle(title);
	}
	
	@GetMapping("/byTitleContaining")
	@ResponseBody
	public List<Movie> moviesByTitleContaining(@RequestParam String title) {
		return movieRepository.findByTitleContainingIgnoreCase(title);
	}
}
