package movieapp.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import movieapp.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
