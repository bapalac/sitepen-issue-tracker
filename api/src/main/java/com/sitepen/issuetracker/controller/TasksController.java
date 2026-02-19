package com.sitepen.issuetracker.controller;

import com.sitepen.issuetracker.dto.PlaceholderDto;
import com.sitepen.issuetracker.dto.TaskDto;
import com.sitepen.issuetracker.service.TasksI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TasksController {
    @Autowired
    private TasksI tasksI;

    @GetMapping("/get-all")
    public List<TaskDto> getAll() {
        return tasksI.getAll();
    }
}
