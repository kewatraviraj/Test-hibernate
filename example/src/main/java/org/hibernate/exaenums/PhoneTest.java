/**
 * 
 */
package org.hibernate.exaenums;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Dell
 *
 */
public class PhoneTest {
	public static void main(String[] args) {
		
		Session session = new Configuration().configure("examplemapenum.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Phone phone = new Phone( );
		phone.setNumber( "123-456-78990" );
		phone.setType( PhoneType.LAND_LINE );
		session.persist( phone );
		
		t.commit();// transaction is commited

		session.close();
	}
}
