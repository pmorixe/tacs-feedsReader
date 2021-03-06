package ar.edu.utn.frba.tacs.grupo1.daos;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frba.tacs.grupo1.domain.Domain;

@Repository
@SuppressWarnings({
  "rawtypes"
})
public class DAO {

  @Autowired
  private SessionFactory sessionFactory;

  private static DAO instance = null;

  public static DAO getInstance() {
    if (instance == null)
      return instance = new DAO();
    return instance;
  }

  /**
   * @param domainObject
   * @throws HibernateException
   */
  @Transactional
  public int save(Domain domainObject) throws HibernateException {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(domainObject);
    return domainObject.getId();
  }

  /**
   * @param domainObject
   * @throws HibernateException
   */
  @Transactional
  public void delete(Domain domainObject) throws HibernateException {
    Session session = sessionFactory.getCurrentSession();
    session.delete(domainObject);
  }

  @Transactional
  public List<?> list(Class domainClass) {
    String className = domainClass.getName();
    Session session = sessionFactory.getCurrentSession();
    List<?> result = (List<?>) session.createQuery("from " + className).list();
    return result;
  }

  @Transactional
  public Object getById(Class domainClass, int id) {
    String className = domainClass.getName();
    Session session = sessionFactory.getCurrentSession();
    List<?> allResults = session.createQuery("from " + className + " where id=" + String.valueOf(id)).list();
    if (allResults.size() > 0)
      return allResults.get(0);
    return null;
  }

  @Transactional
  public List<?> getByFilter(Class domainClass, Method method, int valueRequired) {
    String className = domainClass.getSimpleName();
    String field = method.getName().replaceFirst("get", "").toLowerCase();
    Session session = sessionFactory.getCurrentSession();
    List<?> allResults = session.createQuery(
        "from " + className + " where " + field + "=" + String.valueOf(valueRequired)).list();
    if (allResults.size() > 0)
      return allResults;
    return null;
  }

}
