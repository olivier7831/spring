package movieapp.persistance;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import movieapp.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	List<Movie> findAll(Sort sort);
	List<Movie> findByTitle(String title);
//	List<Movie> findByYear(int year);
	List<Movie> findByTitleContainingIgnoreCase(String str);
	
	// Exos
	List<Movie> findByYearGreaterThanEqualOrderByYear(int year);
	List<Movie> findByYearBetweenOrderByYear(int down, int up);
	List<Movie> findByDurationNullOrderByTitle();
	List<Movie> findByTitleIgnoreCaseAndYearOrderByTitle(String title, int year);
	List<Movie> findByYearOrderByTitle(int year);
}
