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
public class TestAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = new Configuration().configure("examplemapenum.xml").buildSessionFactory().openSession();
		
		/*Transaction t = session.beginTransaction();
		
		Account account = new Account();
		account.setCredit(10.00);
		account.setRate(2.00);
		
		session.persist(account);
		t.commit();*/
		
		Account d=  (Account)session.get(Account.class,new Long(3));    
        
        System.out.println("Total Interest :"+d.getInterest());
		session.close();
	}

}
