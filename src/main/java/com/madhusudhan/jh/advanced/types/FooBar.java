package com.madhusudhan.jh.advanced.types;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "FOO_BAR")
@TypeDefs({
    @TypeDef(name = JaNeeType.NAME, typeClass = JaNeeType.class)
})
public class FooBar implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8887188386597572198L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "FOO_INDICATOR")
	@Type(type = JaNeeType.NAME)
    private Boolean fooIndicator;
 
	@Column(name = "BAR_INDICATOR", length = 2)
    @Type(type = JaNeeType.NAME, parameters = { @Parameter(name = "length", value = "2") })
    private Boolean barIndicator;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the fooIndicator
	 */
	public Boolean getFooIndicator() {
		return fooIndicator;
	}

	/**
	 * @param fooIndicator the fooIndicator to set
	 */
	public void setFooIndicator(Boolean fooIndicator) {
		this.fooIndicator = fooIndicator;
	}

	/**
	 * @return the barIndicator
	 */
	public Boolean getBarIndicator() {
		return barIndicator;
	}

	/**
	 * @param barIndicator the barIndicator to set
	 */
	public void setBarIndicator(Boolean barIndicator) {
		this.barIndicator = barIndicator;
	}
    
}
