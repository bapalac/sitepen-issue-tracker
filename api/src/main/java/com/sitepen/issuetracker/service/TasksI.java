package com.sitepen.issuetracker.service;

import com.sitepen.issuetracker.dto.PlaceholderDto;
import com.sitepen.issuetracker.dto.TaskDto;

import java.util.List;

public interface TasksI {
    public List<TaskDto> getAll();

    public TaskDto getByTaskId(Long taskId);

    public List<TaskDto> getAllByProjectId(Long projectId);
}
