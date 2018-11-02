package org.noxml.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction= session.beginTransaction();
        
        Employee employee = new Employee();
        employee.setFirstName("firstName");
        employee.setLastName("lastName");
        employee.setSalary(52359);
        
        session.persist(employee);
        transaction.commit();
        
        session.close();
        
        HibernateUtil.shutdown();
    }
}
