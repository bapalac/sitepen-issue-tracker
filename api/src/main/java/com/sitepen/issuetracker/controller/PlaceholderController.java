package com.sitepen.issuetracker.controller;

import com.sitepen.issuetracker.dto.PlaceholderDto;
import com.sitepen.issuetracker.service.PlaceholderI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/placeholder")
@RequiredArgsConstructor
public class PlaceholderController {
    @Autowired
    private PlaceholderI placeholderI;

    @GetMapping("/{id}")
    public PlaceholderDto getById(@PathVariable Long id) {
        return placeholderI.getByPlaceholderId(id);
    }
}
