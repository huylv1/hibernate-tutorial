package com.madhusudhan.jh.collections.map;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SHOWROOM_MAP_XX")
public class Showroom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="SHOWROOM_ID")
	private int id = 0;
	
    private String manager = null;
    private String location = null;
    
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="CARS_MAP_XX",
    		joinColumns=@JoinColumn(name="SHOWROOM_ID"),
    		inverseJoinColumns=@JoinColumn(name="CAR_ID"))
    @MapKeyColumn(name="CUST_NAME")
    private Map<String, Car> cars = null;

    public Showroom(){
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Car> getCars() {
        return cars;
    }

    public void setCars(Map<String, Car> cars) {
        this.cars = cars;
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

    @Override
    public String toString() {
        return "Showroom{" + "id=" + id + ", manager=" + manager + ", location=" + location + ", cars=" + cars + '}';
    }
}
