package movieapp.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovieTest {

	@Test
	void testDefaultConstructor() {
		Movie movie = new Movie();
//		System.out.println(movie);
		assertEquals("null-null-null mn",movie.toString(), () -> "Default constructor");
	}
	
	@Test
	void testFullConstructor() {
		Movie movie = new Movie("Kabir Singh", 2019, 172);
		assertEquals("Kabir Singh-2019-172 mn",movie.toString(), () -> "Constructor with all parameters");
	}

}
