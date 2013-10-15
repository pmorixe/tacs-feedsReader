package ar.edu.utn.frba.tacs.grupo1.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Domain {

  @Id
  @GeneratedValue
  private Integer id;

  private String username;

  private String password;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(name = "user_roles", joinColumns = {
    @JoinColumn(name = "user_id", referencedColumnName = "id")
  }, inverseJoinColumns = {
    @JoinColumn(name = "role_id", referencedColumnName = "id")
  })
  private Role role;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

}
