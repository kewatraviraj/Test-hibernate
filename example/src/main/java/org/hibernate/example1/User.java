/**
 * 
 */
package org.hibernate.example1;

import java.util.List;

/**
 * @author Dell
 *
 */
public class User {
	private int userId;
    private String username;
    private List<Address> address;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
    
}
