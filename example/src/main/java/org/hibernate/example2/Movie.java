/**
 * 
 */
package org.hibernate.example2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Dell
 *
 */
@Entity(name="test_table")
public class Movie {
	private int id;
	private String firstName, lastName;
	private Integer age;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column (name ="fname") 
	public String getFirstName() { 
		return firstName; 
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName; 
	}

	@Column (name = "lName") 
	public String getLastName() { 
		return lastName; 
	}

	public void setLastName(String lastName) { 
		this.lastName = lastName; 
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
