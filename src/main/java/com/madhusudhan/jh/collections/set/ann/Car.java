package com.madhusudhan.jh.collections.set.ann;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mkonda
 */
@Entity(name="CAR_SET_ANN_JOINTABLE")
@Table(name="CAR_SET_ANN_JOINTABLE")
public class Car {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name = null;
    private String color = null;

    public Car(){
        
    }
    public Car(String name, String color){
        setName(name);
        setColor(color);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 67 * hash + (this.color != null ? this.color.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.color == null) ? (other.color != null) : !this.color.equals(other.color)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", name=" + name + ", color=" + color + '}';
    }
}