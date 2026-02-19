package com.sitepen.issuetracker.service;

import com.sitepen.issuetracker.dto.IssueDto;
import com.sitepen.issuetracker.entity.IssueEntity;
import com.sitepen.issuetracker.enums.IssuePriority;
import com.sitepen.issuetracker.enums.IssueStatus;
import com.sitepen.issuetracker.repository.IssuesRepository;
import com.sitepen.issuetracker.service.implementation.IssuesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class IssuesImplTest {

    private IssuesRepository issuesRepository;
    private IssuesImpl issuesService;

    @BeforeEach
    void setUp() {
        issuesRepository = mock(IssuesRepository.class);
        issuesService = new IssuesImpl(issuesRepository);
    }

    @Test
    void getAll_returnsMappedIssueDtos() {
        IssueEntity e1 = IssueEntity.builder()
                .id(1L)
                .title("Fix login bug")
                .status(IssueStatus.IN_PROGRESS)
                .priority(IssuePriority.HIGH)
                .build();

        IssueEntity e2 = IssueEntity.builder()
                .id(2L)
                .title("Write landing page content")
                .status(IssueStatus.OPEN)
                .priority(IssuePriority.MEDIUM)
                .build();

        when(issuesRepository.getAll()).thenReturn(List.of(e1, e2));

        List<IssueDto> result = issuesService.getAll();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getId()).isEqualTo(1L);
        assertThat(result.get(0).getTitle()).isEqualTo("Fix login bug");
        assertThat(result.get(0).getStatus()).isEqualTo(IssueStatus.IN_PROGRESS);
        assertThat(result.get(0).getPriority()).isEqualTo(IssuePriority.HIGH);

        verify(issuesRepository, times(1)).getAll();
    }
}
