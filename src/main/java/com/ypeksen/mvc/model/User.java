package com.ypeksen.mvc.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="USER")
@Table(name="USER")
public class User {

	//Eger burada field tanimi yapildiysa, o tablonunda sorgusu yapiliyor. Bidirectional degilse, tabloya sorgu yapilmiyor.
	
	private Long id;
	
	private String email;
	
	private String password;
	
	private Timestamp creationDate;
	
	private Set<Role> roles;
	
	private boolean authenticated;
	
	private String passwordConfirm;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
  public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	public void setPassword(String password) {
		this.password = password;		
	}
	
	public Timestamp getCreationDate(){
		return creationDate;
	}
	
	public void setCreationDate(Timestamp creationDate){
		this.creationDate = creationDate;
	}

	@Transient
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
  public Set<Role> getRoles() {
      return roles;
  }
  
  public void setRoles(Set<Role> roles) {
      this.roles = roles;
  }

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}
