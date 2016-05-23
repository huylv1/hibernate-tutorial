/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.collections.array;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="SHOWROOM_ARRAY")
public class Showroom {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	@Column(name="SHOWROOM_ID")
    private int id = 0;
	
    private String manager = null;
    private String location = null;
    
    @ElementCollection
    @OrderColumn(name="CAR_INDEX")
    @JoinTable(name="CARS_ARRAY", joinColumns= {
    		@JoinColumn(name="SHOWROOM_ID")
    })
    @Column(name="CAR_NAME")
    private String[] cars = new String[]{};

    public Showroom(){
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getCars() {
        return cars;
    }

    public void setCars(String[] cars) {
        this.cars = cars;
    }
    
    @Override
    public String toString() {
        return "Showroom{" + "id=" + id + ", manager=" + manager + ", location=" + location + ", cars=" + cars + '}';
    }
}