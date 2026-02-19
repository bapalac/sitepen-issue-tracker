package com.sitepen.issuetracker.service.implementation;

import com.sitepen.issuetracker.dto.IssueDto;
import com.sitepen.issuetracker.entity.IssueEntity;
import com.sitepen.issuetracker.repository.IssuesRepository;
import com.sitepen.issuetracker.service.IssuesI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IssuesImpl implements IssuesI {
    private final IssuesRepository issuesRepository;

    @Autowired
    public IssuesImpl(IssuesRepository issuesRepository) {
        this.issuesRepository = issuesRepository;
    }

    @Override
    public List<IssueDto> getAll() {
        List<IssueEntity> issueEntityList = issuesRepository.getAll();
        return issueEntityList.stream().map(IssueDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public IssueDto getByIssueId(Long issueId) {
        IssueEntity issueEntity = issuesRepository.getReferenceById(issueId);
        return IssueDto.fromEntity(issueEntity);
    }

    @Override
    public List<IssueDto> getAllByProjectId(Long projectId) {
        List<IssueEntity> issueEntityList = issuesRepository.getAllByProjectId(projectId);
        return issueEntityList.stream().map(IssueDto::fromEntity).collect(Collectors.toList());
    }
}
