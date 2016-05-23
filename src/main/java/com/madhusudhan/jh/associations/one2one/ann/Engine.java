/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.associations.one2one.ann;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity
@Table(name="ENGINE_ONE2ONE_ANN")
public class Engine {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id = 0;
    
    private String make = null;
    
    private String model = null;
    
    private String size;
    
    @OneToOne(mappedBy="engine")
    private Car car = null;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

}