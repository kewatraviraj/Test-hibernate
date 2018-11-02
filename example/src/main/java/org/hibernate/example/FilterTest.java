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
public class FilterTest {
	public static void main(String[] args) {
		Session session = new Configuration().configure("examplemapenum.xml").buildSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		/*
		Employee employee = new Employee();
		employee.setEmployeeName("employee1");
		employee.setSalary(10000);

		Employee employee1 = new Employee();
		employee1.setEmployeeName("employee2");
		employee1.setSalary(3000);
		
		session.persist(employee);
		session.persist(employee1);
		
		t.commit();*/
		
		Filter filter = session.enableFilter("employeeFilter");
        filter.setParameter("salary", 4000);
        
		List list = session.createQuery("from employee e").list();
		
        for (Iterator<Employee> iterator1 = list.iterator(); iterator1.hasNext();){
        	Employee emp = (Employee) iterator1.next(); 
            System.out.println("User Name: " + emp.getEmployeeName()); 
        }
       
        Iterator<Employee> it =list.iterator();
        while (it.hasNext()) {
            Employee emp = (Employee) it.next();
            System.out.println("Employee Name : "+emp.getEmployeeName() +" , Salary : "+emp.getSalary());
        }    
		t.commit();
		session.close();
	}
}
