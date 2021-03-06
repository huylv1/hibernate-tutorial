package com.madhusudhan.jh.collections.set.ann;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class AnnotationListTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure()
                .addAnnotatedClass(Showroom.class)
                .addAnnotatedClass(Car.class);
        factory = config.buildSessionFactory();
    }

    private void persistAnnotatedLists() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Barry Larry");
        Set<Car> cars = new HashSet<Car>();
        
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Nissan", "White"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("BMW", "Black"));
        cars.add(new Car("Mercedes", "Silver"));

        showroom.setCars(cars);
        
        session.save(showroom);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveList(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        List list = session.createQuery("from com.madhusudhan.jh.collections.set.ann.Showroom").list();
        
        for (Object object : list) {
            System.out.println("List items: "+object);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        
    }
    public static void main(String[] args) {
        AnnotationListTest test = new AnnotationListTest();
        test.init();
        test.persistAnnotatedLists();
        test.retrieveList();
    }
}