package movieapp.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import movieapp.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Integer>{
	List<Person> findByName(String name);
	Optional<Person> findById(int id);
	List<Person> findAll();
}
