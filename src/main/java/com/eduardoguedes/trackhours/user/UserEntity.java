package com.eduardoguedes.trackhours.user;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "usr_id")
  private Integer id;

  @Column(name = "tnt_id")
  private Integer tenantId;

  @Column(name = "usr_name")
  private String name;

  @Column(name = "usr_email")
  private String email;

  @Column(name = "usr_password")
  private String password;

  public UserEntity() {
  }

  public UserEntity(Integer id, Integer tenantId, String name, String email, String password) {
    this.id = id;
    this.tenantId = tenantId;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTenantId() {
    return tenantId;
  }

  public void setTenantId(Integer tenantId) {
    this.tenantId = tenantId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {

    this.password = password;
  }

}
