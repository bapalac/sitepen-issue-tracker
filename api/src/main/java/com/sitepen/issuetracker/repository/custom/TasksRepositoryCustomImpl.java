package com.sitepen.issuetracker.repository.custom;

import com.sitepen.issuetracker.entity.TaskEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TasksRepositoryCustomImpl implements TasksRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TaskEntity> getAll() {
        return entityManager
                .createQuery("SELECT t FROM TaskEntity t", TaskEntity.class)
                .getResultList();
    }
}
