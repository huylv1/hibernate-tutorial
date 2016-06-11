/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class InheritanceStrategyThreeTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure()
        		.addAnnotatedClass(Person.class)
        		.addAnnotatedClass(Employee.class)
        		.addAnnotatedClass(Executive.class);
        factory = config.buildSessionFactory();
    }

    private void test() {
    	try {
    		Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = new Employee("Barry Bumbles");
            emp.setId(4);
//            session.save(emp);

            Executive ex = new Executive("Harry Dumbles");
            ex.setId(4);
            ex.setBonus(10);
            
              session.save(emp);
            session.save(ex);
            
            session.getTransaction().commit();
            System.out.println("Done");
		} finally {
			factory.close();
		}
        
    }


    public static void main(String[] args) {
        InheritanceStrategyThreeTest test = new InheritanceStrategyThreeTest();
        test.init();
        test.test();
    }
}
