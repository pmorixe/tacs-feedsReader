package ar.edu.utn.frba.tacs.grupo1.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import ar.edu.utn.frba.tacs.grupo1.domain.MyUser;
import ar.edu.utn.frba.tacs.grupo1.hibernate.HibernateUtil;

public class UsersDAO {

  private static UsersDAO instance = null;

  public static UsersDAO getInstance() {
    if (instance == null)
      return instance = new UsersDAO();
    return instance;
  }

  protected static Session getCurrentSession() {
    return HibernateUtil.getSessionFactory().getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  public MyUser getUser(String username) {
    Session session = getCurrentSession();
    List<MyUser> userList = new ArrayList<MyUser>();
    session.getTransaction().begin();
    Query query = session.createQuery("from User u where u.username = :username");
    query.setParameter("username", username);
    userList = query.list();
    session.getTransaction().commit();
    if (userList.size() > 0)
      return userList.get(0);
    else
      return null;
  }
}
