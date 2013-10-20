package ar.edu.utn.frba.tacs.grupo1.daos;

import ar.edu.utn.frba.tacs.grupo1.domain.MyUser;

public class UsersDAOTest {

  // @Test
  public void test() {
    MyUser user = UsersDAO.getInstance().getUser("admin");
    System.out.println("Username: " + user.getUsername());
    System.out.println("Password: " + user.getPassword());
  }

}
