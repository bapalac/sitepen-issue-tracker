package com.sitepen.issuetracker.repository.custom;

import com.sitepen.issuetracker.entity.IssueEntity;

import java.util.List;

public interface IssuesRepositoryCustom {
    List<IssueEntity> getAll();
}
