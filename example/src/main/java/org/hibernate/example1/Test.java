/**
 * 
 */
package org.hibernate.example1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

/**
 * @author Dell
 *
 */
public class Test {
	public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();

        Address address = new Address();
        address.setAdd1("addressline1");
        address.setAdd2("addressline2");
        
        Address address1 =new Address();
        address1.setAdd1("address1");
        address1.setAdd2("address2");
        
        Address address2 =new Address();
        address2.setAdd1("address3");
        address2.setAdd2("address4");
        
        User user = new User();
        
        List<Address> addressdes = new ArrayList<Address>();
        addressdes.add(address);
        addressdes.add(address1);
        addressdes.add(address2);
        
        user.setAddress(addressdes);
        user.setUsername("user1");
        
        session.save(user);
        session.getTransaction().commit();
        session.close();
        
    }
}	
