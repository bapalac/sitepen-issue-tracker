package com.sitepen.issuetracker.service.implementation;

import com.sitepen.issuetracker.dto.PlaceholderDto;
import com.sitepen.issuetracker.dto.TaskDto;
import com.sitepen.issuetracker.entity.PlaceholderEntity;
import com.sitepen.issuetracker.entity.TaskEntity;
import com.sitepen.issuetracker.repository.PlaceholderRepository;
import com.sitepen.issuetracker.repository.TasksRepository;
import com.sitepen.issuetracker.service.TasksI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksImpl implements TasksI {
    private final TasksRepository tasksRepository;

    @Autowired
    public TasksImpl(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    @Override
    public List<TaskDto> getAll() {
        List<TaskEntity> taskEntityList = tasksRepository.getAll();
        return taskEntityList.stream().map(TaskDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public TaskDto getByTaskId(Long taskId) {
        TaskEntity taskEntity = tasksRepository.getReferenceById(taskId);
        return TaskDto.fromEntity(taskEntity);
    }

    @Override
    public List<TaskDto> getAllByProjectId(Long projectId) {
        List<TaskEntity> taskEntityList = tasksRepository.getAllByProjectId(projectId);
        return taskEntityList.stream().map(TaskDto::fromEntity).collect(Collectors.toList());
    }
}
