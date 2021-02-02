package movieapp.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PersonTest {

	@Test
	void testPersonArtist() {
		Person person = new Person("Steve McQueen", LocalDate.of(1930, 3, 24));
		assertAll(
				() -> assertEquals("Steve McQueen", person.getName()),
				() -> assertEquals(LocalDate.of(1930, 3, 24), person.getBirthdate())
				);
	}

}
