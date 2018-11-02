/**
 * 
 */
package org.noxml.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.cfgxml.spi.MappingReference;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

/**
 * @author Dell
 *
 */
public class HibernateUtil {
	private static StandardServiceRegistry registry;
	   private static SessionFactory sessionFactory;

	   public static SessionFactory getSessionFactory() {
	      if (sessionFactory == null) {
	         try {

	            // Create registry builder
	            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

	            // Hibernate settings equivalent to hibernate.cfg.xml's properties
	            Map<String, String> settings = new HashMap<>();
	            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
	            settings.put(Environment.URL, "jdbc:mysql://localhost:3306/noxml");
	            settings.put(Environment.USER, "root");
	            settings.put(Environment.PASS, "root");
	            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
	            settings.put(Environment.HBM2DDL_AUTO, "update");
	            settings.put(Environment.SHOW_SQL, "true");	            
	            
	            // Apply settings
	            registryBuilder.applySettings(settings);

	            // Create registry
	            registry = registryBuilder.build();

	            // Create MetadataSources
	            MetadataSources sources = new MetadataSources(registry);

	            // Create Metadata
	            Metadata metadata = sources.addAnnotatedClass(Employee.class).getMetadataBuilder().build();

	            // Create SessionFactory
	            sessionFactory = metadata.getSessionFactoryBuilder().build();

	         } catch (Exception e) {
	            e.printStackTrace();
	            shutdown();
	         }
	      }
	      return sessionFactory;
	   }

	   public static void shutdown() {
	      if (registry != null) {
	         StandardServiceRegistryBuilder.destroy(registry);
	      }
	   }

	   
	   
}
