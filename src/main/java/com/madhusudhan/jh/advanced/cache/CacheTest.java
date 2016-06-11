package com.madhusudhan.jh.advanced.cache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.stat.Statistics;

public class CacheTest {
	int id;

    @SuppressWarnings("unchecked")
	private void secondLevelCache() {
    	System.out.println("Temp Dir:"+System.getProperty("java.io.tmpdir"));
        
        //Initialize Sessions
    	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Statistics stats = sessionFactory.getStatistics();
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
        stats.setStatisticsEnabled(true);
        System.out.println("Stats enabled="+stats.isStatisticsEnabled());
         
        Session session = sessionFactory.openSession();
        Session otherSession = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Transaction otherTransaction = otherSession.beginTransaction();
        
        printStats(stats, 0);
        
        Person emp = session.load(Person.class, id);
        printData(emp, stats, 1);
         
        emp = session.load(Person.class, id);
        printData(emp, stats, 2);
         
        //clear first level cache, so that second level cache is used
        session.evict(emp);
        emp = session.load(Person.class, id);
        printData(emp, stats, 3);
        
        emp = otherSession.load(Person.class, id);
        printData(emp, stats, 4);
        
        //emp.setFirstName("Huy");
        
        session.createQuery("from person p where p.id = ?").setParameter(0, id).setCacheable(true).list();
        
        List<Person> persons = session.createQuery("from person p where p.id = ?").setParameter(0, id).setCacheable(true).list();
        
        System.out.println();
        System.out.println();
        System.out.println(persons.get(0));
        System.out.println();
        System.out.println();
        
        //Release resources
        transaction.commit();
        otherTransaction.commit();
        sessionFactory.close();
    }

	private void persist() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Person p = new Person();
        p.setFirstName("Huy");
        p.setLastName("Le Van");
        p.setNickName("huylv");
        session.persist(p);
        id = p.getId();
        session.getTransaction().commit();
	}
    
    private static void printData(Person emp, Statistics stats, int count) {
        System.out.println(count+":: Name="+emp.getFirstName());
        printStats(stats, count);
    }
    
    private static void printStats(Statistics stats, int i) {
        System.out.println("***** " + i + " *****");
        System.out.println("Fetch Count="
                + stats.getEntityFetchCount());
        System.out.println("Second Level Hit Count="
                + stats.getSecondLevelCacheHitCount());
        System.out
                .println("Second Level Miss Count="
                        + stats
                                .getSecondLevelCacheMissCount());
        System.out.println("Second Level Put Count="
                + stats.getSecondLevelCachePutCount());
    }

    public static void main(String[] args) {
        CacheTest test = new CacheTest();
        test.persist();
        test.secondLevelCache();
    }
}
