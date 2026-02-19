package com.sitepen.issuetracker.controller;

import com.sitepen.issuetracker.dto.ProjectDto;
import com.sitepen.issuetracker.dto.TaskDto;
import com.sitepen.issuetracker.service.ProjectsI;
import com.sitepen.issuetracker.service.TasksI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    @Autowired
    private ProjectsI projectsI;

    @GetMapping("/get-all")
    public List<ProjectDto> getAll() {
        return projectsI.getAll();
    }
}
