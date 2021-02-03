package movieapp.persistance;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import movieapp.entity.Person;

@DataJpaTest
class PersonRepositoryTest {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	void testSave() {
		saveAssertPerson("Steve McQueen", LocalDate.of(1930, 3, 24), null);
	}
	
	@Test
	void testFindByName() {
		var persons = List.of(
				new Person("Steve McQueen", LocalDate.of(1930, 3, 24), LocalDate.of(1980, 11, 7)),
				new Person("Steve McQueen", LocalDate.of(1969, 10, 9)),
				new Person("Alfred Hitchock")
				);
		persons.forEach(entityManager::persist);
		entityManager.flush();
		var personsFound = personRepository.findByName("Steve McQueen");
		assertEquals(2, personsFound.size());
		assertAll(
				personsFound.stream().map( m -> () -> assertEquals("Steve McQueen", m.getName()) ) 
				);
		
	}
	
	@Test
	void testFindById() {
		var persons = List.of(
				new Person("Steve McQueen", LocalDate.of(1930, 3, 24), LocalDate.of(1980, 11, 7)),
				new Person("Steve McQueen", LocalDate.of(1969, 10, 9)),
				new Person("Alfred Hitchock")
				);
		persons.forEach(entityManager::persist);
		entityManager.flush();
		var personFound = personRepository.findById(persons.get(2).getId());
		assertEquals("Alfred Hitchock",personFound.get().getName());
		
	}
	
	@Test
	void testFindAll() {
		var persons = List.of(
				new Person("Steve McQueen", LocalDate.of(1930, 3, 24), LocalDate.of(1980, 11, 7)),
				new Person("Steve McQueen", LocalDate.of(1969, 10, 9)),
				new Person("Alfred Hitchock")
				);
		persons.forEach(entityManager::persist);
		entityManager.flush();
		var personsFound = personRepository.findAll();
		assertEquals(3,personsFound.size());
		
	}

	private void saveAssertPerson(String title, LocalDate birthday, LocalDate deathday) {
		Person person = new Person("Steve McQueen", LocalDate.of(1930, 3, 24), null);
		// when
		personRepository.save(person);
		// then
		var idPerson = person.getId();
		assertNotNull(idPerson, "id generated by database");
	}
}
