/**
 * 
 */
package org.hibernate.example;

import javax.persistence.Embeddable;

/**
 * @author Dell
 *
 */
@Embeddable
public class Name {
	private String firstname;
	private String lastname;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}