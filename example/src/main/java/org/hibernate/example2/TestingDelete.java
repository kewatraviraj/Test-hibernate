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
public class TestingDelete {
	
	static Session session = new Configuration().configure("testing.xml").buildSessionFactory().openSession();
	
	static Transaction t = session.beginTransaction();
	
	static int delete(int id) {
		try { 
			Movie e1 = session.get(Movie.class, id);
			session.delete(e1); 
			
	        t.commit();
		}catch (HibernateException e) {
	         if (t!=null) t.rollback();
	         e.printStackTrace(); 
	    }finally {
	         session.close(); 
	    }
       return id;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	      
	   System.out.println("Deleted data of id :"+ delete(0));
//	   session.createQuery("delete from test_table where id=:id").setInteger("id", 2).executeUpdate();
	}
}
