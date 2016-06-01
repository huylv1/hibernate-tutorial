/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.types;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author mkonda
 */
public class CustomTypeTest {

    private SessionFactory sessionFactory = null;

    private void init() {
        // A SessionFactory is set up once for an application!
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    			.configure() // configures settings from hibernate.cfg.xml
    			.build();
    	try {
    		sessionFactory = new MetadataSources( registry )
    				.addAnnotatedClass(TravelReview.class)
    				.addAnnotatedClass(FooBar.class)
    				.getMetadataBuilder()
    				.applyBasicType(PhoneNumberType.INSTANCE, PhoneNumberType.KEYS)
    				.applyBasicType(JaNeeType.INSTANCE, JaNeeType.NAME)
    				.build()
    				.buildSessionFactory();
    	}
    	catch (Exception e) {
    		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
    		// so destroy it manually.
    		e.printStackTrace();
    		StandardServiceRegistryBuilder.destroy( registry );
    	}

    }
    
    private void persist() {
    	TravelReview tr = new TravelReview();
		tr.setPhoneNumber(new PhoneNumber(1, 10245, "USA"));
		
		FooBar fooBar = new FooBar();
		fooBar.setBarIndicator(true);
		fooBar.setFooIndicator(false);
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(tr);
		session.save(fooBar);
		session.getTransaction().commit();
    }

    public static void main(String[] args) {
        CustomTypeTest test = new CustomTypeTest();
        test.init();
        test.persist();
    }
}