package com.sitepen.issuetracker.repository;

import com.sitepen.issuetracker.entity.ProjectEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectsRepository extends CrudRepository<ProjectEntity, Long> {
    @Override
    List<ProjectEntity> findAll();
}
