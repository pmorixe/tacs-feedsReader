package ar.edu.utn.frba.tacs.grupo1.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frba.tacs.grupo1.domain.MyUser;

@Repository
@SuppressWarnings({
  "unchecked"
})
public class UsersDAO {

  @Autowired
  private SessionFactory sessionFactory;

  private static UsersDAO instance = null;

  public static UsersDAO getInstance() {
    if (instance == null)
      return instance = new UsersDAO();
    return instance;
  }

  @Transactional
  public MyUser getUser(String username) {
    Session session = sessionFactory.getCurrentSession();
    List<MyUser> userList = new ArrayList<MyUser>();
    Query query = session.createQuery("from MyUser u where u.username = :username");
    query.setParameter("username", username);
    userList = query.list();
    if (userList.size() > 0)
      return userList.get(0);
    else
      return null;
  }

  @Transactional
  public void registerUser(MyUser newUser) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(newUser);
  }
}
