package ar.edu.utn.frba.tacs.grupo1.daos;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import ar.edu.utn.frba.tacs.grupo1.domain.Domain;
import ar.edu.utn.frba.tacs.grupo1.hibernate.HibernateUtil;

public class EntryDAO {

  private static EntryDAO instance = null;

  public static EntryDAO getInstance() {
    if (instance == null)
      return instance = new EntryDAO();
    return instance;
  }

  protected static Session getCurrentSession() {
    return HibernateUtil.getSessionFactory().getCurrentSession();
  }

  /**
   * @param domainObject
   * @throws HibernateException
   */
  public int save(Domain domainObject) throws HibernateException {
    Session session = getCurrentSession();
    session.beginTransaction();
    session.saveOrUpdate(domainObject);
    session.getTransaction().commit();
    return domainObject.getId();
  }

  /**
   * @param domainObject
   * @throws HibernateException
   */
  public void delete(Domain domainObject) throws HibernateException {
    Session session = getCurrentSession();
    session.beginTransaction();
    session.delete(domainObject);
    session.getTransaction().commit();
  }

  public static List<?> list(@SuppressWarnings("rawtypes") Class domainClass) {
    String className = domainClass.getName();
    Session session = getCurrentSession();
    session.getTransaction().begin();
    List<?> result = (List<?>) session.createQuery("from " + className).list();
    session.getTransaction().commit();
    return result;
  }

  public Object getById(@SuppressWarnings("rawtypes") Class domainClass, int id) {
    String className = domainClass.getName();
    Session session = getCurrentSession();
    session.getTransaction().begin();
    List<?> allResults = session.createQuery("from " + className + " where id=" + String.valueOf(id)).list();
    session.getTransaction().commit();
    if (allResults.size() > 0)
      return allResults.get(0);
    return null;
  }

  public List<?> getByFilter(@SuppressWarnings("rawtypes") Class domainClass, Method method, int valueRequired) {
    String className = domainClass.getSimpleName();
    String field = method.getName().replaceFirst("get", "").toLowerCase();
    Session session = getCurrentSession();
    session.getTransaction().begin();
    List<?> allResults = session.createQuery(
        "from " + className + " where " + field + "=" + String.valueOf(valueRequired)).list();
    session.getTransaction().commit();
    if (allResults.size() > 0)
      return allResults;
    return null;
  }

}
