package com.sitepen.issuetracker.dto;

import com.sitepen.issuetracker.entity.PlaceholderEntity;
import com.sitepen.issuetracker.entity.TaskEntity;
import com.sitepen.issuetracker.enums.TaskPriority;
import com.sitepen.issuetracker.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Enum<TaskStatus> status;
    private Enum<TaskPriority> priority;
    private Long assigneeId;
    private Long projectId;

    public static TaskDto fromEntity(TaskEntity taskEntity) {
        TaskDto dto = new TaskDto();
        dto.setId(taskEntity.getId());
        dto.setTitle(taskEntity.getTitle());
        dto.setDescription(taskEntity.getDescription());
        dto.setStatus(taskEntity.getStatus());
        dto.setPriority(taskEntity.getPriority());
        dto.setAssigneeId(taskEntity.getAssigneeId());
        dto.setProjectId(taskEntity.getProjectId());

        return dto;
    }
}
