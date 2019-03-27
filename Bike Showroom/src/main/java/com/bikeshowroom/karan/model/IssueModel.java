package com.bikeshowroom.karan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="issue")
public class IssueModel {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int issue_id;
	
	@Column(name = "issueDetails", nullable = false,length=255)
	private String issueDetails;
	
	@Column(name = "staffName", nullable = false,length=50)
	private String staffName;

	public int getIssue_id() {
		return issue_id;
	}

	public void setIssue_id(int issue_id) {
		this.issue_id = issue_id;
	}

	public String getIssueDetails() {
		return issueDetails;
	}

	public void setIssueDetails(String issueDetails) {
		this.issueDetails = issueDetails;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	
}
