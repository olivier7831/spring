package movieapp.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import movieapp.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	List<Movie> findByTitle(String title);
//	List<Movie> findByYear(int year);
	List<Movie> findByTitleContainingIgnoreCase(String str);
	
	// Exos
	List<Movie> findByYearGreaterThanEqual(int year);
	List<Movie> findByYearBetween(int down, int up);
	List<Movie> findByDurationNull();
	List<Movie> findByTitleIgnoreCaseAndYear(String title, int year);

}
