package com.bikeshowroom.karan.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bikeshowroom.karan.model.IssueModel;


public interface issueDaos {
	public void addIssue( IssueModel issuemodel);
	public List<IssueModel> getAllIssue();
}
