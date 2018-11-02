/**
 * 
 */
package org.hibernate.example2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Dell
 *
 */
public class Testing {

	public static void main(String[] args) {
		// creating configuration object
	//	Configuration cfg = new Configuration();
	//	cfg.configure("testing.xml");     // populates the data of the configuration file

		// creating seession factory object
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session session = factory.openSession();
		
		Session session = new Configuration().configure("testing.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Movie e1 = new Movie();
		
	//	e1.setId(3);
		e1.setFirstName("user");
		e1.setLastName("name");
		e1.setAge(25);

		session.persist(e1);// persisting the object

		t.commit();// transaction is commited

		session.close();
		System.out.println("successfully saved");
	}
}
