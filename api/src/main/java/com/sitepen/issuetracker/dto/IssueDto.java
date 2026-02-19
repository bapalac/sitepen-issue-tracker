package com.sitepen.issuetracker.dto;

import com.sitepen.issuetracker.entity.IssueEntity;
import com.sitepen.issuetracker.enums.IssuePriority;
import com.sitepen.issuetracker.enums.IssueStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueDto {
    private Long id;
    private String title;
    private String description;
    private Enum<IssueStatus> status;
    private Enum<IssuePriority> priority;
    private Long assigneeId;
    private Long projectId;

    public static IssueDto fromEntity(IssueEntity issueEntity) {
        IssueDto dto = new IssueDto();
        dto.setId(issueEntity.getId());
        dto.setTitle(issueEntity.getTitle());
        dto.setDescription(issueEntity.getDescription());
        dto.setStatus(issueEntity.getStatus());
        dto.setPriority(issueEntity.getPriority());
        dto.setAssigneeId(issueEntity.getAssigneeId());
        dto.setProjectId(issueEntity.getProjectId());

        return dto;
    }
}
