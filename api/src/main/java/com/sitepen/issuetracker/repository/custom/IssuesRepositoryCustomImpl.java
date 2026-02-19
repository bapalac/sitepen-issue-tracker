package com.sitepen.issuetracker.repository.custom;

import com.sitepen.issuetracker.entity.IssueEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IssuesRepositoryCustomImpl implements IssuesRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<IssueEntity> getAll() {
        return entityManager
                .createQuery("SELECT t FROM IssueEntity t", IssueEntity.class)
                .getResultList();
    }
}
