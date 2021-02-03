package movieapp.persistance;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import movieapp.entity.Movie;
import movieapp.entity.Person;

@DataJpaTest
class MovieRepositoryDirectorCRUD {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	void testSaveMovieWithDirector() {
		Person director = new Person("Clint Eastwood", LocalDate.of(1930, 5, 31));
		Movie movie = new Movie("Gran Torino", 2009, 116, director);
//		Movie movie = new Movie("Gran Torino", 2009, 116, new Person("Clint Eastwood", LocalDate.of(1930, 5, 31)));
		personRepository.save(director);
		movieRepository.save(movie);
//		System.out.println("movie id= " + movie.getId());
//		System.out.println(movie.getDirector());
		entityManager.clear();
		Movie movieFound = entityManager.find(Movie.class, movie.getId());
		System.out.println(movieFound.getDirector());
		assertNotNull(movieFound.getDirector());
	}

	@Test
	void testSetExistingDirectorOnExistingMovie() {
		Person director = new Person("Clint Eastwood", LocalDate.of(1930, 5, 31));
		Movie movie = new Movie("Gran Torino", 2009, 116);
		entityManager.persist(director);
		entityManager.persist(movie);
		
		entityManager.flush();
		entityManager.clear();
		
		int idDirector = director.getId();
		int idMovie = movie.getId();
		var artistFound = personRepository.findById(idDirector);
		var movieFound = movieRepository.findById(idMovie);
		assertAll(
				() -> assertTrue(artistFound.isPresent()),
				() -> assertTrue(movieFound.isPresent())
				);
		movieFound.get().setDirector(artistFound.get());
		
		entityManager.flush();
		var movieUpdated = movieRepository.findById(idMovie);
		assertNotNull(movieUpdated.get().getDirector());
		System.out.println(movieUpdated.get().getDirector());
	}
}
