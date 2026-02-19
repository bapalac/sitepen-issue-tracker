package com.sitepen.issuetracker.dto;

import com.sitepen.issuetracker.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;
    private Long ownerId;
    private String name;

    public static ProjectDto fromEntity(ProjectEntity projectEntity) {
        ProjectDto dto = new ProjectDto();
        dto.setId(projectEntity.getId());
        dto.setOwnerId(projectEntity.getOwnerId());
        dto.setName(projectEntity.getName());

        return dto;
    }
}
