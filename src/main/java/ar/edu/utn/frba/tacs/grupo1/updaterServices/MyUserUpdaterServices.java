package ar.edu.utn.frba.tacs.grupo1.updaterServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.utn.frba.tacs.grupo1.daos.RoleDAO;
import ar.edu.utn.frba.tacs.grupo1.daos.UsersDAO;
import ar.edu.utn.frba.tacs.grupo1.domain.MyUser;
import ar.edu.utn.frba.tacs.grupo1.domain.Role;

@Service
public class MyUserUpdaterServices {

  @Autowired
  private UsersDAO UsersDAO;

  private static MyUserUpdaterServices instance = null;

  public static MyUserUpdaterServices getInstance() {
    if (instance == null)
      return instance = new MyUserUpdaterServices();
    return instance;
  }

  private boolean validateUser(MyUser newUser) {
    return UsersDAO.getUser(newUser.getUsername()) == null;
  }

  private String registerUser(MyUser newUser) {
    UsersDAO.registerUser(newUser);
    return newUser.getUsername();
  }

  public String validateAndRegisterUser(MyUser newUser) {
    if (validateUser(newUser)) {
      int roleAdminId = 5;
      Role role = RoleDAO.getInstance().getRole(roleAdminId);
      newUser.setRole(role);
      registerUser(newUser);
      return newUser.getUsername();
    }
    return null;
  }

}
