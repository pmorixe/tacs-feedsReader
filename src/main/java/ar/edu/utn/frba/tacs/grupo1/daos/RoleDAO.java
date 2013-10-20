package ar.edu.utn.frba.tacs.grupo1.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.utn.frba.tacs.grupo1.domain.Role;

@Repository
public class RoleDAO {

  @Autowired
  private SessionFactory sessionFactory;

  private static RoleDAO instance = null;

  public static RoleDAO getInstance() {
    if (instance == null)
      return instance = new RoleDAO();
    return instance;
  }

  @Transactional
  public Role getRole(int id) {
    Session session = sessionFactory.getCurrentSession();
    Role role = (Role) session.load(Role.class, id);
    return role;
  }
}
