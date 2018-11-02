/**
 * 
 */
package org.hibernate.example2;

import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

/**
 * @author Dell
 *
 */
public class TestingFetch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = new Configuration().configure("testing.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
	    
/*		List<TestTable> users = session.createCriteria(TestTable.class).add(Restrictions.like("firstName","us%",MatchMode.EXACT)).list(); 
        for (Iterator<TestTable> iterator1 = users.iterator(); iterator1.hasNext();){
           TestTable user = (TestTable) iterator1.next(); 
           System.out.println("User Name: " + user.getFirstName()); 
           System.out.println("User last: " + user.getLastName());
           System.out.println("User age: " + user.getAge()); 
        }
*/
/*        List<TestTable> users = session.createCriteria(TestTable.class).add(Restrictions.or(Restrictions.gt("age",20),Restrictions.eq("firstName","user1"),Restrictions.eq("firstName","usersecond"))).list(); 
        for (Iterator<TestTable> iterator1 = users.iterator(); iterator1.hasNext();){
        	TestTable user = (TestTable) iterator1.next(); 
        	System.out.println("User Name: " + user.getFirstName()); 
        	System.out.println("User last: " + user.getLastName());
        	System.out.println("User age: " + user.getAge()); 
        }
*/
		List<Movie> users = session.createCriteria(Movie.class).add(Restrictions.gt("age",20)).addOrder(Property.forName("firstName").asc()).addOrder(Property.forName("age").desc()).list(); 
        for (Iterator<Movie> iterator1 = users.iterator(); iterator1.hasNext();){
        	Movie user = (Movie) iterator1.next(); 
        	System.out.println("User Name: " + user.getFirstName()); 
        	System.out.println("User last: " + user.getLastName());
        	System.out.println("User age: " + user.getAge()); 
        }
		
		t.commit();
		session.close();
	}

}
