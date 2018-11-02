/**
 * 
 */
package org.hibernate.example3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.MetaValue;

/**
 * @author Dell
 *
 */
@Entity
@Table( name = "property_holder" )
public class PropertyHolder {

    @Id
    @GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
    private Long id;

    @Any(
        metaDef = "PropertyMetaDef",
        metaColumn = @Column( name = "property_type" )
    )
    @AnyMetaDef( name= "PropertyMetaDef", metaType = "string", idType = "long",
    metaValues = {
            @MetaValue(value = "S", targetEntity = StringProperty.class),
            @MetaValue(value = "I", targetEntity = IntegerProperty.class)
        }
    )
    @JoinColumn( name = "property_id" )
    private Property property;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}


}
