/**
 * 
 */
package org.hibernate.example3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Dell
 *
 */
public class TestAny {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = new Configuration().configure("example3.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		IntegerProperty ageProperty = new IntegerProperty();
		ageProperty.setName( "age" );
		ageProperty.setValue( 40 );

		session.persist( ageProperty );

		StringProperty nameProperty = new StringProperty();
		nameProperty.setName( "name" );
		nameProperty.setValue( "user" );
		session.persist( nameProperty );

		StringProperty nameProperty1 = new StringProperty();
		nameProperty1.setName( "name1" );
		nameProperty1.setValue( "user1" );
		session.persist( nameProperty1 );

		PropertyHolder namePropertyHolder = new PropertyHolder();
		namePropertyHolder.setProperty( nameProperty );

		PropertyHolder namePropertyHolder1 = new PropertyHolder();
		namePropertyHolder1.setProperty( nameProperty1 );

		PropertyHolder namePropertyHolder2 = new PropertyHolder();
		namePropertyHolder2.setProperty( ageProperty );
		
		session.persist( namePropertyHolder );
		session.persist( namePropertyHolder1 );
		session.persist( namePropertyHolder2 );
		
		t.commit();
		
		PropertyHolder propertyHolder = session.get( PropertyHolder.class, 1L );
		
		System.out.println(propertyHolder.getProperty().getName());
		System.out.println(propertyHolder.getProperty().getValue());
	
		PropertyHolder propertyHolder1 = session.get( PropertyHolder.class, 2L );
		System.out.println(propertyHolder1.getProperty().getValue());
		System.out.println(propertyHolder1.getProperty().getName());
	}

}
