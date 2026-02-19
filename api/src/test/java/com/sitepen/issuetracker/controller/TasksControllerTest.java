package com.sitepen.issuetracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sitepen.issuetracker.dto.TaskDto;
import com.sitepen.issuetracker.enums.TaskPriority;
import com.sitepen.issuetracker.enums.TaskStatus;
import com.sitepen.issuetracker.service.TasksI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(TasksController.class)
@AutoConfigureMockMvc(addFilters = false)
class TasksControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TasksI tasksService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllTasks_returnsOkWithBody() throws Exception {
        TaskDto dto = TaskDto.builder()
                .id(1L)
                .title("Fix login bug")
                .status(TaskStatus.IN_PROGRESS)
                .priority(TaskPriority.HIGH)
                .build();

        when(tasksService.getAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/tasks/get-all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Fix login bug"))
                .andExpect(jsonPath("$[0].status").value("IN_PROGRESS"))
                .andExpect(jsonPath("$[0].priority").value("HIGH"));
    }
}
