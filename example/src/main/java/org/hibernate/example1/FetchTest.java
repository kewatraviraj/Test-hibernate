/**
 * 
 */
package org.hibernate.example1;

import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Dell
 *
 */
public class FetchTest {
	
	
	public static void main(String[] args) {   
		
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
	    
		List<Object> users = session.createQuery("select u.username from User u").list(); 
        for (Iterator<Object> iterator1 = users.iterator(); iterator1.hasNext();){
           Object user = (Object) iterator1.next(); 
           System.out.print("User Name: " + user); 
          /* System.out.print("User Name: " + user.getAge()); 
           
           List<Address> addresses = user.getAddress();
           for (Iterator<Address> iterator2 = addresses.iterator(); iterator2.hasNext();){
              Address address = (Address) iterator2.next(); 
              System.out.println("Addressline1: " + address.getAdd1()); 
              System.out.println("Addressline2: " + address.getAdd2()); 
           }*/
        }
  
        t.commit();
        
	   /* List<User> list= session.createQuery("from User").list();    
	        
	    Iterator<User> itr=list.iterator();    
	    while(itr.hasNext()){    
	        User q = itr.next();    
	        System.out.println("User Name: "+q.getUsername());    
	            
	        //printing answers    
	        List<Address> list2=q.getAddress();    
	        Iterator<Address> itr2=list2.iterator();    
	       while(itr2.hasNext())  
	       {  
	        Address a=itr2.next();  
	            System.out.println(a.getAdd1()+":"+a.getAdd2());  
	        }    
	    }  
        t.commit();
	    */
	    session.close();    
	    System.out.println("success");    
	}    
}
