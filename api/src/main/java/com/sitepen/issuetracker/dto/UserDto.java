package com.sitepen.issuetracker.dto;

import com.sitepen.issuetracker.entity.UserEntity;
import com.sitepen.issuetracker.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Enum<UserRole> role;
    private String email;

    public static UserDto fromEntity(UserEntity userEntity) {
        UserDto dto = new UserDto();
        dto.setId(userEntity.getId());
        dto.setFirstName(userEntity.getFirstName());
        dto.setLastName(userEntity.getLastName());
        dto.setRole(userEntity.getRole());
        dto.setEmail(userEntity.getEmail());

        return dto;
    }
}
