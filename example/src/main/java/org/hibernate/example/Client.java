/**
 * 
 */
package org.hibernate.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;
import org.hibernate.example.Account;

/**
 * @author Dell
 *
 */
@Entity(name = "client")
public class Client {

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment",strategy="increment")
	private Long id;

	private String name;

	@Where( clause = "account_type = 'DEBIT'")
	@OneToMany(mappedBy = "client")
	private List<Account> debitAccounts = new ArrayList<Account>( );

	@Where( clause = "account_type = 'CREDIT'")
	@OneToMany(mappedBy = "client")
	private List<Account> creditAccounts = new ArrayList<Account>( );

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getDebitAccounts() {
		return debitAccounts;
	}

	public void setDebitAccounts(List<Account> debitAccounts) {
		this.debitAccounts = debitAccounts;
	}

	public List<Account> getCreditAccounts() {
		return creditAccounts;
	}

	public void setCreditAccounts(List<Account> creditAccounts) {
		this.creditAccounts = creditAccounts;
	}

}
