/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations.many2many;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="COURSE")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COURSE_ID")
    private int id = 0;
	
    private String title = null;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(joinColumns=@JoinColumn(name="COURSE_ID"), 
		inverseJoinColumns=@JoinColumn(name="STUDENT_ID"))
    private Set<Student> students = null;

    public Course(String title){
        setTitle(title);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}