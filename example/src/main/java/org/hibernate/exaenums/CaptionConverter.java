/**
 * 
 */
package org.hibernate.exaenums;

import javax.persistence.AttributeConverter;

/**
 * @author Dell
 *
 */
public class CaptionConverter implements AttributeConverter<Caption, String> {

	public String convertToDatabaseColumn(Caption attribute) {
		return attribute.getText();
	}

	public Caption convertToEntityAttribute(String dbData) {
		return new Caption(dbData);
	}
}
