/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.inheritance.s1;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author mkonda
 */
@Entity
@DiscriminatorValue("EXECUTIVE")
public class Executive extends Employee {

	private String role = null;

	public Executive(String name) {
		super(name);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
