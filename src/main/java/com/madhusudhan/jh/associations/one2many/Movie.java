package com.madhusudhan.jh.associations.one2many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE_ONE2MANY")
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MOVIE_ID")
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="MOVIE_ID")
	private Set<Actor> actors = new HashSet<>();

	public Movie(String title) {
		this.title = title;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the actors
	 */
	public Set<Actor> getActors() {
		return actors;
	}

	/**
	 * @param actors the actors to set
	 */
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}
	
}
