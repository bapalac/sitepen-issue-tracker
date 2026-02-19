package com.sitepen.issuetracker.repository;

import com.sitepen.issuetracker.dto.PlaceholderDto;
import com.sitepen.issuetracker.entity.PlaceholderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceholderRepository extends JpaRepository<PlaceholderEntity, Long> {
    PlaceholderEntity getByPlaceholderId(Long id);
}
