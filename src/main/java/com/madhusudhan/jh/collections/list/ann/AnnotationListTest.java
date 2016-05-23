package com.madhusudhan.jh.collections.list.ann;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AnnotationListTest {
	private SessionFactory factory = null;

    private void init() {
        factory = new Configuration().configure()
                		.addAnnotatedClass(Showroom.class)
                		.addAnnotatedClass(Car.class)
                		.buildSessionFactory();
    }

    private void persistAnnotatedLists() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Barry Larry");
        List<Car> cars = new ArrayList<Car>();
        
        cars.add(new Car("Toyota", "Racing Green"));
        cars.add(new Car("Nissan", "White"));
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
        
        List list = session.createQuery("from com.madhusudhan.jh.collections.list.ann.Showroom").list();
        
        for (Object object : list) {
            System.out.println("** List items: "+object);
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
