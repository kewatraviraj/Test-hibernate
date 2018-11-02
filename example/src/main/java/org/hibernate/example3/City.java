/**
 * 
 */
package org.hibernate.example3;

import java.lang.annotation.Target;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Dell
 *
 */
@Entity(name = "City")
public class City {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Embedded
/*	@Target( GPS.class )
	private Coordinates coordinates;
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}*/

	

}