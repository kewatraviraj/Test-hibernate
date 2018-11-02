/**
 * 
 */
package org.hibernate.example4;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @author Dell
 *
 */
@StaticMetamodel(Employee.class)
public class Employee_ {
	public static volatile SingularAttribute<Employee, Integer> id;
	public static volatile SingularAttribute<Employee, String> ename;
	public static volatile SingularAttribute<Employee, String> deg;
	public static volatile SingularAttribute<Employee, Integer> salary;
	public static volatile SingularAttribute<Employee, List<Address>> address;
}
