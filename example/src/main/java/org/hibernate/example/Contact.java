/**
 * 
 */
package org.hibernate.example;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Dell
 *
 */
@Entity(name="contact")
public class Contact {
	@Id
	private Integer id;

	private Name name;
}
