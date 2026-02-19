package com.sitepen.issuetracker.repository.custom;

import com.sitepen.issuetracker.entity.TaskEntity;

import java.util.List;

public interface TasksRepositoryCustom {
    List<TaskEntity> getAll();
}
