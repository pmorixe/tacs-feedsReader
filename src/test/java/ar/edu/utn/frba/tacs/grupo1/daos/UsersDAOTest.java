package ar.edu.utn.frba.tacs.grupo1.daos;

import static junit.framework.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.utn.frba.tacs.grupo1.domain.MyUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
  "classpath:/servlet-Test-context.xml"
})
public class UsersDAOTest {

  @Autowired
  private UsersDAO usersDAO;

  @Test
  public void testUsersDAOBringsCorrectUser() {
    MyUser user = usersDAO.getUser("admin");
    assertTrue("admin".equals(user.getUsername()));
  }
}
