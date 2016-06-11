/**
 * 
 */
package com.madhusudhan.jh.advanced.cache;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.google.common.base.MoreObjects;

/**
 * @author Huy
 *
 */
@Entity(name="person")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL, region="person")
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) //work with infinispan only ??
public class Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
    private String firstName = null;
    private String lastName = null;
    private String nickName = null;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("id", id).add("firstName", firstName).add("lastName", lastName)
				.add("nickName", nickName).toString();
	}
    
}
