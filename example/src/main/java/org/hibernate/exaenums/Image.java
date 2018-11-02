/**
 * 
 */
package org.hibernate.exaenums;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Dell
 *
 */
@Entity(name = "image")
public class Image {

	@Id
	private Integer id;

	private String name;

	@Convert(converter = CaptionConverter.class)
	private Caption caption;

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

	public Caption getCaption() {
		return caption;
	}

	public void setCaption(Caption caption) {
		this.caption = caption;
	}

	
}
