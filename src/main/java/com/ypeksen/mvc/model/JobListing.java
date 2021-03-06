package com.ypeksen.mvc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="JobListing")
@Table(name="JOB_LISTING")
public class JobListing {

	private long id;
	
	private User user;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId(){
		return id;
	}
	
  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "user_id")
  public User getUser() {
      return user;
  }
  
	public void setUser(User user) {
		this.user = user;
	}
}
