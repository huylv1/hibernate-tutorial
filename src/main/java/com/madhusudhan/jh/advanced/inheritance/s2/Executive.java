/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s2;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Objects;

/**
 *
 * @author mkonda
 */
@Entity(name="INHERITANCE_S2_EXECUTIVE_ANN")
@PrimaryKeyJoinColumn(name="EMPLOYEE_ID")
public class Executive extends Employee{
    private String role = null;
    
    public Executive(String name){
        super(name);
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Executive)) {
			return false;
		}
		Executive castOther = (Executive) other;
		return Objects.equals(role, castOther.role);
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(role);
	}
    
    
}
