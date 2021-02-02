package movieapp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	private String name;
	private Integer id;
	private LocalDate birthdate;
	private LocalDate deathdate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Person(String name, LocalDate birthdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
	}

	public Person(String name, LocalDate birthdate, LocalDate deathdate) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.deathdate = deathdate;
	}

	@Column(nullable = false, length = 100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = true)
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Column(nullable = true)
	public LocalDate getDeathdate() {
		return deathdate;
	}

	public void setDeathdate(LocalDate deathdate) {
		this.deathdate = deathdate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ",  name=" + name + ", birthdate=" + birthdate + ", deathdate=" + deathdate + "]";
	}
	
}
