package com.example.SpringDataJPAManyToManyMapping.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long movieId;
	private String movieName;
	
	@ManyToMany(mappedBy="moviesDone",
			cascade=CascadeType.PERSIST,
			fetch=FetchType.EAGER)
	private Set<Actor> actors = new HashSet<Actor>();
	
	public void addActor(Actor actor) {
		actors.add(actor);
		actor.getMoviesDone().add(this);
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public Movie() {
		super();
	}

	public Movie(String movieName) {
		super();
		this.movieName = movieName;
	}
	
	
}
