/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.collections.array;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class ArrayTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure();//"collections/array/hibernate.cfg.xml"
        factory = config
        			.addAnnotatedClass(Showroom.class)
        			.buildSessionFactory();
    }

    private void persistArrays() {
        Session session = factory.getCurrentSession();
        
        session.beginTransaction();
        Showroom showroom = new Showroom();
        showroom.setLocation("East Croydon, Greater London");
        showroom.setManager("Barry Larry");
        String[] cars = new String[]{"Toyota","BMW","Citroen"};
        
        showroom.setCars(cars);
        
        session.save(showroom);
        
        session.getTransaction().commit();
        System.out.println("Done");
    }

    private void retrieveArrays(){
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        
        List list = session.createQuery("from com.madhusudhan.jh.collections.array.Showroom").list();
        
        for (Object object : list) {
            System.out.println("List items: "+object);
        }
        session.getTransaction().commit();
        System.out.println("Done");
        
    }
    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        test.init();
        //test.persistArrays();
        test.retrieveArrays();
    }
}