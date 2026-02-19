package com.sitepen.issuetracker.service.implementation;

import com.sitepen.issuetracker.dto.PlaceholderDto;
import com.sitepen.issuetracker.entity.PlaceholderEntity;
import com.sitepen.issuetracker.repository.PlaceholderRepository;
import com.sitepen.issuetracker.service.PlaceholderI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceholderImpl implements PlaceholderI {
    private final PlaceholderRepository placeholderRepository;

    @Autowired
    public PlaceholderImpl(PlaceholderRepository placeholderRepository) {
        this.placeholderRepository = placeholderRepository;
    }

    @Override
    public PlaceholderDto getByPlaceholderId(Long id) {
        PlaceholderEntity placeholderEntity = placeholderRepository.getByPlaceholderId(id);
        return PlaceholderDto.fromEntity(placeholderEntity);
    }
}
