package util;

import java.util.Properties;
import model.Address;
import model.Car;
import model.Pet;
import model.PetOwner;
import model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

  public static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {

    if (sessionFactory == null) {
      /*START BOILER PLATE CODE */
      Configuration configuration = new Configuration();
      Properties settings = new Properties();
      settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

      settings.put(Environment.URL, "jdbc:mysql://localhost:3306/JDBC?serverTimezone=UTC");
      settings.put(Environment.USER, "root");
      settings.put(Environment.PASS, "password");
      settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
      settings.put(Environment.SHOW_SQL, "true");
      settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
      settings.put(Environment.HBM2DDL_AUTO, "update");

      configuration.setProperties(settings);

      configuration.addAnnotatedClass(Student.class);
      configuration.addAnnotatedClass(Car.class);
      configuration.addAnnotatedClass(Address.class);
      configuration.addAnnotatedClass(Pet.class);
      configuration.addAnnotatedClass(PetOwner.class);

      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
          .applySettings(configuration.getProperties()).build();
      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
      /*END BOILER PLATE CODE*/
    }

    return sessionFactory;
  }
}
