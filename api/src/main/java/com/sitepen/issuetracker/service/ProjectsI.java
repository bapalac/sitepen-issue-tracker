package com.sitepen.issuetracker.service;

import com.sitepen.issuetracker.dto.ProjectDto;
import com.sitepen.issuetracker.dto.TaskDto;

import java.util.List;

public interface ProjectsI {
    public List<ProjectDto> getAll();

}
