package com.sitepen.issuetracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sitepen.issuetracker.dto.IssueDto;
import com.sitepen.issuetracker.enums.IssuePriority;
import com.sitepen.issuetracker.enums.IssueStatus;
import com.sitepen.issuetracker.service.IssuesI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IssueController.class)
@AutoConfigureMockMvc(addFilters = false)
class IssuesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IssuesI issuesService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllIssues_returnsOkWithBody() throws Exception {
        IssueDto dto = IssueDto.builder()
                .id(1L)
                .title("Fix login bug")
                .description("Fix login bug description")
                .status(IssueStatus.IN_PROGRESS)
                .priority(IssuePriority.HIGH)
                .assigneeId(1L)
                .projectId(1L)
                .build();

        when(issuesService.getAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/issues/get-all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].title").value("Fix login bug"))
                .andExpect(jsonPath("$[0].description").value("Fix login bug description"))
                .andExpect(jsonPath("$[0].status").value("IN_PROGRESS"))
                .andExpect(jsonPath("$[0].priority").value("HIGH"))
                .andExpect(jsonPath("$[0].assigneeId").value(1))
                .andExpect(jsonPath("$[0].projectId").value(1));
    }
}
