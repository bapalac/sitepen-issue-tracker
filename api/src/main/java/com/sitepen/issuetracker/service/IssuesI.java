package com.sitepen.issuetracker.service;

import com.sitepen.issuetracker.dto.IssueDto;

import java.util.List;

public interface IssuesI {
    public List<IssueDto> getAll();

    public IssueDto getByIssueId(Long issueId);

    public List<IssueDto> getAllByProjectId(Long projectId);
}
