/**
 * 
 */
package org.hibernate.example;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.example.Account;
import org.hibernate.example.AccountType;
import org.hibernate.example.Client;


/**
 * @author Dell
 *
 */
public class TestAccountWhere {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = new Configuration().configure("examplemapenum.xml").buildSessionFactory().openSession();
		
	/*	Transaction t = session.beginTransaction();	
		
		Client client = new Client();
		client.setName( "John Doe" );
		session.persist( client );

		Account account1 = new Account( );
		account1.setType( AccountType.CREDIT );
		account1.setAmount( 5000d );
		account1.setRate( 1.25 / 100 );
		account1.setActive( true );
		account1.setClient( client );
		client.getCreditAccounts().add( account1 );
		session.persist( account1 );

		Account account2 = new Account( );
		account2.setType( AccountType.DEBIT );
		account2.setAmount( 0d );
		account2.setRate( 1.05 / 100 );
		account2.setActive( false );
		account2.setClient( client );
		client.getDebitAccounts().add( account2 );
		session.persist( account2 );

		Account account3 = new Account( );
		account3.setType( AccountType.DEBIT );
		account3.setAmount( 250d );
		account3.setRate( 1.05 / 100 );
		account3.setActive( true );
		account3.setClient( client );
		client.getDebitAccounts().add( account3 );
		session.persist( account3 );
		
		t.commit();
		*/
		List<Account> accounts = session.createQuery(
				"select a from accounting a", Account.class)
			.getResultList();
		for (Iterator<Account> iterator1 = accounts.iterator(); iterator1.hasNext();){
			Account account = (Account) iterator1.next(); 
	           System.out.println("Name: " + account.getClient().getName()); 
	           System.out.println("Amount: " + account.getAmount()); 
	           System.out.println("Rate: " + account.getRate()); 
	           System.out.println("Type: " + account.getType());  
	          
	        }
		session.close();
	}

}
