/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class InheritanceStrategyTwoTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Executive.class);
        
        factory = config.buildSessionFactory();
    }

    private void test() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Employee emp = new Employee("Barry Bumbles");
        session.save(emp);
        Executive ex = new Executive("Harry Dumbles");
        ex.setRole("Director");
        
        session.save(ex);
        session.getTransaction().commit();
        
        factory.close();
        System.out.println("Done");
    }


    public static void main(String[] args) {
        InheritanceStrategyTwoTest test = new InheritanceStrategyTwoTest();
        test.init();
        test.test();
    }
}
