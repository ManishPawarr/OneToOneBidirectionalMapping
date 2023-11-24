package com.example.OneToOneMapping.Entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "date")
	private Date date;

	@OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
	private List<InstructorDetails> instructorDetails;

	public Instructor() {
		super();
	}

	public Instructor(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<InstructorDetails> getInstructorDetails() {
		return instructorDetails;
	}

	public void setInstructorDetails(List<InstructorDetails> instructorDetails) {
		this.instructorDetails = instructorDetails;
	}

}
