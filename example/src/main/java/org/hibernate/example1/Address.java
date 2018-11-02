/**
 * 
 */
package org.hibernate.example1;

/**
 * @author Dell
 *
 */
public class Address {
	private int addId;
	private String add1;
	private String add2;
	
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	public int getAddId() {
		return addId;
	}
	public void setAddId(int addId) {
		this.addId = addId;
	}
}
