/**
 * 
 */
package org.hibernate.example4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author Dell
 *
 */
public class CreateEmployee {

	   public static void main( String[ ] args ) {
	   
	      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "_JPA" );	      
	      EntityManager entitymanager = emfactory.createEntityManager( );
	      entitymanager.getTransaction( ).begin( );
	      
	    /*  Address address = new Address();
	      address.setE_city("city");
	      address.setE_state("state");
	      address.setE_pincode(452625);
	      
	      Employee employee = new Employee( );
	      employee.setEname( "Employee2" );
	      employee.setSalary( 45000 );
	      employee.setDeg( "2Manager" );
	      employee.getAddress().add(address);
	      
	      entitymanager.persist( employee );
	      */
	      
	      /*Employee employee =entitymanager.find(Employee.class,3);  
	        System.out.println("id = "+employee.getEid());  
	        System.out.println("Name = "+employee.getEname());  
	        System.out.println("Deg = "+employee.getDeg());
	        System.out.println("Salary ="+employee.getSalary());
	      */
	       
	      CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
	      CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
	      Root<Employee> root = criteriaQuery.from(Employee.class);
	     
	      
	      CriteriaQuery<Object> select = criteriaQuery.select(root);   
	      
/*	      //select all records
	      TypedQuery<Object> typedQuery = entitymanager.createQuery(select);
	      List<Object> resultlist = typedQuery.getResultList();
*/		
	      
/*	      //select by Order
	      select.orderBy(criteriaBuilder.asc(root.get("ename")));
	      List<Object> resultlist = entitymanager.createQuery(select).getResultList();

	      for(Object o:resultlist) {
	    	  Employee e = (Employee)o;
	    	  System.out.println("EID : " + e.getEid() + " Ename : " + e.getEname());
	      }
*/	      
	      criteriaQuery.where( criteriaBuilder.equal( root.get( Employee_.ename ), "abc" ) );
	      List<Object> employee = entitymanager.createQuery( criteriaQuery ).getResultList();
	      
	      System.out.println(employee);
	      
	       entitymanager.getTransaction( ).commit( );
		   entitymanager.close( );
		   emfactory.close( );
	   }
	   
	}
