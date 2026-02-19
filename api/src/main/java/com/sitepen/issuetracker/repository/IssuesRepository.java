package com.sitepen.issuetracker.repository;

import com.sitepen.issuetracker.entity.IssueEntity;
import com.sitepen.issuetracker.repository.custom.IssuesRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuesRepository extends JpaRepository<IssueEntity, Long>, IssuesRepositoryCustom {
    List<IssueEntity> getAll();

    List<IssueEntity> getAllByProjectId(Long projectId);
}
