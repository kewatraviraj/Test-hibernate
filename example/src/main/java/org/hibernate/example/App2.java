/**
 * 
 */
package org.hibernate.example;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Dell
 *
 */
public class App2 {
	public static void main(String[] args) {
		
		Session session = new Configuration().configure("examplemapenum.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		/*App app1 = new App();
		app1.setAmount(4559.00);
		app1.setRate(66.00);
		app1.setActive(false);
		session.persist(app1);		

		App app2 = new App();
		app2.setAmount(10000.00);
		app2.setRate(50.00);
		app2.setActive(true);
		session.persist(app2);
		*/
		/*App app3 = session.get(App.class, (long)1);
		app3.setDeleted(true);
		session.update(app3);
		*/
		t.commit();
		
		
		session.unwrap( Session.class )
		.enableFilter( "activeApp" )
		.setParameter( "active", true);

		List<App> apps = session.createQuery(
			"select a from app a", App.class)
		.getResultList();
		
		for(Iterator<App> iterate = apps.iterator(); iterate.hasNext();) {
			App app = iterate.next();
			System.out.println(app.getAmount());
			System.out.println(app.getRate());
		}

	}
}
