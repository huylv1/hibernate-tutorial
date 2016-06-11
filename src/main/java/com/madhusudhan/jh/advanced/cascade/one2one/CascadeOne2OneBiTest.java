/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.cascade.one2one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author mkonda
 */
public class CascadeOne2OneBiTest {

    private static SessionFactory factory = null;
    private Long id;

    private void init() {
        Configuration config = new Configuration().configure()
									        		.addAnnotatedClass(Post.class)
									        		.addAnnotatedClass(PostDetails.class);
        factory = config.buildSessionFactory();
    }

    private void persist() {
        Session session = factory.getCurrentSession();
        session.beginTransaction();

        Post post = new Post();
        post.setName("Hibernate Master Class");
         
        PostDetails details = new PostDetails();
         
        post.addDetails(details);
        
        session.persist(post);
        id = post.getId();
        
        session.getTransaction().commit();
        System.out.println("Done");
    }
    
    private void merge() {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	
    	Post post = new Post();
    	post.setName("Hibernate Master Class Training Material");
    	
    	PostDetails details = new PostDetails();
        
        post.addDetails(details);
    	post.getDetails().setVisible(true);
    	 
    	post = (Post) session.merge(post);
    	id = post.getId();
    	
    	session.getTransaction().commit();
    	System.out.println("Done");
    }
    
    private void delete() {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	
    	Post post = session.get(Post.class, id);
    	session.delete(post);
    	
    	session.getTransaction().commit();
    	System.out.println("Done");
    }
    
    private void deleteOrphan() {
    	Session session = factory.getCurrentSession();
    	session.beginTransaction();
    	
    	Post post = (Post) session.get(Post.class, id);
        post.removeDetails();
    	
    	session.getTransaction().commit();
    	System.out.println("Done");
    }

    public static void main(String[] args) {
        CascadeOne2OneBiTest p = new CascadeOne2OneBiTest();
        p.init();
        try {
        	p.persist();
        	p.delete();
        	p.merge();
        	p.deleteOrphan();
		} finally {
			factory.close();
		}
    }
}