package com.sitepen.issuetracker.repository;

import com.sitepen.issuetracker.entity.PlaceholderEntity;
import com.sitepen.issuetracker.entity.TaskEntity;
import com.sitepen.issuetracker.repository.custom.TasksRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity, Long>, TasksRepositoryCustom {
    List<TaskEntity> getAll();

//    TaskEntity getById();

    List<TaskEntity> getAllByProjectId(Long projectId);
}
