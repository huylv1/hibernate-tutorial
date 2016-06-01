/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class ManyToManyTest {

    private SessionFactory factory = null;

    private void init() {
        Configuration config = new Configuration().configure()
        							.addAnnotatedClass(Course.class)
        							.addAnnotatedClass(Student.class);
        factory = config.buildSessionFactory();
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            Course course = createCoursesAndStudents();
            session.save(course);
            tx.commit();
        } catch (HibernateException he) {
            if(tx!=null)
                tx.rollback();
            throw he;
        }finally{
            //session.close();
        }
        System.out.println("Done");
    }

    private Course createCoursesAndStudents() {
        Set<Student> students = new HashSet<Student>();
        Course course = null;

        Student studentA = new Student("Mike Meyer");

        Student studentB = new Student("M Kay");
        students.add(studentA);
        students.add(studentB);

        course = new Course("Art of Living");
        course.setStudents(students);

        return course;
    }

    public static void main(String[] args) {
        ManyToManyTest p = new ManyToManyTest();
        p.init();
        p.persist();
    }
}