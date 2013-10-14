package ar.edu.utn.frba.tacs.grupo1.daos;

import org.hibernate.Session;

import ar.edu.utn.frba.tacs.grupo1.domain.Role;
import ar.edu.utn.frba.tacs.grupo1.hibernate.HibernateUtil;

public class RoleDAO {

  private static RoleDAO instance = null;

  public static RoleDAO getInstance() {
    if (instance == null)
      return instance = new RoleDAO();
    return instance;
  }

  protected static Session getCurrentSession() {
    return HibernateUtil.getSessionFactory().getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  public Role getRole(int id) {
    Session session = getCurrentSession();
    session.getTransaction().begin();
    Role role = (Role) session.load(Role.class, id);
    session.getTransaction().commit();
    return role;
  }
}
