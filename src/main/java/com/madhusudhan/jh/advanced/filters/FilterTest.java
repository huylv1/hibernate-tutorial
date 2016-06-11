/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.filters;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class FilterTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure()
        							.addAnnotatedClass(Car.class);//"advanced/hibernate.cfg.filters.xml"
        factory = config.buildSessionFactory();
    }

    private void test() {
    	try {
    		Session session = factory.getCurrentSession();
            session.beginTransaction();

            Filter filter = session.enableFilter("filterByBMWMake");
            filter.setParameter("make", new String("BMW"));

            List results = session.createQuery("from Car").list();
            System.out.println("Results " + results);

            session.getTransaction().commit();
            System.out.println("Done");
		} finally {
			factory.close();
		}
    }

    public void createCars() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Car car = null;

        for (int i = 0; i < 10; i++) {
            car = new Car();
//            car.setId(i);
            car.setName("BMW Green Car");
            car.setModel("X" + i);
            car.setMake("BMW");
            session.save(car);
        }

        session.getTransaction().commit();
        System.out.println("Done");
    }

    public static void main(String[] args) {
        FilterTest test = new FilterTest();
        test.init();
//        test.createCars();
        test.test();

    }
}
