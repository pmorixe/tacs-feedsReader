package ar.edu.utn.frba.tacs.grupo1.daos;

import org.junit.Test;

import ar.edu.utn.frba.tacs.grupo1.domain.User;

public class UsersDAOTest {

  @Test
  public void test() {
    User user = UsersDAO.getInstance().getUser("admin");
    System.out.println("Username: " + user.getUsername());
    System.out.println("Password: " + user.getPassword());
  }

}
