package com.sitepen.issuetracker.controller;

import com.sitepen.issuetracker.dto.IssueDto;
import com.sitepen.issuetracker.service.IssuesI;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
@RequiredArgsConstructor
public class IssueController {
    @Autowired
    private IssuesI issuesI;

    @GetMapping("/get-all")
    public List<IssueDto> getAll() {
        return issuesI.getAll();
    }

    @GetMapping("/get-all-by-project/{projectId}")
    public List<IssueDto> getAllByProjectId(@PathVariable Long projectId) {
        return issuesI.getAllByProjectId(projectId);
    }

    @GetMapping("/{issueId}")
    public IssueDto getIssueById(@PathVariable Long issueId) {
        return issuesI.getByIssueId(issueId);
    }
}
