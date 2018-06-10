package com.ypeksen.mvc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Job")
@Table(name="JOB")
public class Job {

	private Long id;
	
	private JobListing jobListing;
	
	private String title;
	
	private String description;
	
	private int hiringPersonNumber;
	
	private Date lastApplicationDate;

	@Id
  @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "job_listing_id")
	public JobListing getJobListing() {
		return jobListing;
	}

	public void setJobListing(JobListing jobListing) {
		this.jobListing = jobListing;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="hiring_person_number")
	public int getHiringPersonNumber() {
		return hiringPersonNumber;
	}

	public void setHiringPersonNumber(int hiringPersonNumber) {
		this.hiringPersonNumber = hiringPersonNumber;
	}
	
	@Column(name = "last_application_date", columnDefinition="TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
  public Date getLastApplicationDate() {
		return lastApplicationDate;
	}

	public void setLastApplicationDate(Date lastApplicationDate) {
		this.lastApplicationDate = lastApplicationDate;
	}
}
