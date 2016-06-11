/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.cascade;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class CascadeTest {

    private static SessionFactory factory = null;
    private int movieId;
    private int actorId;

    private void init() {
        Configuration config = new Configuration().configure()
									        		.addAnnotatedClass(Actor.class)
									        		.addAnnotatedClass(Movie.class);
        factory = config.buildSessionFactory();
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Movie movie = createMovie();
        session.save(movie);
        
        movieId = movie.getId();
        actorId = movie.getActors().iterator().next().getId();
        
        session.getTransaction().commit();
        System.out.println("Done");
    }
    
    private void update() {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	
    	Movie movie = session.get(Movie.class, movieId);
    	
    	movie.getActors().iterator().next().setFirstName("Lohan");
    	
    	Actor actor = session.get(Actor.class, actorId);
    	actor.getMovie().setTitle("Zoopia");
    	
    	session.getTransaction().commit();
    	System.out.println("Done");
    }
    
    private void delete() {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	
    	Movie movie = session.get(Movie.class, movieId);
    	
    	Actor actor = session.get(Actor.class, actorId);
    	session.delete(actor);
    	
    	System.out.println(movie.getTitle());
    	
    	session.getTransaction().commit();
    	System.out.println("Done");
    }

    private Movie createMovie() {
        Movie movie = null;
        Actor actor = null;

        Set<Actor> actors = new HashSet<Actor>();

        movie = new Movie("Johnny English");

        actor = new Actor(movie, "Rowan", "Atkinson", "Mr Bean");
        actors.add(actor);

        movie.setActors(actors);


        return movie;
    }

    public static void main(String[] args) {
        CascadeTest p = new CascadeTest();
        p.init();
        try {
        	p.persist();
        	p.update();
        	p.delete();
		} finally {
			factory.close();
		}
    }
}