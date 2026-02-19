package com.sitepen.issuetracker.dto;

import com.sitepen.issuetracker.entity.PlaceholderEntity;
import lombok.Data;

@Data
public class PlaceholderDto {
    private Long placeholderId;
    private String placeholderString;

    public static PlaceholderDto fromEntity(PlaceholderEntity placeholderEntity) {
        PlaceholderDto dto = new PlaceholderDto();
        dto.setPlaceholderId(placeholderEntity.getPlaceholderId());
        dto.setPlaceholderString(placeholderEntity.getPlaceholderString());

        return dto;
    }
}
