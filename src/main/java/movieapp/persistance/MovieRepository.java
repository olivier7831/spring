package movieapp.persistance;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import movieapp.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	List<Movie> findByTitle(String title);
	List<Movie> findByYear(int year);

}
