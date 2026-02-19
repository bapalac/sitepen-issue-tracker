package com.sitepen.issuetracker.service;

import com.sitepen.issuetracker.dto.PlaceholderDto;

import java.util.List;

public interface PlaceholderI {
    public PlaceholderDto getByPlaceholderId(Long id);
}
