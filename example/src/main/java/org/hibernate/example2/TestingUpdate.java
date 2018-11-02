/**
 * 
 */
package org.hibernate.example2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Dell
 *
 */
public class TestingUpdate {
	
	static Session session = new Configuration().configure("testing.xml").buildSessionFactory().openSession();
	
	static Transaction t = session.beginTransaction();
	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		try {   
			Movie e1 = session.get(Movie.class, 2);
			e1.setFirstName("user");
			session.update(e1); 
			
			/*session.createQuery("update test_table set fname=:fname where id=:id").setString("fname","user1").setInteger("id", 1)
			.executeUpdate();
	       */
	        t.commit();
	        
		}catch (HibernateException e) {
	         if (t!=null) t.rollback();
	         e.printStackTrace(); 
	    }finally {
	         session.close(); 
	    }
	}
}
