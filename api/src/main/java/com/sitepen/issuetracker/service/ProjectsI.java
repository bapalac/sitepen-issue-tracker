package com.sitepen.issuetracker.service;

import com.sitepen.issuetracker.dto.ProjectDto;

import java.util.List;

public interface ProjectsI {
    public List<ProjectDto> getAll();

}
