package com.sitepen.issuetracker.service.implementation;

import com.sitepen.issuetracker.dto.ProjectDto;
import com.sitepen.issuetracker.entity.ProjectEntity;
import com.sitepen.issuetracker.repository.ProjectsRepository;
import com.sitepen.issuetracker.service.ProjectsI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectsImpl implements ProjectsI {
    private final ProjectsRepository projectsRepository;

    @Autowired
    public ProjectsImpl(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    @Override
    public List<ProjectDto> getAll() {
        List<ProjectEntity> projectEntityList = projectsRepository.findAll();
        return projectEntityList.stream().map(ProjectDto::fromEntity).collect(Collectors.toList());
    }
}
