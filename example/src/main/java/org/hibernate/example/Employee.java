/**
 * 
 */
package org.hibernate.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ParamDef;

/**
 * @author Dell
 *
 */
@Entity(name = "employee")
@FilterDef(name = "employeeFilter", parameters = @ParamDef(name = "salary", type = "int"))
@Filter(name = "employeeFilter", condition = "salary >:salary")
public class Employee {
	
	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "id", strategy="increment")
    private int employeeId;
    
	@Column(name = "ename")
    private String employeeName;
	
    @Column(name = "salary")
    private int salary;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
