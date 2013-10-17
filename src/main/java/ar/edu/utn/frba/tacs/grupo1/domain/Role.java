package ar.edu.utn.frba.tacs.grupo1.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue
  private Integer id;

  private String role;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "user_roles", joinColumns = {
    @JoinColumn(name = "role_id", referencedColumnName = "id")
  }, inverseJoinColumns = {
    @JoinColumn(name = "user_id", referencedColumnName = "id")
  })
  private Set<MyUser> userRoles;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public Set<MyUser> getUserRoles() {
    return userRoles;
  }

  public void setUserRoles(Set<MyUser> userRoles) {
    this.userRoles = userRoles;
  }

}
