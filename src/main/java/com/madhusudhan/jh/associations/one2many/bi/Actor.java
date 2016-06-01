/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations.one2many.bi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="ACTOR_ONE2MANY_BI")
public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACTOR_ID")
    private int id = 0;
	
	@Column(name="FIRST_NAME")
    private String firstName = null;
	
	@Column(name="LAST_NAME")
    private String lastName = null;
	
	@Column(name="SHORT_NAME")
    private String shortName = null;
    //We want to know the movie this actor belongs to!
	
	@ManyToOne
	@JoinColumn(name="MOVIE_ID")
    private Movie movie = null;

    public Actor(Movie movie, String firstName, String secondName, String shortName) {
        setMovie(movie);
        setFirstName(firstName);
        setLastName(secondName);
        setShortName(shortName);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}