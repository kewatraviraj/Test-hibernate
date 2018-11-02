/**
 * 
 */
package org.hibernate.exaenums;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Dell
 *
 */
@Entity(name = "Product")
public class Product {

    @Id
	@GeneratedValue(generator="increment")
    @GenericGenerator(name="increment",strategy="increment")
    private Integer id;

    private String name;

    @Lob
    private Blob image;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

    

}
