package com.madhusudhan.jh.associations.one2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyTest {
	private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure()
        							.addAnnotatedClass(Movie.class)
        							.addAnnotatedClass(Actor.class);        
        factory = config.buildSessionFactory();
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Movie movie = createMovie();
        session.save(movie);

        session.getTransaction().commit();
        System.out.println("Done");
    }

    private Movie createMovie() {
        Movie movie = null;
        Actor actor = null;

        Set<Actor> actors = new HashSet<Actor>();

        movie = new Movie("Chennai Express");

        actor = new Actor("Sharukh", "Khan", "King Khan");
        actors.add(actor);
        actor = new Actor("Deepika", "Padukone", "Miss Chennai");
        actors.add(actor);

        movie.setActors(actors);

        return movie;
    }

    public static void main(String[] args) {
        OneToManyTest p = new OneToManyTest();
        p.init();
        p.persist();
    }
}
