package com.madhusudhan.jh.annotations.id.v1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class CompositeKeyV1Test {

    private SessionFactory factory = null;

    private void init() {
        /*StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();

        Metadata metadata = new MetadataSources( standardRegistry )
            .addAnnotatedClass( Course.class )
            .getMetadataBuilder()
            .applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
            .build();

        SessionFactoryBuilder sessionFactoryBuilder = metadata.getSessionFactoryBuilder();

        factory = sessionFactoryBuilder.build();*/
    	
    	factory = new Configuration()
                .configure() // configures settings from hibernate.cfg.xml
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Course course = new Course();
        
        CoursePK coursePk = new CoursePK();
        coursePk.setTitle("Computer Science");
        coursePk.setTutor("Prof. Harry Barry");
        
        course.setId(coursePk);
        course.setTotalStudents(20);
        course.setRegisteredStudents(12);
        
        session.save(course);

        session.getTransaction().commit();
        System.out.println("Done");
    }
    
    public static void main(String[] args) {
        CompositeKeyV1Test p = new CompositeKeyV1Test();
        p.init();
        p.persist();
    }
}

