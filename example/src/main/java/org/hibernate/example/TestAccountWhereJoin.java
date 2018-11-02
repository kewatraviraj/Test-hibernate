/**
 * 
 */
package org.hibernate.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Dell
 *
 */
public class TestAccountWhereJoin {
	public static void main(String[] args) {

		Session session = new Configuration().configure("examplemapenum.xml").buildSessionFactory().openSession();

		Transaction t = session.beginTransaction();

		Book book = new Book();
		book.setTitle("High-Performance Java Persistence");
		book.setAuthor("Vad Mihalcea");
		session.persist(book);

		Book book1 = new Book();
		book1.setTitle("High Java");
		book1.setAuthor("Mihalcea");
		session.persist(book1);

		Reader reader1 = new Reader();
		reader1.setName("John Doe");
		session.persist(reader1);

		Reader reader2 = new Reader();
		reader2.setName("John Doe Jr.");
		session.persist(reader2);

		t.commit();

		session.close();

	}
}
