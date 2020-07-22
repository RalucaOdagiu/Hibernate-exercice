package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class GenericDao<T> {

  private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

  public void saveEntity(T entity) {

    Session session = sessionFactory.openSession();

    Transaction transaction = session.beginTransaction();
    session.save(entity);
    transaction.commit();
    session.close();
  }

  public T find(Class<T> tClass, long id) {

    Session session = sessionFactory.openSession();
    return session.find(tClass, id);
  }

//  public T find(long id) {
//    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//    Session session = sessionFactory.openSession();
//    return session.find(Student.class, id);
//  }


}
