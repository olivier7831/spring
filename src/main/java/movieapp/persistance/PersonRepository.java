package movieapp.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

import movieapp.entity.Person;


public interface PersonRepository extends JpaRepository<Person, Integer>{

}
