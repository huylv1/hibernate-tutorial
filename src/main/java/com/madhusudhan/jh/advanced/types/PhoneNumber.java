/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhusudhan.jh.advanced.types;

import java.io.Serializable;

/**
 *
 * @author mkonda
 */
public class PhoneNumber implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 3708149682041927168L;
	private int countryCode;
    private int localCode;
    private String country;
    
    
    
    public PhoneNumber() {
	}

	public PhoneNumber(int countryCode, int localCode, String country) {
		this.countryCode = countryCode;
		this.localCode = localCode;
		this.country = country;
	}
	
	/**
	 * @return the countryCode
	 */
	public int getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the localCode
	 */
	public int getLocalCode() {
		return localCode;
	}

	/**
	 * @param localCode the localCode to set
	 */
	public void setLocalCode(int localCode) {
		this.localCode = localCode;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}