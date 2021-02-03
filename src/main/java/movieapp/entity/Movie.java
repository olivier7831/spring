package movieapp.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Movie {
	
	private String title;
	private Integer year;
	private Integer duration;
	private Integer id;
	private Person director;
	
	
	@ManyToOne //(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_director", nullable = true)
	public Person getDirector() {
		return director;
	}

	public void setDirector(Person director) {
		this.director = director;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Movie(String title) {
		super();
		this.title = title;
	}

	public Movie(String title, Integer year) {
		super();
		this.title = title;
		this.year = year;
	}
	
	public Movie(String title, Integer year, Integer duration) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
	}

	public Movie(String title, Integer year, Integer duration, Person director) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.director = director;
	}

	@Column(nullable = false, length = 300)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Column(nullable = true)
	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(getTitle())
			.append("-")
			.append(getYear())
			.append("-")
			.append(getDuration())
			.append(" mn");
		return result.toString();
	}
}
