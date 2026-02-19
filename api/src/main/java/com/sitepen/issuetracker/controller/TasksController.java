package com.sitepen.issuetracker.controller;

import com.sitepen.issuetracker.dto.PlaceholderDto;
import com.sitepen.issuetracker.dto.TaskDto;
import com.sitepen.issuetracker.service.TasksI;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/get-all-by-project/{projectId}")
    public List<TaskDto> getAllByProjectId(@PathVariable Long projectId) {
        return tasksI.getAllByProjectId(projectId);
    }

    @GetMapping("/{taskId}")
    public TaskDto getTaskById(@PathVariable Long taskId) {
        System.out.println("tasks");
        return tasksI.getByTaskId(taskId);
    }
}
