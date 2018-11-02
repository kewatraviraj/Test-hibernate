/**
 * 
 */
package org.hibernate.exaenums;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;

/**
 * @author Dell
 *
 */
public class TestConverter {
	public static void main(String[] args) {
	Session session = new Configuration().configure("examplemapenum.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		byte[] image = new byte[] {1, 2, 3};
		/*Image image = new Image();
		image.setName("image1");*/
		
		Product product = new Product();
		product.setName("image");
		product.setImage( BlobProxy.generateProxy( image ) );
		
		session.persist(product);
		t.commit();
		session.close();
	}
}
