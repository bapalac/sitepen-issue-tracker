package com.sitepen.issuetracker.service;

import com.sitepen.issuetracker.dto.TaskDto;
import com.sitepen.issuetracker.entity.TaskEntity;
import com.sitepen.issuetracker.enums.TaskPriority;
import com.sitepen.issuetracker.enums.TaskStatus;
import com.sitepen.issuetracker.repository.TasksRepository;
import com.sitepen.issuetracker.service.implementation.TasksImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TasksImplTest {

    private TasksRepository tasksRepository;
    private TasksImpl tasksService;

    @BeforeEach
    void setUp() {
        tasksRepository = mock(TasksRepository.class);
        tasksService = new TasksImpl(tasksRepository);
    }

    @Test
    void getAll_returnsMappedTaskDtos() {
        TaskEntity e1 = TaskEntity.builder()
                .id(1L)
                .title("Fix login bug")
                .status(TaskStatus.IN_PROGRESS)
                .priority(TaskPriority.HIGH)
                .build();

        TaskEntity e2 = TaskEntity.builder()
                .id(2L)
                .title("Write landing page content")
                .status(TaskStatus.OPEN)
                .priority(TaskPriority.MEDIUM)
                .build();

        when(tasksRepository.getAll()).thenReturn(List.of(e1, e2));

        List<TaskDto> result = tasksService.getAll();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getId()).isEqualTo(1L);
        assertThat(result.get(0).getTitle()).isEqualTo("Fix login bug");
        assertThat(result.get(0).getStatus()).isEqualTo(TaskStatus.IN_PROGRESS);
        assertThat(result.get(0).getPriority()).isEqualTo(TaskPriority.HIGH);

        verify(tasksRepository, times(1)).getAll();
    }
}
